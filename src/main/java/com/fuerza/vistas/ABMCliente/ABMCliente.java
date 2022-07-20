package com.fuerza.vistas.ABMCliente;

import com.fuerza.modelos.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import com.fuerza.vistas.FxController;
import java.net.URL;
import java.util.ResourceBundle;
@Controller
@FxmlView
//@Lazy
public class ABMCliente implements Initializable, FxController {
    @Autowired
    @Lazy
    private ABMClienteManager abmClienteManager;
    final ObservableList<Cliente> ClienteList = FXCollections.observableArrayList();
    final ObservableList<String> sexo = FXCollections.observableArrayList("Masculino", "Femenino");

    //Botones
    @FXML
    private Button BTregistrarC;
    @FXML
    private Button BTactualizarC;
    @FXML
    private Button BTeliminarC;

    //Campos de texto
    @FXML
    public TextField TFdniC;
    @FXML
    public TextField TFnombreC;
    @FXML
    public TextField TFapellidoC;
    @FXML
    public TextField TFpesoC;
    @FXML
    public TextField TFestaturaC;

    //Combo Box
    @FXML
    public ComboBox<String> CBsexoC;

    //Date Picker
    @FXML
    public DatePicker DPfechanacC;

    //Tabla
    @FXML
    public TableView<Cliente> TdatosC;
    //Columnas
    @FXML
    private TableColumn<Cliente, String> TCdniC;
    @FXML
    private TableColumn<Cliente, String> TCnombreC;
    @FXML
    private TableColumn<Cliente, String> TCapellidoC;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CBsexoC.setItems(sexo);
        abmClienteManager.LimpiarCampos();
        TCdniC.setCellValueFactory(new PropertyValueFactory<>("dni"));
        TCnombreC.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TCapellidoC.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        TdatosC.setItems(ClienteList);
        abmClienteManager.CargarDetallesCliente(); //Carga los datos de la tabla o sea es re obvio, pero lo anoto igual xd
        //Acciones de los botoncitos :D
        BTregistrarC.setOnAction(event ->
        {
            abmClienteManager.RegistrarCliente();
            abmClienteManager.CargarDetallesCliente();
            abmClienteManager.LimpiarCampos();
        });

        BTactualizarC.setOnAction(event ->
                abmClienteManager.CargarDetallesCliente());

        BTeliminarC.setOnAction(event ->
        {
            abmClienteManager.EliminarCliente();
            abmClienteManager.CargarDetallesCliente();
            abmClienteManager.LimpiarCampos();
        });
    }

}
