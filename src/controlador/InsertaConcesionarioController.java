package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Vehiculos;

/**
 * FXML Controller class
 *
 * @author javier
 */
public class InsertaConcesionarioController implements Initializable {

    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtKilomeros;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private TextField txtPrecio;

    private Vehiculos vehiculo;  // Objeto vehiculo

    private ObservableList<Vehiculos> vehiculos; // ObservableList almacena los vehiculos
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void atributos(ObservableList<Vehiculos> vehiculos) {
        this.vehiculos = vehiculos;
    }

      public void atributosVH(ObservableList<Vehiculos> vehiculos, Vehiculos v) {
        this.vehiculos = vehiculos;
        this.vehiculo = v;
        
        this.txtDni.setText(v.getDniPropietario());
        this.txtNombre.setText(v.getNombrePropietario());
        this.txtMarca.setText(v.getMarca());
        this.txtMatricula.setText(v.getMatricula());
        this.txtKilomeros.setText(v.getKilometros() + "");
        this.txtDescripcion.setText(v.getDescripcion());
        this.txtPrecio.setText(v.getPrecio() + "");
    }

    
    public Vehiculos dameVehiculos() {
        return vehiculo;
    }

    @FXML
    private void guardar(ActionEvent event) {
          /*
        Recojo los datos de los txt
        */
        String dniP = this.txtDni.getText();
        String nombreP = this.txtNombre.getText();
        String marca = this.txtMarca.getText();
        String matricula = this.txtMatricula.getText();
        int Kilometros = Integer.parseInt(this.txtKilomeros.getText());
        String descripcion = this.txtDescripcion.getText();
        Float precio = Float.parseFloat(this.txtPrecio.getText());
        /*
        Creo el vehiculo
        */
        Vehiculos v = new Vehiculos(dniP, nombreP, marca, matricula, Kilometros, descripcion, precio);
     
        if (!vehiculos.contains(v)) {   // Si no esta en el observableList

           
            if (this.vehiculo != null) {  // Si el vehiculo que le paso existe, lo modifico

                // Modifico el objeto
                this.vehiculo.setDniPropietario(dniP);
                this.vehiculo.setNombrePropietario(nombreP);
                this.vehiculo.setMarca(marca);
                this.vehiculo.setMatricula(matricula);
                this.vehiculo.setKilometros(Kilometros);
                this.vehiculo.setDescripcion(descripcion);
                this.vehiculo.setPrecio(precio);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha modificado correctamente");
                alert.showAndWait();

            } else {              //Si no se añade a la table
               
                this.vehiculo = v;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();

            }

            // Cerrar la ventana
            Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El vehiculo ya existe");
            alert.showAndWait();
        }

    }

    @FXML
    private void salir(ActionEvent event) {

        this.vehiculo = null;
        // Cerrar la ventana
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }
}
