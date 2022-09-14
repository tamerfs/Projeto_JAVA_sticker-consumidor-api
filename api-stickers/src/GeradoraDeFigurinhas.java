import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    

    public void cria(InputStream inputStream, String nomeArquivo, String Titulo) throws Exception {

        // leitura da imagem podendo usar um arquivo baixado ou URL
        // InputStream inputStream =
        //             new FileInputStream(new File("entrada/filme-maior.jpg"));
        // InputStream inputStream =
        //             new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        //                 .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImage = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // ideia de por um condicionador se a largura for >= 512 usar 40 ( no graphics Font), se for >= 30 ...

        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImage.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // ideia de acrescentar no extrator o Hanking e passar ele de volta ao APP e
        // no APP passar como Argumento no metodo e escrever na imagem com o DRAW

        // escrever uma frase na nova imagem
        graphics.drawString("Linguagem: "+ Titulo, 50, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImage, "png", new File(nomeArquivo));

    }

}
