package com.portfolio.auth.service;

import com.portfolio.auth.model.*;
import com.portfolio.auth.repository.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OTServiceTest {

    @Test
    //validar si el usuario tiene permisos para crear OT implementando mockito
    void usuarioConPermisosCreaOT(){
        PermisoRepository permisoRepository = mock(PermisoRepository.class);
        OTService otService = new OTService(permisoRepository);

        Usuario supervisor = new Usuario("Pedro", Rol.SUPERVISOR);

        when(permisoRepository.tienePermisosCreacionOT(supervisor)).thenReturn(true);

        boolean creada = otService.crearOT(supervisor);

        assertTrue(creada,"Error: Usuario con permisos no ha podido crear OT");
        verify(permisoRepository).tienePermisosCreacionOT(supervisor);
    }

    @Test
    //validar si el usuario no tiene permisos para crear OT implementando mockito
    void usuarioSinPermisosNoCreaOT(){
        PermisoRepository permisoRepository = mock(PermisoRepository.class);
        OTService otService = new OTService(permisoRepository);

        Usuario usuario = new Usuario("Marta", Rol.USUARIO);

        when(permisoRepository.tienePermisosCreacionOT(usuario)).thenReturn(false);

        boolean creada = otService.crearOT(usuario);

        assertFalse(creada,"Error: Usuario sin permisos ha creado OT");
        verify(permisoRepository).tienePermisosCreacionOT(usuario);
    }

}
