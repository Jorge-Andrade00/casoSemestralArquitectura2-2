/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author jofas
 */
public interface CRUD {
    public List listar(String email);
    public void add(String rut, String nombre, String direccion, String email, String pass);
    public void edit(Cliente cli);
    public void delete(String rut);
    public int validar(String email, String pass);
}
