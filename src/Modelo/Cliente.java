/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Cliente extends Persona {
    boolean cliente;

    public Cliente(boolean cliente, int idPersona, int rut, String digito, String nombre, String apellido, int sueldo, Boolean esCliente, Boolean habilitado, Comuna comuna, Cargo cargo) {
        super(idPersona, rut, digito, nombre, apellido, sueldo, esCliente, habilitado, comuna, cargo);
        this.cliente = cliente;
    }
    
    public boolean isCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }
    
}
