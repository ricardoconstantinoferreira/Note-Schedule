package school.ferreira.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

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

    public ProfessorModel() {
    }

    public ProfessorModel(int id, String name, String formacao) {
        this.id = id;
        this.name = name;
        this.formacao = formacao;
    }

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
}
