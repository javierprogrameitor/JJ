package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Vehiculos;

/**
 * FXML Controller class
 *
 * @author javier
 */
public class ConcesionarioController implements Initializable {

    @FXML
    private TableView<Vehiculos> tblView;
    @FXML
    private TableColumn tblDni;
    @FXML
    private TableColumn tblPropietarioNombre;
    @FXML
    private TableColumn tblMarca;
    @FXML
    private TableColumn tblMatricula;
    @FXML
    private TableColumn tblKilometros;
    @FXML
    private TableColumn tblDescripcion;
    @FXML
    private TableColumn tblPrecio;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEliminar;

    private ObservableList<Vehiculos> vehiculos;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        vehiculos = FXCollections.observableArrayList();
        this.tblView.setItems(vehiculos);

        this.tblDni.setCellValueFactory(new PropertyValueFactory("dniPropietario"));
        this.tblPropietarioNombre.setCellValueFactory(new PropertyValueFactory("nombrePropietario"));
        this.tblMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        this.tblMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.tblKilometros.setCellValueFactory(new PropertyValueFactory("Kilometros"));
        this.tblDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.tblPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
    }

    @FXML
    private void Guardar(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InsertaConcesionario.fxml")); // Cargo la vista

            Parent root = loader.load();  // Cargo la ventana

            InsertaConcesionarioController controlador = loader.getController();

            controlador.atributos(vehiculos);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Vehiculos v = controlador.dameVehiculos();

            if (v != null) {

                this.vehiculos.add(v);

                this.tblView.refresh();
            }

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();

        }

    }

    @FXML
    private void Modificar(ActionEvent event) {

        Vehiculos v = this.tblView.getSelectionModel().getSelectedItem(); // Recojo de la tabla el vehiculo

        if (v == null) {  // Si no hay nada seleccionado
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Para modificar primero hay que seleccionar un vehiculo");
            alert.showAndWait();

        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InsertaConcesionario.fxml")); // Vuelvo a cargar la vista

                Parent root = loader.load();  // Cargo la ventana

                InsertaConcesionarioController controlador = loader.getController();

                controlador.atributosVH(vehiculos, v);

                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                Vehiculos vh = controlador.dameVehiculos();  //Cojo el vehiculo modificado

                if (vh != null) {

                    this.tblView.refresh();
                }

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }

        }

    }

    @FXML
    private void Eliminar(ActionEvent event) {

        Vehiculos v = this.tblView.getSelectionModel().getSelectedItem(); // Recojo de la tabla el vehiculo

        if (v == null) {  // Si no hay nada seleccionado
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Para Eliminar primero hay que seleccionar un vehiculo");
            alert.showAndWait();

        } else {
            this.vehiculos.remove(v);
            this.tblView.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Eliminaste el Vehiculo");
            alert.showAndWait();
        }
    }

}
