package org.pnieto.supermercado.funciones;

import org.pnieto.supermercado.extendsBaseentity.Cliente;

import java.util.*;

public class ClientesList extends AbstractList<Cliente>{


    @Override
    public void editar(Integer id, Cliente entidad) {
        Cliente c = porId(id);
        String nombre = "";
        String apellido = "";
        String email = "";
        String dni  = "";

        if(c!= null){
            nombre = c.getNombre();
            apellido = c.getApellido();
            email = c.getEmail();
            dni = c.getDni();

        }
        c.setNombre(entidad.getNombre());
        c.setApellido(entidad.getApellido());
        c.setEmail(entidad.getEmail());
        c.setDni(entidad.getDni());

        Cliente h = new Cliente(nombre,apellido, email,dni);
        añadirLista(h);
    }

    @Override
    public List<Cliente> listar(String campo, Direc direccion) {
        lista.sort((a,b) ->{
                int resultado = 0;
                if(direccion == Direc.ASC && a != null&& b != null){
                    if(campo.equalsIgnoreCase("nombre")){
                        resultado = a.getNombre().compareTo(b.getNombre());
                    }if(campo.equalsIgnoreCase("apellido")){
                        resultado = a.getApellido().compareTo(b.getApellido());
                    }if(campo.equalsIgnoreCase("dni")){
                        resultado = a.getDni().compareTo(b.getDni());
                    }
                }else if(direccion == Direc.DESC&& a != null&& b != null){
                    if(campo.equalsIgnoreCase("nombre")){
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
