package com.portfolio.auth.repository;

import com.portfolio.auth.model.*;

public class PermisoSqlRepository implements PermisoRepository{
    @Override
    public boolean tienePermisosCreacionOT(Usuario usuario) {
        //simulación: solo ADMIN o SUPERVISOR pueden crear OT
        return usuario.getRol() == Rol.ADMIN || usuario.getRol() == Rol.SUPERVISOR;
    }

}
