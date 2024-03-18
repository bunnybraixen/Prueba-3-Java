/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author papo2
 */
public class Cargo {
    int idCargo;
    String nombre;
    
    public Cargo() {
        this.idCargo = 0;
        this.nombre = "";
    }
    public Cargo(int idCargo, String nombre) {
        this.idCargo = idCargo;
        this.nombre = nombre;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void limpiar()
    {
        this.idCargo = 0;
        this.nombre = "";
    }

    @Override
    public String toString() {
        return "Cargo{" + "idCargo=" + idCargo + ", nombre=" + nombre + '}';
    }
    
    
}
