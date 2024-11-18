package org.pnieto.supermercado.funciones;

import org.pnieto.supermercado.extendsBaseentity.Producto;

import javax.management.Descriptor;
import java.util.Iterator;
import java.util.List;

public class ProductoList extends AbstractList<Producto>  {

    public double verPrecioCompra(Producto p) {
        double total = 0d;
        total += p.getPrecio();

        return total;
    }

    @Override
    public Producto porId(Integer id) {
        Iterator<Producto> iterator = lista.iterator();
        while(iterator.hasNext()){
            Producto entidad = iterator.next();
            if(entidad.getIdProducto() == id){
                return entidad;
            }
        }
        return null;
    }

    @Override
    public void editar(Integer id, Producto entidad) {
        Producto c = porId(id); //Chocobom chocolate 22.3
        String nombre = "";
        String descripcion = "";
        System.out.println(c);
        double precio = 0d;
        if(c != null) {
            nombre = c.getNombre(); //Chocobom
            descripcion = c.getDescripcion(); //Chocolate
            precio = c.getPrecio(); //22.3
        }
        String nombreEntidad = entidad.getNombre();
        String descripcionEntidad = entidad.getDescripcion();
//        System.out.println(nombreEntidad + " "+ descripcionEntidad);
//        System.out.println(c.getNombre());
        if(nombreEntidad != null && descripcionEntidad != null) {
            c.setNombre(nombreEntidad); //Crunch
            c.setDescripcion(descripcionEntidad); //Cereal
            c.setPrecio(entidad.getPrecio()); //3
        }
        Producto h = new Producto(nombre, descripcion,precio);
        añadirLista(h);
    }

    @Override
    public List<Producto> listar(String campo, Direc direccion) {
        lista.sort((a,b)->{
            int resultado = 0;
            if(direccion == Direc.ASC&& a != null&& b != null){
                if(campo.equalsIgnoreCase("nombre")){
                    resultado = a.getNombre().compareTo(b.getNombre());
                }if(campo.equalsIgnoreCase("descripcion")){
                    resultado = a.getDescripcion().compareTo(b.getDescripcion());
                }
            }else if(direccion == Direc.DESC&& a != null&& b != null){
                if(campo.equalsIgnoreCase("nombre")){
                    resultado = b.getNombre().compareTo(a.getNombre());
                }if(campo.equalsIgnoreCase("descripcion")){
                    resultado = b.getDescripcion().compareTo(a.getDescripcion());
                }
            }
            return resultado;
        });
        return lista;
    }

    @Override
    public List<Producto> getLista() {
        return lista;
    }
}
