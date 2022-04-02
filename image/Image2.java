package image;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image2 extends ImageSelect {
	public Image image2;
	public Image2() {
	    try {
	        image2 = ImageIO.read(new File("test.jpg"));
	    } catch (IOException e) {
	        System.err.println("Cannot load test photo");
	    }
	}
	
	@Override
	public void draw(Graphics g) {
	    g.drawImage(image2, 100, 100, 
	        500, 500, null);
	}
}
