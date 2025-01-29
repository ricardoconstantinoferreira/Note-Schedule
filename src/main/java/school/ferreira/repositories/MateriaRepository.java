package school.ferreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.ferreira.models.MateriaModel;

public interface MateriaRepository extends JpaRepository<MateriaModel, Integer> {
}
