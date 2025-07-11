package com.portfolio.auth.repository;

import com.portfolio.auth.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioGuardadoRepository implements UsuarioRepository{
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario guardar(Usuario usuario){
        usuarios.add(usuario);
        return usuario;
    }
}
