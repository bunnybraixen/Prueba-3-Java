package Modelo;



public class Automovil extends Vehiculo{
    int litrosMaletero;
    public int cantidadPuertas;

    
    public Automovil() {
        super(0, "", "", null);
        this.litrosMaletero = 0;
        this.cantidadPuertas = 0;
    }
    
    public Automovil(int id, String patente, String modelo, String estilo, int litrosMaletero, int cantidadPuertas, Marca marca) {
        super(id, patente, modelo, marca);
        this.litrosMaletero = litrosMaletero;
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getLitrosMaletero() {
        return litrosMaletero;
    }

    public void setLitrosMaletero(int litrosMaletero) {
        this.litrosMaletero = litrosMaletero;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }


    
    

    

    
}
