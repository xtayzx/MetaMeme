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
		
		this.setTitle("IAT 455 - Rocket Power");
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
	
	g.setColor(Color.BLACK);
    Font f1 = new Font("Verdana", Font.PLAIN, 13);  
    g.setFont(f1); 
    
    g.drawString("hoi amena", 30, 70); 
    g.drawString("henlo tay tay", 30, 120); 
    g.drawString("{^0.0^} meow", 30, 160); 
}

public static void main(String[] args) {

	Test img = new Test();
	img.repaint();
	}
}
