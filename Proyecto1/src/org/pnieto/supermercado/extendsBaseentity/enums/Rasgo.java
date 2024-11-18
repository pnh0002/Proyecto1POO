package org.pnieto.supermercado.extendsBaseentity.enums;

public enum Rasgo {
    NINO("niño"),
    NINA("niña"),
    MUJER("mujer"),
    HOMBRE("hombre"),
    HOMBREMAYOR("hombre mayor"),
    MUJERMAYOR("mujer mayor"),
    ANCIANO("anciano"),
    ANCIANA("anciana"),
    ;
    private String nombre;
    Rasgo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre ;
    }
}
