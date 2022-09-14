import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
// extrator do IMBd
    //seta a URL fonte do JSON
       //  String url = "https://imdb-api.com/en/API/Top250Movies/k_djuhulxo";
    // escolhe qual metodo do extrator usar
       // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
   
// extrator da NASA
    //seta a URL fonte do JSON
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
    // escolhe qual metodo do extrator usar
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

// extrator do meu APP no HEROKU
        //seta a URL fonte do JSON
           String url = "http://localhost:8080/lang";
        // escolhe qual metodo do extrator usar
           ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // chama o metodo do HTTP para requisição
        var http = new ClienteHttp();
        // passa para o metodo http a URL para busca
        String json = http.buscaDados(url);

// manipular os dados para a usar na aplicação
        // define como uma lista de dados o retorno extraidos do JSON
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // chama o metodo para tirar do JSON a imagem
        var geradora = new GeradoraDeFigurinhas();

        // loop para tratar cada item da lista por Indice
        for (int i = 0; i < conteudos.size(); i++) {

            Conteudo conteudo = conteudos.get(i);

            // chama o metodo usando o Stream para qualquer tipo de dados em bites para imagem baixada ou links
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            // metodo conteudo puxa de um 'molde' para usar o titulo e a url da imagem
            String nomeArquivo = "api-stickers/saida/" + conteudo.getTitulo() + ".png";

            // metodo que puxa os dados, edita as dimenções, escreve nela e salva como png
            geradora.cria(inputStream, nomeArquivo, conteudo.getTitulo());

            // retorno no console para ver o resultado de cada item da lista no loop
            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}

