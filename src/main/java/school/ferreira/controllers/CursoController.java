package school.ferreira.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.ferreira.dtos.CursoMateriaRecordDto;
import school.ferreira.dtos.CursoRecordDto;
import school.ferreira.services.CursoService;

@RestController
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping("/associate/{curso_id}/curso")
    public ResponseEntity<Object> associateMateria(
            @PathVariable("curso_id") int curso_id,
            @RequestBody @Valid CursoMateriaRecordDto cursoMateriaRecordDto
    ) {
        return cursoService.associateMateria(curso_id, cursoMateriaRecordDto);
    }

    @PostMapping("/curso")
    public ResponseEntity<Object> saveCurso(
            @RequestBody @Valid CursoRecordDto cursoRecordDto
    ) {
        return cursoService.saveCurso(cursoRecordDto);
    }
}
