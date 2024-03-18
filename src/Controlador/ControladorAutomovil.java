package Controlador;

import BD.Conexion;
import Modelo.Automovil;
import Modelo.Marca;
import Modelo.Persona;
import Vista.FrmVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorAutomovil {
    
    public boolean agregar(Automovil automovil, Persona persona, Marca marca)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();
            FrmVehiculo frmvehiculo = new FrmVehiculo();
            String sql = "INSERT INTO Vehiculo (idPersona, idMarca, patente, modelo, litrosMaletero, cantidadPuerta, largoManillar, estilo) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, persona.getIdPersona());
            st.setInt(2, marca.getId()); 
            st.setString(3, automovil.getPatente());
            st.setString(4, automovil.getModelo());
            st.setInt(5, automovil.getLitrosMaletero());
            st.setInt(6, automovil.getCantidadPuertas());
            st.setInt(7, 0);
            st.setString(8, "x");
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
    public boolean actualizar(Automovil automovil, Persona persona, Marca marca)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "UPDATE Vehiculo SET idPersona = ?, idMarca = ?, patente = ?, modelo = ?, litrosMaletero = ?, cantidadPuerta = ?, largoManillar = ?, estilo = ? WHERE idVehiculo = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, persona.getIdPersona());
            st.setInt(2, marca.getId());
            st.setString(3, automovil.getPatente());
            st.setString(4, automovil.getModelo());
            st.setInt(5, automovil.getLitrosMaletero());
            st.setInt(6, automovil.getCantidadPuertas());
            st.setInt(7, 0);
            st.setString(8, "");
            st.setInt(9, automovil.getIdVehiculo());
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
    public boolean eliminar(int id)
    {
        try{
            System.out.println(id);
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "DELETE FROM Vehiculo WHERE idVehiculo = ?";
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
    public Automovil buscarPorId(int id)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idVehiculo, patente, modelo, cantidadPuerta, litrosMaletero FROM Vehiculo WHERE idVehiculo=?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                Automovil automovil = new Automovil() {};
                automovil.setIdVehiculo(rs.getInt("idVehiculo"));
                automovil.setPatente(rs.getString("patente"));
                automovil.setModelo(rs.getString("modelo"));
                automovil.setCantidadPuertas(rs.getInt("cantidadPuerta"));
                automovil.setLitrosMaletero(rs.getInt("litrosMaletero"));
                return automovil;
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
    public ArrayList<Automovil> buscarTodos()
    {
        ArrayList<Automovil> listado = new ArrayList<Automovil>();
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idVehiculo, patente, modelo, litrosMaletero, cantidadPuerta FROM Vehiculo";
            PreparedStatement st;

            st = cx.prepareStatement(sql);           
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                Automovil automovil = new Automovil() {};
                automovil.setIdVehiculo(rs.getInt("idVehiculo"));
                automovil.setPatente(rs.getString("patente"));
                automovil.setModelo(rs.getString("modelo"));
                automovil.setLitrosMaletero(rs.getInt("litrosMaletero"));
                automovil.setCantidadPuertas(rs.getInt("cantidadPuerta"));

                listado.add(automovil);
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
