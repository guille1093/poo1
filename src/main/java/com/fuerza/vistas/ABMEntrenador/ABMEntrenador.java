package com.fuerza.vistas.ABMEntrenador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;
import com.fuerza.vistas.FxController;
import java.net.URL;
import java.util.ResourceBundle;
@Controller
@FxmlView
public class ABMEntrenador implements Initializable, FxController {


        //botones
        @FXML
        private Button BTregistrarE;
        @FXML
        private Button BTactualizarE;
        @FXML
        private Button BTeliminarE;

        //Campos de texto
        @FXML
        private TextField TFdniE;
        @FXML
        private TextField TFnombreE;
        @FXML
        private TextField TFapellidoE;

        //Tabla
        @FXML
        private TableView TdatosE;
        //Columnas
        @FXML
        private TableColumn TCdniE;
        @FXML
        private TableColumn TCnombreE;
        @FXML
        private TableColumn TCapellidoE;

        //Prueba combobox
        /*@FXML
        private ComboBox<Entrenador> CBE;
        */ //comentado por ahora hasta que funque la base de datos xd

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
}
