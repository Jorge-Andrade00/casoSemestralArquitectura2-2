/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;

/**
 *
 * @author jofas
 */
public class Producto {

    private int id;
    private String nombre;
    private InputStream foto;
    private String descripcion;
    private int precio;
    private int stock;

    public Producto() {
    }

    public Producto(int id, String nombre, InputStream foto, String descripcion, int precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
