package school.ferreira.models;

import jakarta.persistence.*;

@Entity
@Table(name = "professor_materia")
public class ProfessorMateria {

    @EmbeddedId
    private ProfessorMateriaId id;

    @ManyToOne
    @MapsId("professorId")
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    @ManyToOne
    @MapsId("materiaId")
    @JoinColumn(name = "materia_id")
    private MateriaModel materia;

    public ProfessorMateria() {
    }

    public ProfessorMateria(ProfessorMateriaId id, ProfessorModel professor, MateriaModel materia) {
        this.id = id;
        this.professor = professor;
        this.materia = materia;
    }

    public ProfessorMateriaId getId() {
        return id;
    }

    public void setId(ProfessorMateriaId id) {
        this.id = id;
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }

    public MateriaModel getMateria() {
        return materia;
    }

    public void setMateria(MateriaModel materia) {
        this.materia = materia;
    }
}