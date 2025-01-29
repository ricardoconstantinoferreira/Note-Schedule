package school.ferreira.models;

import jakarta.persistence.*;

@Entity
@Table(name = "curso_materia")
public class CursoMateria {

    @EmbeddedId
    private CursoMateriaId id;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private CursoModel curso;

    @ManyToOne
    @MapsId("materiaId")
    @JoinColumn(name = "materia_id")
    private MateriaModel materia;

    public CursoMateria() {
    }

    public CursoMateria(CursoMateriaId id, CursoModel curso, MateriaModel materia) {
        this.id = id;
        this.curso = curso;
        this.materia = materia;
    }

    public CursoMateriaId getId() {
        return id;
    }

    public void setId(CursoMateriaId id) {
        this.id = id;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public MateriaModel getMateria() {
        return materia;
    }

    public void setMateria(MateriaModel materia) {
        this.materia = materia;
    }
}
