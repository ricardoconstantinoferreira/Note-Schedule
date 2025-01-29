package school.ferreira.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.ferreira.dtos.AlunoRecordDto;
import school.ferreira.models.AlunoModel;
import school.ferreira.services.AlunoService;

@RestController
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping("/aluno")
    public ResponseEntity<AlunoModel> save(@RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                alunoService.saveAluno(alunoRecordDto)
        );
    }
}
