package org.pnieto.supermercado.funciones;

import org.pnieto.supermercado.extendsBaseentity.Producto;
import org.pnieto.supermercado.extendsBaseentity.Supermercado;
import org.pnieto.supermercado.extendsBaseentity.empleados.Empleado;
import org.pnieto.supermercado.interfaces.ICrudRepositorioRasgos;

import java.util.*;

abstract public class AbstractList<T extends Supermercado> implements ICrudRepositorioRasgos<T> {
    protected List<T> lista;
    protected Map<Integer, T> listaNegra;
    protected List<Producto> listaProducto;
    protected List<Empleado> listaEmpleados;

    public AbstractList() {lista = new ArrayList<>();listaNegra = new HashMap<>();listaProducto = new ArrayList<>();}

    @Override
    public void añadirLista(T entidad) {

        if(entidad != null) {
            lista.add(entidad);
        }
    }
    int identificador =0;
    @Override
    public void añadir(Integer id) {
//        identificador++;
//        entidad.setId(identificador);
//        Integer o = entidad.getId();
        T c = porId(id);
        listaNegra.put(id, c);
        if(id != 0 && c != null){
            eliminarLista(id);

        }

    }

    @Override
    public void eliminarLista(Integer id) {
        T entidad = porId(id);
        if(entidad != null){
            lista.remove(entidad);
        }
    }
public void eliminarListaNegra(Integer id) {
        T entidad = porId(id);
        if(entidad != null){
            listaNegra.remove(entidad);
        }
}


    @Override
    public T porId(Integer id) {
        Iterator<T> iterator = lista.iterator();
        while(iterator.hasNext()){
            T entidad = iterator.next();
            if(entidad instanceof Empleado){
                if(((Empleado) entidad).getIdEmpleado() == id){
                    return entidad;
                }
            }else if(entidad instanceof Producto){
                if(((Producto)entidad).getIdProducto() == id){
                    return entidad;
                }
            }
            if(entidad.getId() == id){
                return entidad;
            }
        }
        return null;
    }

    @Override
    public List<T> getLista() {
        return lista;

    }
    @Override
    public String listarSB(){
        StringBuilder sb = new StringBuilder();
        sb.append(lista).append("\n");
        return sb.toString();
    }

    public Map<Integer, T> getListaNegra() {
        return listaNegra;
    }


//    public List<T> getLista() {return lista;}
//    public void añadirLista(T entidad) {
//        this.lista.add(entidad);
//    }
//
//    public T porId(Integer id){
//        Iterator<T> it = this.lista.iterator();
//        while(it.hasNext()){
//            T c = it.next();
//            if(c.getId() == id){
//                return c;
//            }
//        }
//        return null;
//    }
//
//    public void eliminarPorId(Integer id){
//        T c = porId(id);
//        if(c != null){
//            lista.remove(c);
//        }
//    }


}
