package Controlador;

import BD.Conexion;
import Modelo.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorEspecialidad {
    
    public boolean agregar(Especialidad especialidad)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "INSERT INTO Especialidad (nombre, habilitado) VALUES (?,?)";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setString(1, especialidad.getNombreEspecialidad());
            if (especialidad.isHabilitado() == true) {
                st.setInt(2, 1);
            }
            else {
                st.setInt(2, 0);
            }
                
            
            
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
    public boolean actualizar(Especialidad especialidad)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "UPDATE Especialidad SET nombre = ?, habilitado = ? WHERE idEspecialidad = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setString(1, especialidad.getNombreEspecialidad());
            if (especialidad.isHabilitado() == true) {
                st.setInt(2, 1);
            }
            else {
                st.setInt(2, 0);
            }
            st.setInt(3, especialidad.getIdEspecialidad());
            
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
    public boolean eliminar(int idEspecialidad)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "DELETE FROM especialidad WHERE idEspecialidad = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, idEspecialidad);
            
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
    public Especialidad buscarPorId(int idEspecialidad)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idEspecialidad, nombre, habilitado FROM Especialidad WHERE idEspecialidad=?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, idEspecialidad);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                Especialidad especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setNombreEspecialidad(rs.getString("nombre"));
                especialidad.setHabilitado(rs.getBoolean("habilitado"));
                return especialidad;
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
    public ArrayList<Especialidad> buscarTodos()
    {
        ArrayList<Especialidad> listado = new ArrayList<Especialidad>();
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idEspecialidad, nombre, habilitado FROM Especialidad";
            PreparedStatement st;

            st = cx.prepareStatement(sql);           
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                Especialidad especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setNombreEspecialidad(rs.getString("nombre"));
                especialidad.setHabilitado(rs.getBoolean("habilitado"));
                listado.add(especialidad);
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
