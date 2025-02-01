package school.ferreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import school.ferreira.models.ProfessorMateria;

import java.util.List;

@Repository
public interface ProfessorMateriaRepository extends JpaRepository<ProfessorMateria, Long> {

    @Query("from ProfessorMateria pm " +
            "inner join ProfessorModel p on p.id = pm.professor.id " +
            "inner join MateriaModel m on m.id = pm.materia.id " +
            "where pm.professor.id = ?1")
    List<ProfessorMateria> findProfessorMateriaByIdProfessor(int id);
}
