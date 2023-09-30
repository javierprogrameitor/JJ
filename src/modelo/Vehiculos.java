package modelo;

/**
 *
 * @author javier
 */
public class Vehiculos {
    
    private String dniPropietario;
    private String nombrePropietario;
    private String marca;
    private String matricula;
    private int Kilometros;
    private String descripcion;
    private float precio;

    public Vehiculos(String dniPropietario, String nombrePropietario, String marca, String matricula, int Kilometros, String descripcion, float precio) {
        this.dniPropietario = dniPropietario;
        this.nombrePropietario = nombrePropietario;
        this.marca = marca;
        this.matricula = matricula;
        this.Kilometros = Kilometros;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKilometros() {
        return Kilometros;
    }

    public void setKilometros(int Kilometros) {
        this.Kilometros = Kilometros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
}
