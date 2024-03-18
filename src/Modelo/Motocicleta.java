package Modelo;



public class Motocicleta extends Vehiculo{
    String estilo;
    int medidaManillar;

    
    public Motocicleta() {
        super(0, "", "", null);
        this.estilo = "";
        this.medidaManillar = 0;
    }
    
    public Motocicleta(int id, String patente, String modelo, String estilo, int medidaManillar, Marca marca) {
        super(id, patente, modelo, marca);
        this.estilo = estilo;
        this.medidaManillar = medidaManillar;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getMedidaManillar() {
        return medidaManillar;
    }

    public void setMedidaManillar(int medidaManillar) {
        this.medidaManillar = medidaManillar;
    }
    
    

    

    
}
