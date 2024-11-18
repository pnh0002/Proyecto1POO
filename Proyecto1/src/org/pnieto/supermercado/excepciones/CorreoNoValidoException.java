package org.pnieto.supermercado.excepciones;

import org.pnieto.supermercado.extendsBaseentity.Cliente;

public class CorreoNoValidoException extends Exception {
    public CorreoNoValidoException(String message) {
        super(message);
    }
}
