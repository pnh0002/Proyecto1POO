package org.pnieto.supermercado.extendsBaseentity.empleados;

import org.pnieto.supermercado.extendsBaseentity.enums.Seccion;

public class Limpieza extends Empleado{
    private Seccion seccion;

    public Limpieza(String nombre, String apellido, String dni, double sueldo){
        super(nombre,apellido,dni, sueldo);
    }
    public Limpieza (String nombre, String apellido, String dni, double sueldo, Seccion seccion){
        this(nombre, apellido , dni , sueldo);
        this.seccion = seccion;
    }

    public Seccion getSeccion(){return seccion; }
    public void setSeccion(Seccion seccion){this.seccion = seccion;}

    @Override
    public String toString() {
        return "DNI=" + dni +
                ", idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", Sección ='" + seccion+ '\'';

    }
}
