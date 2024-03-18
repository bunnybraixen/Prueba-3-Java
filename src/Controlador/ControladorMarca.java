package Controlador;

import BD.Conexion;
import Modelo.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorMarca {
    
    public boolean agregar(Marca marca)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "INSERT INTO Marca (nombre) VALUES (?)";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setString(1, marca.getNombre());
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
    public boolean actualizar(Marca marca)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "UPDATE Marca SET nombre  = ? WHERE idMarca = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setString(1, marca.getNombre());
            st.setInt(2, marca.getId());
            
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
    public boolean eliminar(int id)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "DELETE FROM Marca WHERE idMarca = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, id);
            
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
    public Marca buscarPorId(int idMarca)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idMarca,nombre FROM Marca WHERE idMarca=?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, idMarca);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                Marca marca = new Marca();
                marca.setId(rs.getInt("idMarca"));
                marca.setNombre(rs.getString("nombre"));
                return marca;
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
    public ArrayList<Marca> buscarTodos()
    {
        ArrayList<Marca> listado = new ArrayList<Marca>();
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idMarca, nombre FROM Marca";
            PreparedStatement st;

            st = cx.prepareStatement(sql);           
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                Marca marca = new Marca();
                marca.setId(rs.getInt("idMarca"));
                marca.setNombre(rs.getString("nombre"));
                listado.add(marca);
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
