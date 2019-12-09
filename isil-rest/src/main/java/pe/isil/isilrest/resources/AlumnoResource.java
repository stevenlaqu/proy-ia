package pe.isil.isilrest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.isilrest.models.Alumno;
import pe.isil.isilrest.services.AlumnoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlumnoResource {
    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public ResponseEntity getTotal(){
        List<Alumno> alumnos = alumnoService.findAll();
        if (alumnos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnos,HttpStatus.OK);
    }

    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity getAluId(@PathVariable Integer idAlumno){
        Optional<Alumno> alumno = alumnoService.findById(idAlumno);
        if (!alumno.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(alumno,HttpStatus.OK);
    }

    @PostMapping("/alumnos")
    public ResponseEntity createAlumno(@RequestBody Alumno alumno){
        alumnoService.create(alumno);
        return new ResponseEntity<>(alumno, HttpStatus.CREATED);
    }

}
