package pe.isil.isilclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pe.isil.isilclient.models.Alumno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class AlumnoController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public  RestTemplate restTemplateAlumno(RestTemplateBuilder builder){
        return builder.build();
    }

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

    @GetMapping("/alumno")
    public String getAlumnoList(Model model){
        Alumno[] alumnos = restTemplate.getForObject("http://localhost:8080/api/alumnos",
                Alumno[].class);
        List<Alumno> alumnoList= Optional.ofNullable(alumnos).map(Arrays::asList).orElseGet(ArrayList::new);
        model.addAttribute("alumno",alumnoList);
        return "alumno";
    }

    @GetMapping("/alumno/add")
    public String addAlumno(Model model){
        model.addAttribute("alumno",new Alumno());
        return "alumno-add";
    }

    @PostMapping("/alumno/save")
    public String saveAlumno(Alumno alumno, Model model){
        restTemplate.postForObject("http://localhost:8080/api/alumnos",alumno,Alumno.class);
        Alumno[] alumnos = restTemplate.getForObject("http://localhost:8080/api/alumnos", Alumno[].class);
        List<Alumno> alumnoList = Optional.ofNullable(alumno).map(Arrays::asList).orElseGet(ArrayList::new);
        model.addAttribute("alumno",alumnoList);
        return "alumno";
    }
}
