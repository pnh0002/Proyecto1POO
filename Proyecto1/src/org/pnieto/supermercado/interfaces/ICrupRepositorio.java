package org.pnieto.supermercado.interfaces;

import org.pnieto.supermercado.extendsBaseentity.Producto;
import org.pnieto.supermercado.funciones.Direc;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface ICrupRepositorio<T> {
    public void añadirLista(T entidad);
    public void eliminarLista(Integer id);
    public T porId(Integer id);
    public List<T> getLista();
    public void añadir(Integer id);
    public Map<Integer, T> getListaNegra();
    public void editar(Integer id, T entidad);
    public List<T> listar(String campo, Direc direccion);
    public String listarSB();


}
