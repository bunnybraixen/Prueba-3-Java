package Controlador;

import BD.Conexion;
import Modelo.Comuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorComuna {
    
    public boolean agregar(Comuna comuna)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();
            String sql = "INSERT INTO Comuna (nombre) VALUES (?)";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setString(1, comuna.getNombre());
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
    public boolean actualizar(Comuna comuna)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "UPDATE Comuna SET nombre = ? WHERE idComuna = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setString(1, comuna.getNombre());
            st.setInt(2, comuna.getIdComuna());
            
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
    public boolean eliminar(int idComuna)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "DELETE FROM Comuna WHERE idComuna = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, idComuna);
            
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
    public Comuna buscarPorId(int idComuna)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idComuna, nombre FROM Comuna WHERE idComuna=?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, idComuna);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                Comuna comuna = new Comuna();
                comuna.setIdComuna(rs.getInt("idComuna"));
                comuna.setNombre(rs.getString("nombre"));
                return comuna;
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
    public ArrayList<Comuna> buscarTodos()
    {
        ArrayList<Comuna> listado = new ArrayList<Comuna>();
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idComuna, nombre FROM Comuna";
            PreparedStatement st;

            st = cx.prepareStatement(sql);           
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                Comuna comuna = new Comuna();
                comuna.setIdComuna(rs.getInt("idComuna"));
                comuna.setNombre(rs.getString("nombre"));
                listado.add(comuna);
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
