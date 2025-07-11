package com.portfolio.auth.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

    @Test
    void crearUsuarioConRol(){
        UsuarioService userService = new UsuarioService(new UsuarioGuardadoRepository());

        Usuario creado = userService.crearUsuario("Juan",Rol.ADMIN);

        assertEquals("Juan", creado.getName());
        assertEquals(Role.ADMIN, creado.getRole());

        //Esta prueba no compilará porque no existen las clases Usuario, UsuarioService, Rol, ni UsuarioGuardadoRepository.
    }

}
