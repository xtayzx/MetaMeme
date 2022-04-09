package image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImportedImage extends BaseImage{

	private Image importedImage;
	public ImportedImage(BufferedImage newImage) {
		importedImage = newImage;
	}
	
	@Override
	public void draw(Graphics g) {
<<<<<<< Updated upstream
	    g.drawImage(importedImage, 125, 128, 
=======
	    g.drawImage(importedImage, 125, 180, 
>>>>>>> Stashed changes
	        500, 500, null);
	}
}
