package com.portfolio.auth.service;

import com.portfolio.auth.model.*;
import com.portfolio.auth.repository.*;

public class OTService {
    private final PermisoRepository permisoRepository;

    public OTService(PermisoRepository permisoRepository) {
        this.permisoRepository = permisoRepository;
    }

    public boolean crearOT(Usuario usuario) {
        return permisoRepository.tienePermisosCreacionOT(usuario);
    }
}
