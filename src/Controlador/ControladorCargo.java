package Controlador;

import BD.Conexion;
import Modelo.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCargo {
    
    public boolean agregar(Cargo cargo)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();
            String sql = "INSERT INTO Cargo (nombre) VALUES (?)";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setString(1, cargo.getNombre());
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
    public boolean actualizar(Cargo cargo)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "UPDATE Cargo SET nombre = ? WHERE idCargo = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setString(1, cargo.getNombre());
            st.setInt(2, cargo.getIdCargo());
            
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
    public boolean eliminar(int idCargo)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "DELETE FROM Cargo WHERE idCargo = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, idCargo);
            
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
    public Cargo buscarPorId(int idCargo)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idCargo, nombre FROM Cargo WHERE idCargo=?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, idCargo);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                Cargo cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setNombre(rs.getString("nombre"));
                return cargo;
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
    public ArrayList<Cargo> buscarTodos()
    {
        ArrayList<Cargo> listado = new ArrayList<Cargo>();
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idCargo, nombre FROM Cargo";
            PreparedStatement st;

            st = cx.prepareStatement(sql);           
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                Cargo cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setNombre(rs.getString("nombre"));
                listado.add(cargo);
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
