package org.pnieto.supermercado.extendsBaseentity;

import java.util.Objects;

public class Supermercado {
    private int id;
    private static int aumentarId;

    public Supermercado(){
        this.id = ++aumentarId;
    }
    public int getId() {return id; }
    public void setId(int id){this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supermercado that = (Supermercado) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
