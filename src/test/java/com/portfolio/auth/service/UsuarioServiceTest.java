package com.portfolio.auth.service;

import com.portfolio.auth.model.*;
import com.portfolio.auth.repository.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void deberiaGuardarUsuarioConRepositorioSqlMockeado() {
        UsuarioRepository sqlRepoMock = mock(UsuarioRepository.class);
        UsuarioService service = new UsuarioService(sqlRepoMock);

        Usuario esperado = new Usuario("Martín", Rol.SUPERVISOR);
        when(sqlRepoMock.guardar(any(Usuario.class))).thenReturn(esperado);

        Usuario resultado = service.crearUsuario("Martín", Rol.SUPERVISOR);

        assertEquals("Martín", resultado.getNombre());
        assertEquals(Rol.SUPERVISOR, resultado.getRol());
        verify(sqlRepoMock).guardar(any(Usuario.class));
    }
}
