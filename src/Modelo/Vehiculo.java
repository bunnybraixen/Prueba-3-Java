package Modelo;


public abstract class Vehiculo  {
    int idVehiculo;
    String patente;
    String modelo;
    Marca marca;
    
    public Vehiculo() {
        this.idVehiculo = 0;
        this.patente = "";
        this.modelo = "";
        this.marca = null;
    }

    public Vehiculo(int idVehiculo, String patente, String modelo, Marca marca) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

public void limpiar()
    {
        this.patente = "";
        this.idVehiculo = 0;
        this.modelo = ""; 
    }

   
   
}
    
    
    