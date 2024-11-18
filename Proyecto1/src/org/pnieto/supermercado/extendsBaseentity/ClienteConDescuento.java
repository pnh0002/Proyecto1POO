package org.pnieto.supermercado.extendsBaseentity;

public class ClienteConDescuento extends Cliente{
    private static Double descuento;

    public ClienteConDescuento(String nombre, String apellido, String email, String dni,String telefono) {super(nombre,apellido, email, dni, telefono);this.descuento = 23.3; }

    public Double getDescuento() {return descuento; }

    public void setDescuento(Double descuento){this.descuento = descuento;}



}
