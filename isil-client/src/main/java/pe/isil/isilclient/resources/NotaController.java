package pe.isil.isilclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pe.isil.isilclient.models.Nota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class NotaController {
  /*  @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @GetMapping("/nota")
    public String getNotaList(Model model){
        Nota[] notas = restTemplate.getForObject("http://localhost:8080/api/notas",Nota[].class);
        List<Nota> notaList = Optional.ofNullable(notas).map(Arrays::asList).orElseGet(ArrayList::new);
        model.addAttribute("nota",notaList);
        return "nota";
    }

    @GetMapping("/nota/add")
    public String addNota(Model model){
        model.addAttribute("nota",new Nota());
        return "nota-add";
    }

    @PostMapping("/nota/save")
    public String saveNota(Nota nota, Model model){
        restTemplate.postForObject("http://localhost:8080/api/notas", nota,Nota.class);
        Nota[] notas = restTemplate.getForObject("http://localhost:8080/api/notas", Nota[].class);
        List<Nota> notaList = Optional.ofNullable(notas).map(Arrays::asList).orElseGet(ArrayList::new);
        model.addAttribute("nota",notaList);
        return "nota";
    }*/
}
