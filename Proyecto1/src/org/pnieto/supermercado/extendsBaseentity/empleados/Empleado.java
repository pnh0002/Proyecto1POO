package org.pnieto.supermercado.extendsBaseentity.empleados;

import org.pnieto.supermercado.excepciones.DniNoValidoException;
import org.pnieto.supermercado.extendsBaseentity.Supermercado;

 public class Empleado extends Supermercado {
    protected int idEmpleado;
    protected String nombre;
    protected String apellido;
    protected String dni;
    private static int contadorEmpleado;
    protected  double sueldo;
    private double asignarSueldo;
    private final static String DNI_REGEX = "^[0-9]{8}[A-Za-z]$";

    public Empleado(){this.idEmpleado = ++contadorEmpleado; }
    public Empleado(String nombre, String apellido, String dni,double sueldo){
        this(); this.nombre = nombre; this.apellido = apellido; this.dni = dni;this.sueldo = sueldo;}

    public int getIdEmpleado(){return idEmpleado; }
    public String getNombre(){return nombre; }
    public String getApellido(){return apellido; }
    public String getDni(){return dni;}
    public double getSueldo(){return sueldo; }

    public void setIdEmpleado(int idEmpleado){this.idEmpleado = idEmpleado;}

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setAsignarSueldoSueldo(double sueldo){this.sueldo = sueldo;}
    public boolean comprobarDni(String dni)throws DniNoValidoException {
       if(!dni.matches(DNI_REGEX)){
          throw new DniNoValidoException("El formato del DNI no es válido");
       }
       return dni.matches(DNI_REGEX);
    }


}
