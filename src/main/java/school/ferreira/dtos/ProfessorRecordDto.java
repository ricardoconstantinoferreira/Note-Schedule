package school.ferreira.dtos;

import jakarta.validation.constraints.NotNull;

public record ProfessorRecordDto(@NotNull String name, @NotNull String formacao) {
}
