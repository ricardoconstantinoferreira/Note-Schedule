package school.ferreira.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CursoMateriaId {

    @Column(name = "curso_id")
    private int cursoId;

    @Column(name = "materia_id")
    private int materiaId;

    public CursoMateriaId() {
    }

    public CursoMateriaId(int cursoId, int materiaId) {
        this.cursoId = cursoId;
        this.materiaId = materiaId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }
}
