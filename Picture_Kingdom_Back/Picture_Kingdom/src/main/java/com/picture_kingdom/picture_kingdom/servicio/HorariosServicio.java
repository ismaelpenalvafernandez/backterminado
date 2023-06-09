package com.picture_kingdom.picture_kingdom.servicio;

import com.picture_kingdom.picture_kingdom.modelo.Asientos;
import com.picture_kingdom.picture_kingdom.modelo.Horarios;
import com.picture_kingdom.picture_kingdom.repo.IAsientosRepo;
import com.picture_kingdom.picture_kingdom.repo.IHorariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class HorariosServicio implements IHorariosServicio {
    @Autowired
    private IHorariosRepo repo;

    @Override
    public List<Horarios> ObtenerTodos() {return repo.findAll();}

    @Override
    public List<Horarios> obtenerHorariosPorPeliculaYDia(Integer peliculaid, Integer diaid) {
        if (repo instanceof IHorariosRepo) {
            IHorariosRepo horariosRepo = (IHorariosRepo) repo;
            return horariosRepo.findByPeliculaidAndDiaid(peliculaid, diaid);
        }
        return Collections.emptyList();
    }
}


