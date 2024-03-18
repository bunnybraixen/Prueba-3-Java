package Modelo;


public abstract class Persona  {
    int idPersona;
    int rut;
    String digito;
    String nombre;
    String apellido;
    int sueldo;
    Boolean esCliente;
    Boolean habilitado;
    Comuna comuna;
    Cargo cargo;
    
    public Persona(){
        this.idPersona = 0;
        this.rut = 0;
        this.digito = "";
        this.nombre = "";
        this.apellido = "";
        this.sueldo = 0;
        this.esCliente = false;
        this.habilitado = false;
        this.comuna = null;
        this.cargo = null;
        
       
    }

    public Persona(int idPersona, int rut, String digito, String nombre, String apellido, int sueldo, Boolean esCliente, Boolean habilitado, Comuna comuna, Cargo cargo) {
        this.idPersona = idPersona;
        this.rut = rut;
        this.digito = digito;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.esCliente = esCliente;
        this.habilitado = habilitado;
        this.comuna = comuna;
        this.cargo = cargo;
    }

 

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public Boolean getEsCliente() {
        return esCliente;
    }

    public void setEsCliente(Boolean esCliente) {
        this.esCliente = esCliente;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    





}