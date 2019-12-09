package pe.isil.isilrest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.isilrest.models.Curso;
import pe.isil.isilrest.services.CursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CursoResource {

    @Autowired
    CursoService cursoService;

    @GetMapping("/cursos")
    public ResponseEntity getTotal(){
        List<Curso> cursos = cursoService.findAll();
        if (cursos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursos,HttpStatus.OK);
    }

    @GetMapping("/cursos/{idCurso}")
    public ResponseEntity getCurId(@PathVariable Integer idCurso){
        Optional<Curso> curso = cursoService.findById(idCurso);
        if (!curso.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso,HttpStatus.OK);
    }

    @PostMapping("/cursos")
    public ResponseEntity createCurso(@RequestBody Curso curso){
        cursoService.create(curso);
        return new ResponseEntity<>(curso,HttpStatus.CREATED);
    }
}
