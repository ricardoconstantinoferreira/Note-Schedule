package school.ferreira.repositories;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.ferreira.models.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Id> {
}
