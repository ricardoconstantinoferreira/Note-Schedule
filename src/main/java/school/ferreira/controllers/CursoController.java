package school.ferreira.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.ferreira.dtos.CursoRecordDto;
import school.ferreira.models.CursoModel;
import school.ferreira.services.CursoService;

@RestController
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping("/curso")
    public ResponseEntity<CursoModel> save(@RequestBody @Valid CursoRecordDto cursoRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                cursoService.saveCurso(cursoRecordDto)
        );
    }
}
