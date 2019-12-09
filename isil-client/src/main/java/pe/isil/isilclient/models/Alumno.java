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
public class Alumno implements Serializable {

    private Integer idAlumno;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreAlumno;

    private List<Nota> notas = new ArrayList<>();

    @Override
    public String toString(){
        return "ID: "+idAlumno;
    }
}
