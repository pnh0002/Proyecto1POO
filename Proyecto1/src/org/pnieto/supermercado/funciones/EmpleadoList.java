package org.pnieto.supermercado.funciones;

import org.pnieto.supermercado.extendsBaseentity.empleados.Empleado;

import java.util.List;

public class EmpleadoList extends AbstractList<Empleado>{
    @Override
    public void editar(Integer id, Empleado entidad) {
        Empleado e = porId(id);
        String nombre = "";
        String apellido = "";
        String dni = "";
        double sueldo = 0d;

        if(e!=null){
            nombre = entidad.getNombre();
            apellido = entidad.getApellido();
            dni = entidad.getDni();
            sueldo = entidad.getSueldo();
        }
        e.setNombre(entidad.getNombre());
        e.setApellido(entidad.getApellido());
        e.setDni(entidad.getDni());
        e.setAsignarSueldoSueldo(entidad.getSueldo());

        Empleado er = new Empleado(nombre, apellido,dni,sueldo);
        añadirLista(er);

    }

    @Override
    public List<Empleado> listar(String campo, Direc direccion) {
       lista.sort((a,b)->{
           int resultado = 0;
           if(direccion == Direc.ASC) {
               if (campo.equalsIgnoreCase("nombre")) {
                   resultado = a.getNombre().compareTo(b.getNombre());
               }else if(campo.equalsIgnoreCase("apellido")){
                   resultado = a.getApellido().compareTo(b.getApellido());
               }else if(campo.equalsIgnoreCase("dni")){
                   resultado = a.getDni().compareTo(b.getDni());
               }
           }else if(direccion == Direc.DESC){
               if (campo.equalsIgnoreCase("nombre")) {
                   resultado = b.getNombre().compareTo(a.getNombre());
               }else if(campo.equalsIgnoreCase("apellido")){
                   resultado = b.getApellido().compareTo(a.getApellido());
               }else if(campo.equalsIgnoreCase("dni")){
                   resultado = b.getDni().compareTo(a.getDni());
               }
           }
           return resultado;

       });
       return lista;
    }
}
