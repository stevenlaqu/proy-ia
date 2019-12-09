package pe.isil.isilrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.isilrest.models.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}
