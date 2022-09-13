import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDb implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos (String json){

        // extrair só os dados que interessam (titulo
        var separador = new JsonParser();
        List<Map<String, String>>listaDeAtributos = separador.parse(json); 

        List<Conteudo>conteudos =  new ArrayList<>();
        // popular a lista de conteuos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$","$1.jpg");
            var conteudo = new Conteudo(titulo, urlImagem);
            
           conteudos.add(conteudo);
        }

       return conteudos;
    }
}
