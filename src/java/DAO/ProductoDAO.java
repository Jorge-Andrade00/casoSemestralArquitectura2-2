/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;

/**
 *
 * @author jofas
 */
public class ProductoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion c = new Conexion();

    public List listarProducto() {
        List<Producto> datos = new ArrayList();
        String sql = "select * from producto";
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getInt(5));
                p.setStock(rs.getInt(6));

                datos.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return datos;
    }

    public void listarImg(int id, HttpServletResponse response) {
        String sql = "select * from producto where idProducto = " + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            outputStream = response.getOutputStream();

            con = c.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("Foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Producto listarId(int id) {
        String sql="Select * from producto where idProducto = "+id;
        Producto p =new Producto();
        try {
            con = c.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getInt(5));
                p.setStock(rs.getInt(6)); 
            }
        } catch (Exception e) {
        }
        return p;
    }
}
