package school.ferreira.dtos;

import jakarta.validation.constraints.NotNull;

public record ProfessorMateriaRecordDto(@NotNull int materia_id) {
}
