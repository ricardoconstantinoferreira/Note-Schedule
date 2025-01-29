package school.ferreira.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AlunoRecordDto(@NotNull Date date_birth, @NotNull String gender, @NotNull String name, @NotBlank int curso_id) {
}
