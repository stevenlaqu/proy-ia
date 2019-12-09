package pe.isil.isilrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.isilrest.models.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
