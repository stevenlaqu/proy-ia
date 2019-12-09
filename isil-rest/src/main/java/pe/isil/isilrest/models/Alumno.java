package pe.isil.isilrest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Alumno implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_generator")
    @SequenceGenerator(name = "alumno_generator", sequenceName = "alumno_seq")
    @Id
    private Integer idAlumno;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreAlumno;

    //@JsonIgnore
    @OneToMany(mappedBy = "alumno",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OneToMany(mappedBy = "alumno_id")
    private List<Nota> notas = new ArrayList<>();

    public void addNota(Nota not){
        not.setAlumno(this);
        this.notas.add(not);
    }

    public void removeNota(Nota not){
        not.setAlumno(null);
        this.notas.remove(not);
    }

    @Override
    public String toString(){
        return "ID: "+idAlumno;
    }
}
