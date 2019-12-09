package pe.isil.isilrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.isilrest.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {
}
