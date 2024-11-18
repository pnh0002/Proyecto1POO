package org.pnieto.supermercado.extendsBaseentity.empleados;

public class Gerente extends Empleado{

    private int numEmpleados;

    public Gerente(String nombre, String apellido, String dni,double sueldo, int numEmpleados){
        super(nombre,apellido,dni,sueldo); this.numEmpleados = numEmpleados;}

    public int getNumEmpleados(){return numEmpleados;}

    public void setNumEmpleados(int numEmpleados){this.numEmpleados = numEmpleados;}

    @Override
    public String toString() {
        return "DNI =" + dni +
                ", idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sueldo='" + sueldo + '\'' +
                ", numero de empleados ="+numEmpleados;
    }
}
