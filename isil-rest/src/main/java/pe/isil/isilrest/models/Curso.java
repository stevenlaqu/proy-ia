package pe.isil.isilrest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Curso implements Serializable {

    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "curso_generator")
    @SequenceGenerator(name = "curso_generator", sequenceName = "curso_seq")
    @Id
    private Integer idCurso;
    private String nombreCurso;
    private String numeroCredito;

    @OneToMany(mappedBy = "curso",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OneToMany(mappedBy = "curso_id")
    private List<Nota> notas = new ArrayList<>();

    public void addNota(Nota note){
        note.setCurso(null);
        this.notas.add(note);
    }

    public void removeNota(Nota note){
        note.setCurso(null);
        this.notas.remove(note);
    }

    @Override
    public String toString(){
        return "ID :"+idCurso;
    }
}
