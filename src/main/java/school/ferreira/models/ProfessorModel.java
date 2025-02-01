package school.ferreira.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "professor")
public class ProfessorModel extends RepresentationModel<ProfessorModel> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String formacao;

    @OneToMany(mappedBy = "professor")
    private List<ProfessorMateria> professorMateria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public List<ProfessorMateria> getProfessorMateria() {
        return professorMateria;
    }

    public void setProfessorMateria(List<ProfessorMateria> professorMateria) {
        this.professorMateria = professorMateria;
    }
}
