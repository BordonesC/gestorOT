package com.portfolio.auth.model;

import java.util.Objects;

public class Usuario {
    private final String nombre;
    private final Rol rol;

    public Usuario(String nombre, Rol rol){
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre(){
        return nombre;
    }

    public Rol getRol(){
        return rol;
    }

    @Override
    public String toString() {
        return "Usuario {nombre='" + nombre + "', rol=" + rol + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Usuario usuario)) return false;
        return nombre.equals(usuario.nombre) && rol == usuario.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, rol);
    }
}
