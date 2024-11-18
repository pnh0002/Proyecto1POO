package org.pnieto.supermercado.extendsBaseentity;

import org.pnieto.supermercado.excepciones.CorreoNoValidoException;
import org.pnieto.supermercado.excepciones.DniNoValidoException;
import org.pnieto.supermercado.excepciones.TelefonoNoValidoException;
import org.pnieto.supermercado.extendsBaseentity.enums.Rasgo;

public class Cliente extends Supermercado {
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private String telefono;
    private Rasgo rasgo;
    private int idCliente;
    private static int contador;
    private boolean cupon = false;
    private final static String EMAIL_REGEX = "^(.+)@(.+)$";
    private final static String DNI_REGEX = "^[0-9]{8}[A-Za-z]$";
    private final static String TELEFONO_REGEX = "^[0-9]{9}$";

    public Cliente(){this.idCliente = ++contador;}
    public Cliente (String nombre, String apellido, String email, String dni){
        this(); this.nombre = nombre; this.apellido = apellido;this.email = email; this.dni = dni;

    }
    public Cliente(String nombre, String apellido, String email, String dni, String telefono){this(nombre, apellido, email, dni); this.telefono = telefono; }
    public Cliente(String nombre, String apellido, String email, String dni, String telefono, Rasgo rasgo) {
        this(nombre,apellido, email, dni, telefono);

        this.rasgo = Rasgo.HOMBRE;
    }
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getEmail(){return email;}
    public String getDni(){return dni;}
    private String getTelefono(){return telefono;}
    private int getIdCliente(){return idCliente;}

    public void setNombre(String nombre){this.nombre = nombre; }
    public void setApellido(String apellido){this.apellido = apellido;}
    public void setEmail(String email){this.email = email; }
    public void setDni(String dni){this.dni = dni;}
    public void setTelefono(String telefono){this.telefono = telefono;}

    //Excepciones -------------------------------------------------------------------------

    public boolean comprobarEmail(String email) throws CorreoNoValidoException {
        if(!email.matches(EMAIL_REGEX)){
            throw new CorreoNoValidoException("El formato del correo no es válido!");
        }
        return email.matches(EMAIL_REGEX);
    }
    public boolean comprobarDni(String dni)throws DniNoValidoException {
        if(!dni.matches(DNI_REGEX)){
            throw new DniNoValidoException("El formato del DNI no es válido");
        }
        return dni.matches(DNI_REGEX);
    }
    public boolean comprobarTelefono(String telefono) throws TelefonoNoValidoException {
        if(!telefono.matches(TELEFONO_REGEX)){
            throw new TelefonoNoValidoException("El formato del telefono no es válido!");
        }
        return telefono.matches(TELEFONO_REGEX);
    }
    //---------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                " apellido='" + apellido + '\'' +
                " email='" + email + '\'' +
                " dni='" + dni + '\'' +
                " telefono='" + telefono + '\'' +
                " idCliente=" + idCliente + "\n";
    }
}
