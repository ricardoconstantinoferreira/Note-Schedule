package school.ferreira.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.ferreira.dtos.MateriaRecordDto;
import school.ferreira.models.MateriaModel;
import school.ferreira.services.MateriaService;


import java.util.List;

@RestController
public class MateriaController {

    @Autowired
    MateriaService materiaService;

    @PostMapping("/materia")
    public ResponseEntity<MateriaModel> save(@RequestBody @Valid MateriaRecordDto materiaRecordDto) {
        return materiaService.saveMateria(materiaRecordDto);
    }

    @GetMapping("/materia")
    public ResponseEntity<List<MateriaModel>> getAllMateria() {
        return materiaService.getAllMateria();
    }

    @GetMapping("/materia/{id}")
    public ResponseEntity<Object> getOneMateria(@PathVariable(value = "id")int id) {
        return materiaService.getOneMateria(id);
    }

    @PutMapping("/materia/{id}")
    public ResponseEntity<Object> updateMateria(
            @PathVariable(value = "id") int id,
            @RequestBody @Valid MateriaRecordDto materiaRecordDto
    ) {
        return materiaService.updateMateria(id, materiaRecordDto);
    }

    @DeleteMapping("materia/{id}")
    public ResponseEntity<Object> deleteMateria(@PathVariable(value = "id") int id) {
        return materiaService.deleteMateria(id);
    }
}
