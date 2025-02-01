package school.ferreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.ferreira.models.ProfessorModel;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Integer> {
}
