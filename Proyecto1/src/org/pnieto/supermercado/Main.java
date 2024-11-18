package org.pnieto.supermercado;

import org.pnieto.supermercado.excepciones.*;
import org.pnieto.supermercado.extendsBaseentity.*;
import org.pnieto.supermercado.extendsBaseentity.empleados.*;
import org.pnieto.supermercado.extendsBaseentity.enums.Rasgo;
import org.pnieto.supermercado.funciones.*;
import org.pnieto.supermercado.interfaces.ICrudRepositorioRasgos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("hh:mm");
        int opcion = 0;

        //Variables auxiliares
        int elementos = 0;
        String nombreCliente = "";
        String apellidoCliente = "";
        String emailCliente = "";
        String dniCliente = "";
        String telefonoCliente = "";
        int seleccionRasgo = 0;
        //Producto
        String nombreProducto = "";
        String descripcionProducto = "";
        double precioProducto = 0d;
        int stockProducto = 0;

        //Empleado (Cajero)
        String nombreCajero = "";
        String apellidoCajero = "";
        String dniCajero = "";
        Date inicioCajero ;
        double sueldoCajero;

        //Empleado (Gerente)
        String nombreGerente = "";
        String apellidoGerente = "";
        String dniGerente = "";
        double sueldo = 0d;
        int numEmpleados = 0;
        //Inicialicaciones
        ICrudRepositorioRasgos<Cliente> MasMenos = new ClientesList();
        ICrudRepositorioRasgos<Producto> p = new ProductoList();
        ICrudRepositorioRasgos<Empleado> cajero = new EmpleadoList();
       //---------------------
        int idEditar = 0;
        String eliminar = "";
        do{
            System.out.println("============= Menú de Selección =============");
            System.out.println("1. Añadir un cliente a la base de Datos.");
            System.out.println("2. Añadir un producto a la base de Datos.");
            System.out.println("3. Añadir un empleado a la base de Datos.");
            System.out.println("4. Eliminar de la lista.");
            System.out.println("5. Editar de la lista.");
            System.out.println("6. Comprobar Errores.");
            System.out.println("9. Ver la lista.");
            System.out.println("0. Salir del programa.");
            System.out.print("Elección: ");
            opcion = sc.nextInt();
            System.out.println("==============================================");

            if(opcion == 1){

                System.out.print("Cuantos clientes desea añadir en la base de datos: ");
                elementos = sc.nextInt();
                for(int i = 0; i<elementos; i++){
                    sc.nextLine();
                    System.out.println("====================== Añadiendo "+elementos+" clientes ======================");
                    System.out.print("Dime el nombre del cliente: ");
                    nombreCliente = sc.nextLine();
                    System.out.print("Dime el apellido del cliente: ");
                    apellidoCliente = sc.nextLine();
                    System.out.print("Dime el email del cliente: ");
                    emailCliente = sc.nextLine();
                    System.out.print("Dime el dni del cliente: ");
                    dniCliente = sc.nextLine();
                    System.out.print("Dime el teléfono del cliente: ");
                    telefonoCliente = sc.nextLine();

                    System.out.println("============= Rasgos de la persona (Puede ser nulo) =============");
                    System.out.println("1. Niño");
                    System.out.println("2. Niña");
                    System.out.println("3. Mujer");
                    System.out.println("4. Hombre");
                    System.out.println("5. Hombre Mayor");
                    System.out.println("6. Mujer Mayor");
                    System.out.println("7. Anciano");
                    System.out.println("8. Anciana");
                    System.out.println("0. Dejarlo vacío");
                    System.out.print("Seleccion: ");
                    seleccionRasgo = sc.nextInt();
                    if(seleccionRasgo == 0){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente));
                    }else if(seleccionRasgo == 1){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente, Rasgo.NINO));
                    }else if(seleccionRasgo == 2){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente, Rasgo.NINA));
                    }else if(seleccionRasgo == 3){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente, Rasgo.MUJER));
                    }else if(seleccionRasgo == 4){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente, Rasgo.HOMBRE));
                    }else if(seleccionRasgo == 5){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente, Rasgo.HOMBREMAYOR));
                    }else if(seleccionRasgo == 6){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente, Rasgo.MUJERMAYOR));
                    }else if(seleccionRasgo == 7){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente, Rasgo.ANCIANO));
                    }else if(seleccionRasgo == 8){
                        MasMenos.añadirLista(new Cliente(nombreCliente, apellidoCliente,emailCliente,dniCliente,telefonoCliente, Rasgo.ANCIANA));
                    }
                    System.out.println("====================================================================");

                }

                //System.out.println(MasMenos.getLista()); Para ver la lista de clientes actualizada
            }

            //================================Añadir un Producto ======================================================================

            else if(opcion == 2){

                System.out.print("Cuantos productos quiere añadir: ");
                elementos = sc.nextInt();
                for(int i = 0; i<elementos; i++){
                    sc.nextLine();
                    System.out.println("======================== Creación de "+elementos+" productos =====================");
                    System.out.print("Dime el nombre del producto: ");
                    nombreProducto = sc.nextLine();
                    System.out.print("Dime la descripción del producto: ");
                    descripcionProducto = sc.nextLine();
                    System.out.print("Dime el precio del producto: ");
                    try {
                        precioProducto = sc.nextDouble();
                    }catch(InputMismatchException e){
                        System.err.println("Debe ponerse un coma para representar los decimales no un punto. Inténtalo de nuevo.");
                        sc.nextLine();
                        precioProducto = sc.nextDouble();
                    }
                    System.out.print("Dime el stock del producto: ");
                    stockProducto = sc.nextInt();
                    p.añadirLista(new Producto(nombreProducto, descripcionProducto, precioProducto, stockProducto));
                }


            }


            else if(opcion == 3 ){
                System.out.println("============= Menú de Empleados a añadir =============");
                System.out.println("1. Añadir un cajero.");
                System.out.println("2. Añadir un gerente.");
                System.out.println("3. Añadir un encargado de la limpieza.");
                int opcion2 = sc.nextInt();
                sc.nextLine();
                if(opcion2 == 1 ){
                    System.out.print("Cuantas cajeros quiere añadir: ");
                    elementos = sc.nextInt();
                    sc.nextLine();
                    for(int i=0; i<elementos; i++) {

                        System.out.println("============= Creación de un Empleado(Cajero) =============");
                        System.out.print("Dime el nombre del empleado: ");
                        nombreCajero = sc.nextLine();
                        System.out.print("Dime el apellido del empleado: ");
                        apellidoCajero = sc.nextLine();
                        System.out.print("Dime el dni del empleado: ");
                        dniCajero = sc.nextLine();
                        System.out.print("Dime el sueldo del empleado: ");
                        sueldoCajero = sc.nextDouble();

                        cajero.añadirLista(new Cajero(nombreCajero, apellidoCajero, dniCajero, sueldoCajero));
                        System.out.println(cajero.getLista());
                    }


                }else if(opcion ==2){
                    System.out.print("Cuantas gerentes quiere añadir: ");
                    elementos = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i<elementos; i++){

                        System.out.println("============= Creación de un Empleado(Gerente) =============");
                        System.out.print("Dime el nombre del empleado: ");
                        nombreGerente = sc.nextLine();
                        System.out.print("Dime el apellido del empleado: ");
                        apellidoGerente = sc.nextLine();
                        System.out.print("Dime el dni del empleado: ");
                        dniGerente = sc.nextLine();
                        System.out.print("Dime el sueldo del empleado: ");
                        sueldo = sc.nextDouble();
                        System.out.print("Dime el número de empleados: ");
                        numEmpleados = sc.nextInt();

                        cajero.añadirLista(new Gerente(nombreGerente,apellidoGerente,dniGerente,sueldo,numEmpleados));

                    }
                }else if(opcion == 3){
                    System.out.print("Cuantas gerentes quiere añadir: ");
                    elementos = sc.nextInt();
                    sc.nextLine();
                    for(int i= 0; i<elementos; i++){
                        System.out.println("============= Creación de un Empleado(Gerente) =============");
                        System.out.print("Dime el nombre del empleado: ");
                        nombreGerente = sc.nextLine();
                        System.out.print("Dime el apellido del empleado: ");
                        apellidoGerente = sc.nextLine();
                        System.out.print("Dime el dni del empleado: ");
                        dniGerente = sc.nextLine();
                        System.out.print("Dime el sueldo del empleado: ");
                        sueldo = sc.nextDouble();

                        cajero.añadirLista(new Limpieza(nombreGerente,apellidoGerente,dniGerente,sueldo));

                    }
                }
            }else if(opcion == 4){
                System.out.println(MasMenos.getLista());
                System.out.println(p.getLista());
                System.out.println(cajero.getLista());

                System.out.print("Cuantos elementos quiere eliminar: ");
                elementos = sc.nextInt();
                sc.nextLine();
                System.out.println("De que lista lo quiere hacer: ");
                System.out.println("1.Clientes.");
                System.out.println("2. Productos.");
                System.out.println("3.Empleados.");
                eliminar = sc.nextLine();
                if(eliminar.equalsIgnoreCase("Clientes")){
                    for(int i=0; i<elementos; i++){
                        System.out.println("Dime el id del cliente: ");
                        idEditar = sc.nextInt();
                        MasMenos.eliminarLista(idEditar);
                        sc.nextLine();
                    }
                }else if(eliminar.equalsIgnoreCase("Productos")){
                    for(int i=0; i<elementos; i++){
                        System.out.println("Dime el id del producto: ");
                        idEditar = sc.nextInt();
                        p.eliminarLista(idEditar);
                        sc.nextLine();
                    }
                }else if(eliminar.equalsIgnoreCase("Empleados")){
                    for(int i=0; i<elementos; i++){
                        System.out.println("Dime el id del empleado: ");
                        idEditar = sc.nextInt();
                        cajero.eliminarLista(idEditar);
                        sc.nextLine();
                    }
                }
                System.out.println(MasMenos.getLista());
                System.out.println(p.getLista());
                System.out.println(cajero.getLista());




            }else if(opcion == 5){
                System.out.println(MasMenos.getLista());
                System.out.println(p.getLista());
                System.out.println(cajero.getLista());

                System.out.print("Cuantos elementos quiere editar: ");
                elementos = sc.nextInt();
                sc.nextLine();
                System.out.println("De que lista lo quiere hacer: ");
                System.out.println("1.Clientes.");
                System.out.println("2. Productos.");
                System.out.println("3.Empleados.");
                eliminar = sc.nextLine();
                if(eliminar.equalsIgnoreCase("Clientes")){
                    for(int i=0; i<elementos; i++){
                        System.out.println("Dime el id del cliente: ");
                        idEditar = sc.nextInt();
                        System.out.print("Dime el nombre del cliente: ");
                        nombreCliente = sc.nextLine();
                        System.out.print("Dime el apellido del cliente: ");
                        apellidoCliente = sc.nextLine();
                        System.out.print("Dime el email del cliente: ");
                        emailCliente = sc.nextLine();
                        System.out.print("Dime el dni del cliente: ");
                        dniCliente = sc.nextLine();
                        MasMenos.editar(idEditar,new Cliente(nombreCliente,apellidoCliente,emailCliente,dniCliente));
                        sc.nextLine();
                    }
                }else if(eliminar.equalsIgnoreCase("Productos")){
                    for(int i=0; i<elementos; i++){
                        System.out.println("Dime el id del producto: ");
                        idEditar = sc.nextInt();
                        System.out.print("Dime el nombre del cliente: ");
                        nombreProducto = sc.nextLine();
                        System.out.print("Dime el descripcion del cliente: ");
                        descripcionProducto = sc.nextLine();
                        System.out.print("Dime el precio del cliente: ");
                        precioProducto = sc.nextDouble();
                        System.out.print("Dime el stock del cliente: ");
                        stockProducto = sc.nextInt();
                        p.editar(idEditar, new Producto(nombreProducto,descripcionProducto,precioProducto,stockProducto));
                        sc.nextLine();
                    }
                }else if(eliminar.equalsIgnoreCase("Empleados")){
                    System.out.println("=============== Menú de edición empleados =========================");
                    System.out.println("1.Cajero.");
                    System.out.println("2. Gerente.");
                    System.out.println("3. Limpieza.");
                    System.out.print("Elección: ");
                    opcion = sc.nextInt();

                    if(opcion == 1){
                        sc.nextLine();
                        for(int i=0; i<elementos; i++){
                            System.out.println("Dime el id del empleado: ");
                            idEditar = sc.nextInt();
                            System.out.print("Dime el nombre del cliente: ");
                            nombreProducto = sc.nextLine();
                            System.out.print("Dime el apellido del cliente: ");
                            apellidoCajero = sc.nextLine();
                            System.out.print("Dime el dni del cliente: ");
                            dniCajero = sc.nextLine();
                            System.out.print("Dime el sueldo del cliente: ");
                            sueldo = sc.nextDouble();
                            cajero.editar(idEditar, new Cajero(nombreProducto,apellidoCajero,dniCajero,sueldo));
                            sc.nextLine();
                        }
                    }else if(opcion == 2){
                        sc.nextLine();
                        for(int i=0; i<elementos; i++){
                            System.out.println("Dime el id del empleado: ");
                            idEditar = sc.nextInt();
                            System.out.print("Dime el nombre del cliente: ");
                            nombreProducto = sc.nextLine();
                            System.out.print("Dime el apellido del cliente: ");
                            apellidoCajero = sc.nextLine();
                            System.out.print("Dime el dni del cliente: ");
                            dniCajero = sc.nextLine();
                            System.out.print("Dime el sueldo del cliente: ");
                            sueldo = sc.nextDouble();
                            System.out.print("Dime el numero de empleados: ");
                            numEmpleados = sc.nextInt();
                            cajero.editar(idEditar, new Gerente(nombreProducto,apellidoCajero,dniCajero,sueldo,numEmpleados));
                            sc.nextLine();
                        }
                    } else if (opcion == 3) {
                        sc.nextLine();
                        for(int i=0; i<elementos; i++){
                            System.out.println("Dime el id del empleado: ");
                            idEditar = sc.nextInt();
                            System.out.print("Dime el nombre del cliente: ");
                            nombreProducto = sc.nextLine();
                            System.out.print("Dime el apellido del cliente: ");
                            apellidoCajero = sc.nextLine();
                            System.out.print("Dime el dni del cliente: ");
                            dniCajero = sc.nextLine();
                            System.out.print("Dime el sueldo del cliente: ");
                            sueldo = sc.nextDouble();
                            cajero.editar(idEditar, new Limpieza(nombreProducto,apellidoCajero,dniCajero,sueldo));
                            sc.nextLine();
                        }
                    }
                }
                System.out.println(MasMenos.getLista());
                System.out.println(p.getLista());
                System.out.println(cajero.getLista());
            }else if(opcion == 6){
                System.out.println("====================Lista de Elementos======================");
                System.out.println(MasMenos.getLista());
                if(p != null) {
                    System.out.println(p.getLista());
                }
                System.out.println(cajero.getLista());
                System.out.println("==========================================================");
                Iterator<Cliente> e = MasMenos.getLista().iterator();
                Iterator<Producto> pr = p.getLista().iterator();
                Iterator<Empleado> emp = cajero.getLista().iterator();
                List<Cliente> err = new ArrayList<>();
                while (e.hasNext()) {
                    Cliente cliente = e.next();
                    try {
                        if (!cliente.comprobarEmail(cliente.getEmail())) {
                            err.add(cliente);
                        }
                    }catch (CorreoNoValidoException corr){
                        sc.nextLine();
                        System.err.println("En el "+cliente.getClass().getSimpleName()+" de id "+cliente.getId()+".");
                        System.out.print("Introduzca un correo válido: ");
                        String correoValido = sc.nextLine();
                        cliente.setEmail(correoValido);
                    }
                    try{
                        if(!cliente.comprobarDni(cliente.getDni())){
                        }
                    }catch(DniNoValidoException dn){
                        sc.nextLine();
                        System.err.println("En el "+cliente.getClass().getSimpleName()+" de id "+cliente.getId()+".");
                        System.out.print("Introduzca un dni válido: ");
                        String dniValido = sc.nextLine();
                        cliente.setDni(dniValido);
                    }

                }
                while (e.hasNext()) {
                    Empleado empl = emp.next();
                    try {
                        if (!empl.comprobarDni(empl.getDni())) {

                        }
                    }catch (DniNoValidoException corr){
                        sc.nextLine();
                        System.err.println("En el "+empl.getClass().getSimpleName()+" de id "+empl.getId()+".");
                        System.out.print("Introduzca un correo válido: ");
                        String dniValido = sc.nextLine();
                        empl.setDni(dniValido);
                    }
                }
                System.out.println("=====================Lista de elementos corregidas===================");
                System.out.println(MasMenos.getLista());
                System.out.println(p.getLista());
                System.out.println(cajero.getLista());
                System.out.println("==================================================================");
            }

            else if(opcion == 9){
                System.out.println(MasMenos.getLista());
                System.out.println(p.getLista());
                System.out.println(cajero.getLista());
            }


        }while(opcion != 0);
    }
}
