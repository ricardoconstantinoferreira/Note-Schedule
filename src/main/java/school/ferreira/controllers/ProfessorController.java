package school.ferreira.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.ferreira.dtos.ProfessorMateriaRecordDto;
import school.ferreira.dtos.ProfessorRecordDto;
import school.ferreira.models.ProfessorMateria;
import school.ferreira.models.ProfessorModel;
import school.ferreira.services.ProfessorService;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping("/professor")
    public ResponseEntity<Object> save(
            @RequestBody @Valid ProfessorRecordDto professorRecordDto
    ) {
        return professorService.save(professorRecordDto);
    }

    @PostMapping("/professor/{professor_id}/materia")
    public ResponseEntity<Object> associate(
            @PathVariable("professor_id") int professor_id,
            @RequestBody @Valid ProfessorMateriaRecordDto professorMateriaRecordDto
    ) {
        return professorService.associate(professor_id, professorMateriaRecordDto);
    }

    @GetMapping("/professor/materia")
    public ResponseEntity<List<ProfessorMateria>> getProfessorAndMateria() {
        return professorService.getProfessorAndMateria();
    }

    @GetMapping("/professor")
    public ResponseEntity<List<ProfessorModel>> getProfessor() {
        return professorService.getProfessor();
    }

    @GetMapping("/professor/materia/{professor_id}")
    public ResponseEntity<Object> getOneProfessorMateria(
            @PathVariable("professor_id") int professor_id
    ) {
        return professorService.getOneProfessorMateriaByProfessorId(professor_id);
    }
}
