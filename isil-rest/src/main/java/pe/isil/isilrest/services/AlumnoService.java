package pe.isil.isilrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.isilrest.models.Alumno;
import pe.isil.isilrest.repositories.AlumnoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService implements BasicCrud<Alumno,Integer> {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public void create(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void dalete(Alumno alumno) {
        alumnoRepository.delete(alumno);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> findById(Integer idAlumno) {
        return alumnoRepository.findById(idAlumno);
    }
}
