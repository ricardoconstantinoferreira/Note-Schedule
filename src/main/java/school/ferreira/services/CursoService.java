package school.ferreira.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.ferreira.dtos.CursoMateriaRecordDto;
import school.ferreira.dtos.CursoRecordDto;
import school.ferreira.models.CursoMateria;
import school.ferreira.models.CursoMateriaId;
import school.ferreira.models.CursoModel;
import school.ferreira.repositories.CursoMateriaRepository;
import school.ferreira.repositories.CursoRepository;
import school.ferreira.repositories.MateriaRepository;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    CursoMateriaRepository cursoMateriaRepository;

    public ResponseEntity<Object> saveCurso(CursoRecordDto cursoRecordDto) {
        var curso = new CursoModel(
                0,
                cursoRecordDto.name()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(
                cursoRepository.save(curso)
        );
    }

    public ResponseEntity<Object> associateMateria(int curso_id, CursoMateriaRecordDto cursoMateriaRecordDto) {
        var curso = cursoRepository.findById(curso_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso not found"));

        var materia = materiaRepository.findById(cursoMateriaRecordDto.materia_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Materia not faound"));

        var id = new CursoMateriaId(curso.getId(), materia.getId());

        var cursoMateriaModel = new CursoMateria(id, curso, materia);

        return ResponseEntity.status(HttpStatus.CREATED).body(
            cursoMateriaRepository.save(cursoMateriaModel)
        );
    }
}
