package pe.isil.isilclient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Nota implements Serializable {
    private Integer idNota;
    private Integer ev1;
    private Integer ev2;
    private Integer ev3;
    private Integer ev4;
    private Integer ep1;
    private Integer ep2;
    private Integer exParcial;
    private Integer exFinal;

    @Override
    public String toString(){
        return "ID: "+idNota;
    }
}
