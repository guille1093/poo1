package com.fuerza.vistas.ABMCliente;

import com.fuerza.modelos.Cliente;
import com.fuerza.servicios.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class ABMClienteManager {
    @Autowired
    ABMCliente abmCliente;

    @Autowired
    private ClienteServiceImpl clienteService;

    public void LimpiarCampos()
    {
        abmCliente.TFdniC.clear();
        abmCliente.TFnombreC.clear();
        abmCliente.TFapellidoC.clear();
        abmCliente.TFpesoC.clear();
        abmCliente.TFestaturaC.clear();
        abmCliente.CBsexoC.getSelectionModel().clearSelection();
        abmCliente.DPfechanacC.getEditor().clear();
    }

    public void CargarDetallesCliente()
    {
        abmCliente.ClienteList.clear();
        abmCliente.ClienteList.addAll(clienteService.findAll());
        abmCliente.TdatosC.setItems(abmCliente.ClienteList);
    }

    public void RegistrarCliente()
    {
        Cliente cliente = new Cliente();
        cliente.setNombre(abmCliente.TFnombreC.getText());
        cliente.setApellido(abmCliente.TFapellidoC.getText());
        cliente.setDni(abmCliente.TFdniC.getText());
        cliente.setPeso(Double.parseDouble(abmCliente.TFpesoC.getText()));
        cliente.setEstatura(Double.parseDouble(abmCliente.TFestaturaC.getText()));
        cliente.setFechaNacimiento(abmCliente.DPfechanacC.getValue());
        cliente.setSexo(abmCliente.CBsexoC.getSelectionModel().getSelectedItem());
        cliente.setFechaIngreso(LocalDate.from(LocalDateTime.now()));
        Cliente newCliente = clienteService.save(cliente);
    }

    public void EliminarCliente()
    {
        Cliente cliente = abmCliente.TdatosC.getSelectionModel().getSelectedItem();
        clienteService.delete(cliente);
    }

}
