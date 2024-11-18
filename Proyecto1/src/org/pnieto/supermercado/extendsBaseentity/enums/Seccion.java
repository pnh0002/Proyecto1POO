package org.pnieto.supermercado.extendsBaseentity.enums;

public enum Seccion {
    CARNICERIA ("Carnicería"),
    PESCADERIA ("Pescadería"),
    PANADERIA ("Panadería"),
    COSMETICOS ("Cosméticos");
    private String nombre;
    Seccion(String nombre){this.nombre = nombre;}
    public String getNombre(){return nombre;}
}
