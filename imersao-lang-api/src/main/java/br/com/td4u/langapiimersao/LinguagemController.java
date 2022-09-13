package br.com.td4u.langapiimersao;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {
    
    // private List<Linguagem> linguagens =
    //     List.of(
    //         new Linguagem("Java", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/java/java_256x256.png?raw=true", 2),
        
    //         new Linguagem("JS", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/javascript/javascript_256x256.png?raw=true", 1),
          
    //         new Linguagem("PHP", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/php/php_256x256.png?raw=true", 5)
    //         );

    @GetMapping("/linguagem-preferida")
        public String processaLinguagemPreferidaString(){
        return "Oi Javax!";
    }


    // @GetMapping("/inguagens")
    // public List<Linguagem> obterLinguagens(){
    //     return linguagens;
    //}
}
