package school.ferreira.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import school.ferreira.controllers.MateriaController;
import school.ferreira.dtos.MateriaRecordDto;
import school.ferreira.models.MateriaModel;
import school.ferreira.repositories.CursoRepository;
import school.ferreira.repositories.MateriaRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class MateriaService {

    @Autowired
    MateriaRepository materiaRepository;

    public ResponseEntity<MateriaModel> saveMateria(MateriaRecordDto materiaRecordDto) {

        var materiaModel = new MateriaModel(
                0,
                materiaRecordDto.name()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(
                materiaRepository.save(materiaModel)
        );
    }

    public ResponseEntity<List<MateriaModel>> getAllMateria() {
        var listMateria = materiaRepository.findAll();

        if (!listMateria.isEmpty()) {
            for (MateriaModel materia: listMateria) {
                int id = materia.getId();
                materia.add(linkTo(methodOn(MateriaController.class).getOneMateria(id)).withSelfRel());
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(listMateria);
    }

    public ResponseEntity<Object> getOneMateria(int id) {
        Optional<MateriaModel> materia = materiaRepository.findById(id);

        if (materia.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Materia not found!!!");
        }

        materia.get().add(linkTo(methodOn(MateriaController.class).getAllMateria()).withRel("Materia List"));
        return ResponseEntity.status(HttpStatus.OK).body(materia.get());
    }

    public ResponseEntity<Object> updateMateria(int id, MateriaRecordDto materiaRecordDto) {
        Optional<MateriaModel> materia = materiaRepository.findById(id);

        if (materia.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Materia not found!!!");
        }

        var materiaModel = materia.get();
        BeanUtils.copyProperties(materiaRecordDto, materiaModel);

        return ResponseEntity.status(HttpStatus.OK).body(materiaRepository.save(materiaModel));
    }

    public ResponseEntity<Object> deleteMateria(int id) {
        Optional<MateriaModel> materia = materiaRepository.findById(id);

        if (materia.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Materia not found!!!");
        }

        materiaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Materia deleted successfully!!!");
    }
}
