package project2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagePorjection {
	
	// Variables //
	// points of origin (order => leftTop -> rightTop -> rightBottom -> leftBottom)
	int x1 = 417;
	int y1 = 39;
	int x2 = 861;
	int y2 = 39;
	int x3 = 771;
	int y3 = 130;
	int x4 = 441;
	int y4 = 130;
	
	// resolutions
	int originX = 1024;
	int originY = 787;
	int textureX = 1920;
	int textureY = 1200;
	
	// limits of area to insert texture
	double a1,b1,a2,b2,a3,b3,a4,b4;
	
	// Matriz H
	double H[][] = { {5.818 , -1.534 , -2366.337}, {0 , 13.186 , -514.285}, { 0 , -0.004, 1.494} };
	
	public void GenerateLinesOfLimits(){
		this.a1 = (this.y1 - this.y2)/(this.x1 - this.x2);
		this.b1 = (this.x1*this.y2 - this.y1*this.x2)/(this.x1-this.x2);
		this.a2 = (this.y2 - this.y3)/(this.x2 - this.x3);
		this.b2 = (this.x2*this.y3 - this.y2*this.x3)/(this.x2-this.x3);
		this.a3 = (this.y3 - this.y4)/(this.x3 - this.x4);
		this.b3 = (this.x3*this.y4 - this.y3*this.x4)/(this.x3-this.x4);
		this.a4 = (this.y4 - this.y1)/(this.x4 - this.x1);
		this.b4 = (this.x4*this.y1 - this.y4*this.x1)/(this.x4-this.x1);
	}
	
	public double[] Transformation(double[][] matrixH, double[] vector){		
		double[] result = new double[3];
		result[0] = vector[0]*matrixH[0][0] +  vector[1]*matrixH[1][0] + vector[2]*matrixH[2][0];
		result[1] = vector[0]*matrixH[0][1] +  vector[1]*matrixH[1][1] + vector[2]*matrixH[2][1];
		result[2] = vector[0]*matrixH[0][2] +  vector[1]*matrixH[1][2] + vector[2]*matrixH[2][2];
		
		return result;
	}
	
	public void ProjectImage() throws IOException{
		BufferedImage img = ImageIO.read(new File("Resources/Images/quarto-2.png")); 
		BufferedImage texture = ImageIO.read(new File("Resources/Images/ceu.png"));  
		
		
	}
	
	public void TradeColor(BufferedImage origin, BufferedImage texture){
		
		
		for (int i = 0; i < originY; i++) {
			for (int j = 0; j < originX ; j++) {
				
			}
		}
	}
	
}