/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.ClienteDAO;
import DAO.ProductoDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jofas
 */
public class Test {

    public static void main(String[] args) {
        ClienteDAO cd = new ClienteDAO();
        ProductoDAO pdao = new ProductoDAO();
        Cliente cli = new Cliente(17,"" , "NNN", "los toros", "66@6", "123");
        cd.edit(cli);
        //cd.delete("");
        
        /*List<Cliente> datos =  new ArrayList<>();
        datos = cd.listar("0@4");
        for(Cliente i: datos){
            System.out.println(i.getNombre());
        }*/
        //cd.add("runTest00", "Test00", "asda", "asdads", "123");
        
        //cd.validar("0@4", "123");
       // cd.add("rutHola","jholaTEST" , "asd", "hola@a", "123");
        
        /*Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("select rut, nombre, direccion from usuario");
            while (rs.next()) {
                System.out.println(rs.getString("rut") + " " + rs.getString("nombre") + " " + rs.getString("direccion"));
            }
            cn.con.close();
        } catch (Exception e) {

        }*/

    }

}
