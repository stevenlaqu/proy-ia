package pe.isil.isilrest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.isilrest.models.Nota;
import pe.isil.isilrest.services.NotaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NotaResource {

    @Autowired
    NotaService notaService;

    @GetMapping("/notas")
    public ResponseEntity getTotal(){
        List<Nota> notas = notaService.findAll();
        if (notas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notas,HttpStatus.OK);
    }

    @GetMapping("/nostas/{idNota}")
    public ResponseEntity getNotaId(@PathVariable Integer idNota){
        Optional<Nota> nota = notaService.findById(idNota);
        if (!nota.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nota,HttpStatus.OK);
    }

    @PostMapping("/notas")
    public ResponseEntity createdNota(@RequestBody Nota nota){
        notaService.create(nota);
        return new ResponseEntity<>(nota,HttpStatus.CREATED);
    }


}
