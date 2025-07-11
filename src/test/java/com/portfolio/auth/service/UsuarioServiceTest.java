package com.portfolio.auth.service;

import com.portfolio.auth.model.*;
import com.portfolio.auth.repository.UsuarioGuardadoRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

    @Test
    void crearUsuarioConRol(){
        UsuarioService userService = new UsuarioService(new UsuarioGuardadoRepository());

        Usuario creado = userService.crearUsuario("Juan", Rol.ADMIN);

        assertEquals("Juan", creado.getNombre());
        assertEquals(Rol.ADMIN, creado.getRol());

        //Test ejecuta con le mínimo requerido
    }

}
