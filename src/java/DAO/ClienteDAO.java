/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import config.Conexion;
import interfaz.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author jofas
 */
public class ClienteDAO implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion c = new Conexion();

    @Override
    public List listar(String email) {
         List<Cliente> datos = new ArrayList();
        String sql = "select * from cliente where email = ?";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setRutCliente(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setPass(rs.getString(6));
                
                datos.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return datos;
    }

    @Override
    public void add(String rut, String nombre, String direccion, String email, String pass) {
        String sql = "insert into cliente(rut, nombre,direccion, email, Password) values(?,?,?,?,?);";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, rut);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, email);
            ps.setString(5, pass);

            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void edit(Cliente cli) {
        String sql = "UPDATE cliente SET rut = ?, nombre = ?, direccion = ?, email = ?, Password = ?"
                  + " WHERE idCliente =?";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, cli.getRutCliente());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getDireccion());
            ps.setString(4,cli.getEmail());
            ps.setString(5, cli.getPass());
            ps.setInt(6, cli.getIdCliente());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(String rut) {
        String sql = "DELETE FROM cliente WHERE rut= ?";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public int validar(String email, String pass) {
        int x=0;
        String sql = "Select * from cliente where email = ? and Password = ?";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                x=x+1;
                /*cli.setEmail(rs.getString("email"));
                cli.setPass(rs.getString("Password"));*/
            }
            if (x==1) {
                System.out.println("1");
                return 1;
            }else{
                System.out.println("0");
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

}
