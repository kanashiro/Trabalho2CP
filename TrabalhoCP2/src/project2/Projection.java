package project2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Projection {

	public static void main(String[] args) throws IOException {
		BufferedImage imagem = ImageIO.read(new File("branco.png"));  
		int rgb=new Color(0,0,0).getRGB();
	     for (int i = 0; i < 100; i++) {
	            for (int j = 0; j < 100; j++) {

	            	imagem.setRGB(i, j, rgb);
	            }
	        }

	
		File outputfile = new File("Resources/Images/teste.png");
	    ImageIO.write(imagem, "png", outputfile);
	}

}
