package image;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image1 extends BaseImage{
	public Image image1;
	public Image1() {
	    try {
	        image1 = ImageIO.read(new File("bigSquidward.jpg"));
	    } catch (IOException e) {
	        System.err.println("Cannot load Image 1 photo");
	    }
	}
	
	@Override
	public void draw(Graphics g) {
	    g.drawImage(image1, 125, 100, 
	        500, 500, null);
	}
}
