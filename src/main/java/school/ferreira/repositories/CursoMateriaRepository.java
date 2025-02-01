package school.ferreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.ferreira.models.CursoMateria;

@Repository
public interface CursoMateriaRepository extends JpaRepository<CursoMateria, Integer> {
}
