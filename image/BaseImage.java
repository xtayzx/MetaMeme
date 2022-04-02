package image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BaseImage extends ImageTemp{
	
//	public Image image0;
	public BaseImage() {
//	    try {
//	        image0 = ImageIO.read(new File("blue.jpg"));
//	    } catch (IOException e) {
//	        System.err.println("Cannot load base image photo");
//	    }
	}
	
	@Override
	public void draw(Graphics g) {
//		g.setColor(Color.BLUE);
//		g.drawRect(100,100,500,500);
//		
//		g.drawImage(image0, 100, 100, 
//		        500, 500, null);
	}

}
