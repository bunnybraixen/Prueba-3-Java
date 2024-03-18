
package Modelo;


public class Especialidad extends Empleado {
    int idEspecialidad;
    String nombreEspecialidad;
    Boolean habilitado;

    public Especialidad() {
        super(0, 0, 0, "", "", "", 0,false, false, null, null);
        this.idEspecialidad = 0;
        this.nombreEspecialidad = "";
        this.habilitado = null;
    }

    public Especialidad(int idEspecialidad, String nombreEspecialidad, Boolean habilitado, int sueldo, int idPersona, int rut, String digito, String nombre, String apellido, Boolean esCliente, Comuna comuna, Cargo cargo) {
        super(sueldo, idPersona, rut, digito, nombre, apellido, sueldo, habilitado, esCliente, comuna, cargo);
        this.idEspecialidad = idEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
        this.habilitado = habilitado;
    }
       

 

        public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "idEspecialidad=" + idEspecialidad + ", nombreEspecialidad=" + nombreEspecialidad + ", habilitado=" + habilitado + '}';
    }
    
    public void limpiar()
    {
        this.idEspecialidad = 0;
        this.nombre = "";
        this.habilitado = false; 
    }
}
