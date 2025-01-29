package school.ferreira.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProfessorMateriaId {

    @Column(name = "professor_id")
    private int professorId;

    @Column(name = "materia_id")
    private int materiaId;

    public ProfessorMateriaId() {
    }

    public ProfessorMateriaId(int professorId, int materiaId) {
        this.professorId = professorId;
        this.materiaId = materiaId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }
}
