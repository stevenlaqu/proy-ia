package pe.isil.isilrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.isilrest.models.Curso;
import pe.isil.isilrest.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService implements BasicCrud<Curso,Integer> {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void create(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void dalete(Curso curso) {
        cursoRepository.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> findById(Integer idCurso) {
        return cursoRepository.findById(idCurso);
    }
}
