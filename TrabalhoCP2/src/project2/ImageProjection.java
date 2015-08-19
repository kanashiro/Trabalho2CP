package project2;

import java.awt.Color;
import java.awt.event.TextEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProjection {

	// Matriz H
	double H[][] = { { 2.233277493, 8.12711509, -1541.9018 }, { -1.058543289, 5.1628951, 541.5247824 },
			{ -0.000002324, -0.0019598, 1.302112209 } };

	// images names
	String originName = "Resources/Images/quarto-bebe.jpg";
	String textureName = "Resources/Images/ceu-bebe.jpg";

	public double[] Transformation(double[][] matrixH, double[] vector) {
		double[] result = new double[3];
		result[0] = vector[0] * matrixH[0][0] + vector[1] * matrixH[0][1]
				+ vector[2] * matrixH[0][2];
		result[1] = vector[0] * matrixH[1][0] + vector[1] * matrixH[1][1]
				+ vector[2] * matrixH[1][2];
		result[2] = vector[0] * matrixH[2][0] + vector[1] * matrixH[2][1]
				+ vector[2] * matrixH[2][2];

		result[0] = result[0]/result[2];
		result[1] = result[1]/result[2];
		
		return result;
	}

	public void ProjectImage() throws IOException {
		BufferedImage origin = ImageIO.read(new File(this.originName));
		BufferedImage texture = ImageIO.read(new File(this.textureName));

		this.TradeColor(origin, texture);

		File outputfile = new File("Resources/Images/teste1.png");
		ImageIO.write(origin, "png", outputfile);
	}

	public void TradeColor(BufferedImage origin, BufferedImage texture) {
		int colorToTrade = new Color(0, 0, 0).getRGB();
		double[] texturePoint = new double[3];
		double[] vector = new double[3];

		for (int i = 0; i < origin.getHeight(); i++) {
			for (int j = 0; j < origin.getWidth(); j++) {

				vector[0] = j;
				vector[1] = i;
				vector[2] = 1;

				texturePoint = Transformation(this.H, vector);
				int x = (int) Math.round(texturePoint[0]);
				int y = (int) Math.round(texturePoint[1]);
				if (x < texture.getWidth() && y < texture.getHeight() && x >= 0
						&& y >= 0) {
					System.out.println(x + " | " + y);
					colorToTrade = texture.getRGB(x, y);
					origin.setRGB(j, i, colorToTrade);
				}

			}
		}
	}

}
