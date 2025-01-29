package school.ferreira.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "curso")
public class CursoModel extends RepresentationModel<CursoModel> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "curso")
    private List<CursoMateria> cursoMateria;

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

    public List<CursoMateria> getCursoMateria() {
        return cursoMateria;
    }

    public void setCursoMateria(List<CursoMateria> cursoMateria) {
        this.cursoMateria = cursoMateria;
    }
}
