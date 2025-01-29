package school.ferreira.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.ferreira.dtos.AlunoRecordDto;
import school.ferreira.models.AlunoModel;
import school.ferreira.repositories.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public AlunoModel saveAluno(AlunoRecordDto alunoRecordDto) {
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoRecordDto, alunoModel);

        return alunoRepository.save(alunoModel);
    }
}
