package school.ferreira.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(name = "professor_materia",
            joinColumns = { @JoinColumn(name = "professor_id") },
            inverseJoinColumns = { @JoinColumn(name = "materia_id") }
    )
    private Set<MateriaModel> materia = new HashSet<>();

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

    private String getFormacao() {
        return formacao;
    }

    private void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Set<MateriaModel> getMateria() {
        return materia;
    }

    public void setMateria(Set<MateriaModel> materia) {
        this.materia = materia;
    }
}
