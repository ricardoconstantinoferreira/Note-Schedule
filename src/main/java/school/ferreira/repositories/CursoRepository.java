package school.ferreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.ferreira.models.CursoModel;

public interface CursoRepository extends JpaRepository<CursoModel, Integer> {
}
