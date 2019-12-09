package pe.isil.isilclient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Curso implements Serializable {
    private Integer idCurso;
    private String nombreCurso;
    private String numeroCredito;

    private List<Nota> notas=new ArrayList<>();

    @Override
    public String toString(){
        return "ID: "+ idCurso;
    }
}
