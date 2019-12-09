package pe.isil.isilrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.isilrest.models.Nota;
import pe.isil.isilrest.repositories.NotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService implements BasicCrud<Nota,Integer>{
    @Autowired
    private NotaRepository notaRepository;

    @Override
    public void create(Nota nota) {
        notaRepository.save(nota);
    }

    @Override
    public Nota update(Nota nota) {
        return notaRepository.save(nota);
    }

    @Override
    public void dalete(Nota nota) {
        notaRepository.delete(nota);
    }

    @Override
    public List<Nota> findAll() {
        return notaRepository.findAll();
    }

    @Override
    public Optional<Nota> findById(Integer idNota) {
        return notaRepository.findById(idNota);
    }
}
