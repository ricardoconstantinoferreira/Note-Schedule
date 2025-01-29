package school.ferreira.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "aluno")
public class AlunoModel extends RepresentationModel<AlunoModel> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date_birth;

    @Column(nullable = false)
    private String gender;

    @ManyToOne
    @JoinColumn(
            name = "curso_id",
            referencedColumnName = "id"
    )
    private CursoModel curso;

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private Date getDateBirth() {
        return date_birth;
    }

    private void setDateBirth(Date date_birth) {
        this.date_birth = date_birth;
    }

    private String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    private CursoModel getCurso() {
        return curso;
    }

    private void setCurso(CursoModel curso) {
        this.curso = curso;
    }
}
