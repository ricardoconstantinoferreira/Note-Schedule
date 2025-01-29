package school.ferreira.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.ferreira.dtos.CursoRecordDto;
import school.ferreira.models.CursoModel;
import school.ferreira.repositories.CursoRepository;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public CursoModel saveCurso(CursoRecordDto cursoRecordDto) {
        var cursoModel = new CursoModel();
        BeanUtils.copyProperties(cursoRecordDto, cursoModel);

        return cursoRepository.save(cursoModel);
    }
}
