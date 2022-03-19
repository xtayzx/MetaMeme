import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;

class Test extends Frame { 

	public Test() {
		try {

		} catch (Exception e) {
			System.out.println("Cannot load the provided image");
		}
		
		this.setTitle("Test");
		this.setVisible(true);

		this.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				}
				);
	}

public void paint(Graphics g) {
	this.setSize(600, 400);
}

public static void main(String[] args) {

	Test img = new Test();
	img.repaint();

	}
}
