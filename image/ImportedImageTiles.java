package image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;

public class ImportedImageTiles extends BaseImage implements ImageObserver {
BufferedImage test, avgTest;
	
	int width, tileW;
	int height, tileH;
	
	public BufferedImage test2, importedImage;
	
	
	//TODO:
	//should add into the constructor the image to pass in for the test value and implemented in draw
	public ImportedImageTiles(BufferedImage selected) {
		try {
//			tired = ImageIO.read(new File("squidward.jpg"));
//			test = ImageIO.read(new File("handsome.jpg"));
//			art = ImageIO.read(new File("art.jpg"));
//			turq = ImageIO.read(new File("turq.jpg"));
//			blue = ImageIO.read(new File("blue.jpg"));
//			handsome = ImageIO.read(new File("test.jpg"));
			test2 = ImageIO.read(new File("test2.jpg"));
//			bigSquidward = ImageIO.read(new File("bigSquidward.jpg"));

		} 
		
		catch (Exception e) {
			System.out.println("Cannot load the provided image");
		}
		
		width = 500; // image width
		height = 500; // image height
		
		tileW = 10;
		tileH = 10;
		
		importedImage = selected;

		avgTest = tiler(importedImage);
		
	}
	
	public BufferedImage tiler(BufferedImage imported) {
		
		WritableRaster wRaster = imported.copyData(null);
		BufferedImage img = new BufferedImage(imported.getColorModel(), wRaster, imported.isAlphaPremultiplied(), null);
	
		for (int i = 0; i < width; i += tileW ) {
			for (int j = 0; j <  height; j += tileH) {
				
				int r = 0;
				int g = 0;
				int b = 0;

				int avgR = 0;
				int avgG = 0;
				int avgB = 0;
				
				int num = 0;
				
				Color averageColor;
				
				
				for (int u = i; u < i + tileW; u++ ) {
					for(int v = j; v < j + tileH; v++) {
//						System.out.println("I:" + i);
//						
//						System.out.println("U:" + u);
//						
//						System.out.println("J:"+ j);
//						
//						System.out.println("V:"+ v);

						Color tRGB = new Color(imported.getRGB(u, v)); // get rgb values of each pixel

						// get separated rgb values of each pixel
						r += tRGB.getRed();
						g += tRGB.getGreen();
						b += tRGB.getBlue();
					
					}
				}

				num = tileW*tileH;
				
				avgR = (int) (r / num);
				avgG = (int) (g / num);
				avgB = (int) (b / num);

				System.out.println("R: " + avgR + "G: " + avgG + "B: " + avgB);

				if (avgR > 255)
					avgR = 255;
				if (avgG > 255)
					avgG = 255;
				if (avgB > 255)
					avgB = 255;

				if (avgR < 0)
					avgR = 0;
				if (avgG < 0)
					avgG = 0;
				if (avgB < 0)
					avgB = 0;
				
				System.out.println("R: " + avgR + " G:" + avgG + " B:" + avgB);

				averageColor = new Color(avgR, avgG, avgB);
				System.out.println("average: " + averageColor);


				for (int u = i; u < i + tileW; u++ ) {
					for(int v = j; v < j + tileH; v++) {
						img.setRGB(u,v, new Color(avgR, avgG, avgB).getRGB());
					}
				}
			}
		}
		
		return img;
	}
	
	public void draw(Graphics g) {
		// draw all the images and texts
		int w = width;
		int h = height;

//		this.setSize(width * 3, (int) (height * 1.5));
		
		g.drawImage(avgTest, 125, 128, w, h, this);

	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
