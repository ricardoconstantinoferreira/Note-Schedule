package school.ferreira.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import school.ferreira.models.MateriaModel;

import java.util.List;

public record CursoRecordDto(@NotNull String name, @NotBlank List<MateriaModel> materia) {
}
