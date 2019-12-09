package pe.isil.isilclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pe.isil.isilclient.models.Curso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class CursoController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplateCurso(RestTemplateBuilder builder){
        return builder.build();
    }

    @GetMapping("/curso")
    public String getCursoList(Model model){
        Curso[] cursos = restTemplate.getForObject("http://localhost:8080/api/cursos",
                Curso[].class);
        List<Curso> cursoList = Optional.ofNullable(cursos).map(Arrays::asList).orElseGet(ArrayList::new);
        model.addAttribute("curso",cursoList);
        return "curso";
    }

    @GetMapping("/curso/add")
    public String addCurso(Model model){
        model.addAttribute("curso",new Curso());
        return "curso-add";
    }

    @PostMapping("/curso/save")
    public String saveCurso(Curso curso, Model model){
        restTemplate.postForObject("http://localhost:8080/api/cursos", curso,Curso.class);
        Curso[] cursos=restTemplate.getForObject("http://localhost:8080/api/cursos",Curso[].class);
        List<Curso> cursoList = Optional.ofNullable(cursos).map(Arrays::asList).orElseGet(ArrayList::new);
        model.addAttribute("curso",cursoList);
        return "curso";
    }

}
