package image;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageTiles {

	BufferedImage tired, handsome, art, blue, turq, bigSquidward, test, test2;
	
	int artWidth, tileW;
	int artHeight, tileH;
	
	public ImageTiles() {
		try {
			tired = ImageIO.read(new File("squidward.jpg"));
			handsome = ImageIO.read(new File("handsome.jpg"));
			art = ImageIO.read(new File("art.jpg"));
			turq = ImageIO.read(new File("turq.jpg"));
			blue = ImageIO.read(new File("blue.jpg"));
			test = ImageIO.read(new File("test.jpg"));
			test2 = ImageIO.read(new File("test2.jpg"));
			bigSquidward = ImageIO.read(new File("bigSquidward.jpg"));

		} 
		
		catch (Exception e) {
			System.out.println("Cannot load the provided image");
		}
		
		artWidth = test.getWidth()/2;
		artHeight = test.getHeight()/2;
		
		tileW = tired.getWidth();
		tileH = tired.getHeight();
	}
}
