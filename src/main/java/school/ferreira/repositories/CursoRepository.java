package school.ferreira.repositories;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import school.ferreira.models.CursoModel;

public interface CursoRepository extends JpaRepository<CursoModel, Id> {
}
