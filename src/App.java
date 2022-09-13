import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App{

    public static void main(String[] args) throws Exception {
// extrator do IMBd
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDb();

// extrator da nasa
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";  
        // ExtratorDeConteudo extrator =  new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

// manipular os dados para a usar na aplicação
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
                    
                Conteudo conteudo = conteudos.get(i);

                InputStream inputStream = new URL(conteudo.getUrlimagem()).openStream();
                String nomeArquivo = "alura_JAVA/IMDb/out/" + conteudo.getTitulo() + ".png";

                geradora.cria(inputStream, nomeArquivo);

                System.out.println(conteudo.getTitulo());
                System.out.println();
        }
    }
}
