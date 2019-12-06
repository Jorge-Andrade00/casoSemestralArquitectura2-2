/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import DAO.ClienteDAO;
import DAO.ProductoDAO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Producto;

/**
 *
 * @author jofas
 */
@WebService(serviceName = "Servicios")
public class Servicios {
    
    ClienteDAO dao = new ClienteDAO();
    ProductoDAO dao2 = new ProductoDAO();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregar")
    @Oneway
    public void agregar(@WebParam(name = "rut") String rut, @WebParam(name = "nombre") String nombre, @WebParam(name = "direccion") String direccion, @WebParam(name = "email") String email, @WebParam(name = "pass") String pass) {
        dao.add(rut, nombre, direccion, email, pass);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validar")
    public int validar(@WebParam(name = "email") String email, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        return dao.validar(email, pass);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarProducto")
    public List<Producto> listarProducto() {
        List datos = dao2.listarProducto();
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarId")
    public Producto listarId(@WebParam(name = "id") int id) {
        
        return dao2.listarId(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarCliente")
    public List<Cliente> listarCliente(@WebParam(name = "email") String email) {
        List datos = dao.listar(email);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarCliente")
    @Oneway
    public void eliminarCliente(@WebParam(name = "rut") String rut) {
        dao.delete(rut);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editarCliente")
    @Oneway
    public void editarCliente(@WebParam(name = "cli") Cliente cli) {
        dao.edit(cli);
    }





}
