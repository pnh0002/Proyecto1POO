package org.pnieto.supermercado.extendsBaseentity.empleados;

import java.util.Date;

public class Cajero extends Empleado{
    private Date comienzoJornada;

    public Cajero(String nombre, String apellido, String dni, double sueldo){
        super(nombre, apellido, dni,sueldo);

    }
    public Cajero(String nombre, String apellido, String dni, Date comienzoJornada,double sueldo){
        this(nombre, apellido, dni, sueldo);
        this.comienzoJornada = comienzoJornada;
    }

    public Date getComienzoJornada(){return comienzoJornada;}
    public double getSueldo(){return sueldo;}

    public void setComienzoJornada(Date jornadaLaboral){this.comienzoJornada = jornadaLaboral;}
    public void setSueldo(double sueldo){this.sueldo = sueldo;}

    @Override
    public String toString() {
        return "DNI =" + dni +
                ", idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sueldo ='" + sueldo + '\'' +
                ", comienzo jornada = "+comienzoJornada;
    }
}
