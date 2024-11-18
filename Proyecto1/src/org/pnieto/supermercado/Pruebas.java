package org.pnieto.supermercado;

import org.pnieto.supermercado.excepciones.CorreoNoValidoException;
import org.pnieto.supermercado.extendsBaseentity.*;
import org.pnieto.supermercado.extendsBaseentity.empleados.*;
import org.pnieto.supermercado.extendsBaseentity.enums.*;
import org.pnieto.supermercado.funciones.*;
import org.pnieto.supermercado.interfaces.ICrudRepositorioRasgos;

import java.text.*;
import java.util.*;



public class Pruebas {
    public static void main(String[] args) throws  ParseException {
        DateFormat df = new SimpleDateFormat("hh:mm");


        ICrudRepositorioRasgos<Cliente> c = new ClientesList();
        c.añadirLista(new Cliente("Pablo","Nieto","werfwe","26524856Z","423423444", Rasgo.ANCIANA));
        //c.añadirLista(new ClienteConDescuento());
        c.añadirLista(new Cliente("Pepe", "Francisco","manolo@gmail.com","23232424","434234234",Rasgo.HOMBRE));
//        c.añadir(1);
//        c.añadir(2);
//        if(!c.porId(1).comprobarEmail(c.porId(1).getEmail())){
//            System.err.println("Email incorecto para el cliente con id "+c.porId(1).getId());
//        }
//        if(!c.porId(1).comprobarDni(c.porId(1).getDni())){
//            System.err.println("Dni incorrecto para el cliente con id "+c.porId(1).getId());;
//        }
       // System.out.println(c.listarSB());
        System.out.println("================");
        System.out.println(c.getLista());
        Scanner sc = new Scanner(System.in);
//        Iterator<Cliente> e = c.getLista().iterator();
//        List<Cliente> err = new ArrayList<>();
//        while (e.hasNext()) {
//            Cliente cliente = e.next();
//            try {
//                if (!cliente.comprobarEmail(cliente.getEmail())) {
//                    err.add(cliente);
//                }
//            }catch (CorreoNoValidoException corr){
//                System.err.println(corr.getMessage());
//                //corr.printStackTrace();
//                System.err.println("En el "+cliente.getClass().getSimpleName()+" de id "+cliente.getId()+".");
//                System.out.print("Introduzca un correo válido: ");
//                String correoValido = sc.nextLine();
//                cliente.setEmail(correoValido);
//            }
//        }
//        err.forEach(System.out::println);

        c.editar(2, new Cliente("Pablo ", "Gonzalez","kdkskd@email.com", "23232424","234234234"));
        System.out.println("==========Ordenamos de forma ascendente respecto el nombre===========");
        System.out.println(c.listar("apellido", Direc.ASC));
        System.out.println("==========Por id===========");
        System.out.println(c.porId(1));
        System.out.println("===========================");
        System.out.println(c.getLista()+"\n");
        System.out.println("======Lista Negra=========");
        System.out.println(c.getListaNegra());
        System.out.println("===========================");

        System.out.println("Precio producto: ");
        ICrudRepositorioRasgos<Producto> p = new ProductoList();
        p.añadirLista(new Producto("Grunch", "aereales",23.3,10));
        p.añadirLista(new Producto("Brunch", "bereales",23.3,10));
        p.editar(1, new Producto("Chocobom", "Chocolate",23.2,3));
        System.out.println(p.getLista());
        System.out.println(p.porId(1));
        System.out.println("==========Ordenamos de forma "+Direc.ASC.getNombre()+" respecto el nombre===========");
        System.out.println(p.listar("descripcion", Direc.DESC));



        ICrudRepositorioRasgos<Empleado> emp = new EmpleadoList();
        emp.añadirLista(new Cajero("pablo ","Nieto","23242424",df.parse("08:00"),23232));
        System.out.print("Dime la seccion en la que trabaja: ");
        Seccion seccion = Seccion.CARNICERIA;

        emp.añadirLista(new Limpieza("Margarita","González","343423",2323.2, seccion));
        System.out.println(emp.getLista());
        System.out.println(emp.porId(1));
        System.out.println(p.porId(1));
        System.out.println(c.porId(1));

    }
}
