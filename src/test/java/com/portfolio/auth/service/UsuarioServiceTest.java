package com.portfolio.auth.service;

import com.portfolio.auth.model.*;
import com.portfolio.auth.repository.UsuarioGuardadoRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {
    UsuarioService usuarioService = new UsuarioService(new UsuarioGuardadoRepository());

    @Test
    void crearUsuarioConRol(){
        Usuario creado = usuarioService.crearUsuario("Juan", Rol.ADMIN);

        assertEquals("Juan", creado.getNombre());
        assertEquals(Rol.ADMIN, creado.getRol());

    }

    @Test
    void eliminarUsuarioPorNombre(){
        usuarioService.crearUsuario("Ana",Rol.SUPERVISOR);
        boolean deleted = usuarioService.eliminarUsuarioPorNombre("Ana");

        assertTrue(deleted,"Usuario no eliminado");
        assertNull(usuarioService.buscarUsuarioPorNombre("Ana"),"No se ha encontrado usuario");

    }

    @Test
    void modificarRolDeUsuario(){
        usuarioService.crearUsuario("Fernando",Rol.USUARIO);

        boolean updated = usuarioService.modificarRol("Fernando",Rol.SUPERVISOR);

        assertTrue(updated,"Rol no actualizado");
        assertEquals(Rol.SUPERVISOR,usuarioService.buscarUsuarioPorNombre("Fernando").getRol());

    }
}
