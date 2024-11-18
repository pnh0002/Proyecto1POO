package org.pnieto.supermercado.funciones;

public enum Direc {
    ASC("ascendente"),
    DESC("descendente");
    private String nombre;
    Direc(String nombre){this.nombre = nombre; }
    public String getNombre(){return nombre;}
}

