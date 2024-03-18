package Controlador;

import BD.Conexion;
import Modelo.Marca;
import Modelo.Motocicleta;
import Modelo.Persona;
import Vista.FrmVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorMotocicleta {
    
    public boolean agregar(Motocicleta motocicleta, Persona persona, Marca marca)
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
            st.setString(3, motocicleta.getPatente());
            st.setString(4, motocicleta.getModelo());
            st.setInt(5, 0);
            st.setInt(6, 0);
            st.setInt(7, motocicleta.getMedidaManillar());
            st.setString(8, motocicleta.getEstilo());
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
    public boolean actualizar(Motocicleta motocicleta, Persona persona, Marca marca)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "UPDATE Vehiculo SET idPersona = ?, idMarca = ?, patente = ?, modelo = ?, litrosMaletero = ?, cantidadPuerta = ?, largoManillar = ?, estilo = ? WHERE idVehiculo = ?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, persona.getIdPersona());
            st.setInt(2, marca.getId());
            st.setString(3, motocicleta.getPatente());
            st.setString(4, motocicleta.getModelo());
            st.setInt(5, 0);
            st.setInt(6, 0 );
            st.setInt(7, motocicleta.getMedidaManillar());
            st.setString(8, motocicleta.getEstilo());
            st.setInt(9, motocicleta.getIdVehiculo());
            
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
    public Motocicleta buscarPorId(int id)
    {
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idVehiculo, patente, modelo, largoManillar, estilo FROM Vehiculo WHERE idVehiculo=?";
            PreparedStatement st;

            st = cx.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                Motocicleta motocicleta = new Motocicleta() {};
                motocicleta.setIdVehiculo(rs.getInt("idVehiculo"));
                motocicleta.setPatente("patente");
                motocicleta.setModelo("modelo");
                motocicleta.setMedidaManillar(rs.getInt("largoManillar"));
                motocicleta.setEstilo(rs.getString("estilo"));
                return motocicleta;
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
    public ArrayList<Motocicleta> buscarTodos()
    {
        ArrayList<Motocicleta> listado = new ArrayList<Motocicleta>();
        try{
            Conexion con = new Conexion();
            Connection cx = con.obtenerConexion();

            String sql = "SELECT idVehiculo, patente, modelo, largoManillar, estilo FROM Vehiculo";
            PreparedStatement st;

            st = cx.prepareStatement(sql);           
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                Motocicleta motocicleta = new Motocicleta() {};
                motocicleta.setIdVehiculo(rs.getInt("idVehiculo"));
                motocicleta.setPatente(rs.getString("patente"));
                motocicleta.setMedidaManillar(rs.getInt("largoManillar"));
                motocicleta.setEstilo(rs.getString("estilo"));
                

                listado.add(motocicleta);
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
