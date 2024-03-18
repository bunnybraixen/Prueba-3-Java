
package Modelo;

public class Marca extends Vehiculo{
    private int idMarca;
    private String nombre;
    
    public Marca() {
        super(0, "", "", null);
        this.idMarca = 0;
        this.nombre = "";
    }

    public Marca(int idMarca, String nombre, int idVehiculo, String patente, String modelo, Marca marca) {
        super(idVehiculo, patente, modelo, marca);
        this.idMarca = idMarca;
        this.nombre = nombre;
    }
    
    

    public int getId() {
        return idMarca;
    }

    public void setId(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + ", nombre=" + nombre + '}';
    }
    
    public void limpiar()
    {
        this.idMarca = 0;
        this.nombre = "";
    }
}
