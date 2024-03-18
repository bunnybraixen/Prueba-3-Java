package Controlador;

import BD.Conexion;
import Modelo.Cargo;
import Modelo.Comuna;
import Modelo.Especialidad;
import Modelo.Marca;
import Modelo.Persona;
import Vista.FrmPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorPersona {
    
    public boolean agregar(Persona persona, Cargo cargo, Especialidad especialidad, Comuna comuna)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();
            FrmPersona frmpersona = new FrmPersona();
            String sql = "INSERT INTO Persona (idCargo, idEspecialidad, idComuna, rut, digito, nombre, apellido, sueldo, esCliente, habilitado) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, cargo.getIdCargo()); 
            st.setInt(2, especialidad.getIdEspecialidad());
            st.setInt(3, comuna.getIdComuna());
            st.setInt(4, persona.getRut());
            st.setString(5, persona.getDigito());
            st.setString(6, persona.getNombre());
            st.setString(7, persona.getApellido());
            if (persona.getEsCliente() == true) {
                st.setInt(8, 0);
            }
            else {
                st.setInt(8, persona.getSueldo());
                
            }
            st.setBoolean(9, persona.getEsCliente());
            st.setBoolean(10, persona.getHabilitado());

            st.executeUpdate();
            st.close();
            cx.close();
            return true;
        } catch (SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    }
    public boolean actualizar(Persona persona, Cargo cargo, Especialidad especialidad, Comuna comuna)
    {
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();
            String sql = "UPDATE Persona SET idCargo = ?, idEspecialidad = ?, idComuna = ?, rut = ?, digito = ?, nombre = ?, apellido = ?, sueldo = ?, esCliente = ?, habilitado = ? WHERE idPersona = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, cargo.getIdCargo()); 
            st.setInt(2, especialidad.getIdEspecialidad());
            st.setInt(3, comuna.getIdComuna());
            st.setInt(4, persona.getRut());
            st.setString(5, persona.getDigito());
            st.setString(6, persona.getNombre());
            st.setString(7, persona.getApellido());
            if (persona.getEsCliente() == true) {
                st.setInt(8, 0);
            }
            else {
                st.setInt(8, persona.getSueldo());
                
            }
            st.setBoolean(9, persona.getEsCliente());
            st.setBoolean(10, persona.getHabilitado());
            st.setInt(11, persona.getIdPersona());
            st.executeUpdate();
            st.close();
            cx.close();
            return true;
        } catch (SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    } }
    public boolean eliminar(int id)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "DELETE FROM Persona WHERE idPersona = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, id);
            
            st.executeUpdate();
            st.close(); // cierra declaración
            cx.close(); // cierra conexión a la BDD
            return true;
        } catch (SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    }
    public Persona buscarPorId(int id)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idPersona, rut, digito, nombre, apellido, sueldo, esCliente, habilitado FROM Persona WHERE idPersona=?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                Persona persona = new Persona() {};
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setRut(rs.getInt("rut"));
                persona.setDigito(rs.getString("digito"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setSueldo(rs.getInt("sueldo"));
                persona.setEsCliente(rs.getBoolean("esCliente"));
                persona.setHabilitado(rs.getBoolean("habilitado"));
                return persona;
            }
            st.close(); // cierra declaración
            cx.close(); // cierra conexión a la BDD
            return null;
        } catch (SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }
    public ArrayList<Persona> buscarTodos()
    {
        ArrayList<Persona> listado = new ArrayList<Persona>();
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idPersona, rut, digito, nombre, apellido, sueldo, esCliente, habilitado FROM Persona";
            PreparedStatement st;

            st = cx.prepareStatement(sql);           
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                Persona persona = new Persona() {};
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setRut(rs.getInt("rut"));
                persona.setDigito(rs.getString("digito"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setSueldo(rs.getInt("sueldo"));
                persona.setEsCliente(rs.getBoolean("esCliente"));
                persona.setHabilitado(rs.getBoolean("habilitado"));

                listado.add(persona);
            }
            st.close(); // cierra declaración
            cx.close(); // cierra conexión a la BDD
        } catch (SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return listado;
    }
}
