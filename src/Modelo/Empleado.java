/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author papo2
 */
public class Empleado extends Persona{
    int sueldo;
    String especialidad;

    public Empleado(int sueldo, int idPersona, int rut, String digito, String nombre, String apellido, int Sueldo, Boolean esCliente, Boolean habilitado,Comuna comuna, Cargo cargo) {
        super(idPersona, rut, digito, nombre, apellido, sueldo, esCliente, habilitado, comuna, cargo);
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
