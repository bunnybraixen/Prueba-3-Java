/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author papo2
 */
public class Comuna {
    int idComuna;
    String nombre;
    
    public Comuna() {
        this.idComuna = 0;
        this.nombre = "";
    }
    public Comuna(int idComuna, String nombre) {
        this.idComuna = idComuna;
        this.nombre = nombre;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public void limpiar()
    {
        this.idComuna = 0;
        this.nombre = "";
    }

    @Override
    public String toString() {
        return "Comuna{" + "idComuna=" + idComuna + ", nombre=" + nombre + '}';
    }
     
     
}
