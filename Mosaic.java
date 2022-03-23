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

class Mosaic extends Frame { 
	
	BufferedImage test;
	
	int width;
	int height;

	public Mosaic() {
		
	
		
		try {
			test = ImageIO.read(new File("squidward.jpg"));

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
		
		width = test.getWidth();
		height = test.getHeight();
	}

public void paint(Graphics g) {
	this.setSize(850, 500);
	
	g.setColor(Color.BLACK);
    Font f1 = new Font("Consolas", Font.PLAIN, 13);  
    g.setFont(f1); 
    
//    g.drawString("hoi amena", 30, 70); 
//    g.drawString("henlo tay tay", 30, 120); 
//    g.drawString("{^0.0^} meow", 30, 160); 
    
    g.drawString("hoi amena i'd like to share with you the best meme to state how the rest of the semester be feeling like",30,55); 
    g.drawImage(test,70,100,width,height,this);
    
    g.setColor(Color.BLUE);
    Font f2 = new Font("Comic Sans MS", Font.PLAIN, 13);  
    g.setFont(f2); 
    g.drawString("when herbert says we need study for the final midterm as well as prepare a report and presentation",70,450); 
    
}

public static void main(String[] args) {

	Mosaic img = new Mosaic();
	img.repaint();
	}
}
