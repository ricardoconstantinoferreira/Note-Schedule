package school.ferreira.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.ferreira.controllers.ProfessorController;
import school.ferreira.dtos.ProfessorMateriaRecordDto;
import school.ferreira.dtos.ProfessorRecordDto;
import school.ferreira.models.ProfessorMateria;
import school.ferreira.models.ProfessorMateriaId;
import school.ferreira.models.ProfessorModel;
import school.ferreira.repositories.MateriaRepository;
import school.ferreira.repositories.ProfessorMateriaRepository;
import school.ferreira.repositories.ProfessorRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    ProfessorMateriaRepository professorMateriaRepository;

    public ResponseEntity<Object> save(ProfessorRecordDto professorRecordDto) {
        var professor = new ProfessorModel(
                0,
                professorRecordDto.name(),
                professorRecordDto.formacao()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(
                professorRepository.save(professor)
        );
    }

    public ResponseEntity<Object> associate(int professor_id, ProfessorMateriaRecordDto professorMateriaRecordDto) {
        var professor = professorRepository.findById(professor_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor not found"));

        var materia = materiaRepository.findById(professorMateriaRecordDto.materia_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor not faound"));

        var id = new ProfessorMateriaId(professor.getId(), materia.getId());

        var professorMateriaModel = new ProfessorMateria(id, professor, materia);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                professorMateriaRepository.save(professorMateriaModel)
        );
    }

    public ResponseEntity<Object> getOneProfessorMateriaByProfessorId(int professor_id) {
        List<ProfessorMateria> professorMateria = professorMateriaRepository.findProfessorMateriaByIdProfessor(professor_id);

        if (!professorMateria.isEmpty()) {
            for (ProfessorMateria result: professorMateria) {
                int id = result.getProfessor().getId();
                result.add(linkTo(methodOn(ProfessorController.class).getOneProfessorMateria(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(professorMateria);
    }

    public ResponseEntity<List<ProfessorMateria>> getProfessorAndMateria() {
        var listProfessorMateria = professorMateriaRepository.findAll();

        if (!listProfessorMateria.isEmpty()) {
            for (ProfessorMateria professorMateria: listProfessorMateria) {
                int id = professorMateria.getProfessor().getId();
                professorMateria.add(linkTo(methodOn(ProfessorController.class).getOneProfessorMateria(id)).withSelfRel());
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(listProfessorMateria);
    }

    public ResponseEntity<List<ProfessorModel>> getProfessor() {
        var listProfessor = professorRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProfessor);
    }
}
