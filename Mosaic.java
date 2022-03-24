import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
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

	public static int [] averagePixel(BufferedImage src) {
	  
	    int r = 0;
	    int g = 0;
	    int b = 0;
	    
	    //Take the RGB values of the pixels to get the total
	    for (int i=0; i< 50; i++ ) {
	      for (int j=0; j < 50; j++ ) {
	        
	    	  Color srcRGB = new Color(src.getRGB(i, j));
	        
	        r = srcRGB.getRed();
	        g = srcRGB.getGreen();
	        b = srcRGB.getBlue();
	      }
	    }

	    int pixelAvg [] = new int[3];
	    pixelAvg[0] = (int)r/2500;
	    pixelAvg[1] = (int)g/2500;
	    pixelAvg[2] = (int)b/2500;

	    return pixelAvg;
	 }
	

public void paint(Graphics g) {
	this.setSize(1000, 600);
	
	g.setColor(Color.BLACK);
    Font f1 = new Font("Consolas", Font.PLAIN, 13);  
    g.setFont(f1); 
    
    g.drawString("hoi amena i'd like to share with you the best meme to state how the rest of the semester be feeling like",30,55);
    
    for(int i = 0; i < 8; i++) {
    	for (int j = 0; j < 12; j++) {
    	g.drawImage(test,(j*50)+70,(i*50)+100,width,height,this);
    	}
    }
    
    
    g.setColor(Color.BLUE);
    Font f2 = new Font("Comic Sans MS", Font.PLAIN, 13);  
    g.setFont(f2); 
    g.drawString("when herbert says we need study for the final midterm as well as prepare a report and presentation",70,570); 
    
}

public static void main(String[] args) {

	Mosaic img = new Mosaic();
	img.repaint();
	}
}
