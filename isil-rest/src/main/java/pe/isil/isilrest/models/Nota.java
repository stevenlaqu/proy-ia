package pe.isil.isilrest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"alumno","handler"})
public class Nota implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nota_generator")
    @SequenceGenerator(name = "nota_generator",sequenceName = "nota_seq")
    @Id
    private Integer idNota;
    private Integer ev1;
    private Integer ev2;
    private Integer ev3;
    private Integer ev4;
    private Integer ep1;
    private Integer ep2;
    private Integer exParcial;
    private Integer exFinal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCurso",referencedColumnName = "idCurso")
    private Curso curso;

    @Override
    public String toString(){
        return "id:"+idNota;
    }

}
