package org.pnieto.supermercado.extendsBaseentity;

import org.pnieto.supermercado.excepciones.MayorCeroException;

public class Producto extends Supermercado {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int idProducto;
    private static int contar;

    public Producto() {this.idProducto = ++contar; }
    public Producto(String nombre, String descripcion) {this(); this.nombre = nombre; this.descripcion = descripcion;}
    public Producto(String nombre, String descripcion, double precio){this(nombre, descripcion);  this.precio = precio;}
    public Producto(String nombre, String descripcion, double precio, int stock) {
        this(nombre, descripcion, precio);
        this.stock = stock;
    }
    public String getNombre() {return nombre;}
    public String getDescripcion() {return descripcion;}
    public double getPrecio(){return precio;}
    public int getStock(){return stock;}
    public int getIdProducto(){return idProducto;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion; }
    public void setPrecio(double precio){this.precio = precio; }
    public void setStock(int stock){this.stock = stock; }

    //Excepciones ----------------------------------------------------------
    public boolean comprobarStock(int stock) throws MayorCeroException {
        if(stock < 0){
            throw new MayorCeroException("El stock debe ser mayor que cero!");
        }
        return true;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", idProducto=" + idProducto ;
    }
}
