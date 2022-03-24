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
	
	BufferedImage tired, handsome, art;
	
	int artwidth, tileW;
	int artheight, tileH;

	public Mosaic() {

		try {
			tired = ImageIO.read(new File("squidward.jpg"));
			handsome = ImageIO.read(new File("handsome.jpg"));
			art = ImageIO.read(new File("art.jpg"));

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
		
		artwidth = art.getWidth();
		artheight = art.getHeight();
		
		tileW = tired.getWidth();
		tileH = tired.getHeight();
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
	
	public void imgPick (BufferedImage src) { // same as reduceColor.java
		
		
	}
	
	public static int colorDecide (int v) { // I just stole this from the pokemon link and was going to try and decode
		int num = 0;	//Array subscript
		int difference;	//Array value-Absolute value of RGB value v
		
		int[] list = {64,128,192,192};

		difference = Math.abs( list[0] - v );
		
		for ( int i = 1; i < list.length; i++ ) {
			if ( Math.abs( list[i] - v ) < difference ) {
				num = i;
				difference = Math.abs( list[i] - v );
			}
		}
 		return list[num];
  }

	
	

public void paint(Graphics g) {
	this.setSize(artwidth + 5, artheight + 25);
	
	g.setColor(Color.BLACK);
    Font f1 = new Font("Consolas", Font.PLAIN, 13);  
    g.setFont(f1); 
    
    g.drawString("hoi amena i'd like to share with you the best meme to state how the rest of the semester be feeling like",30,55);
    
    for(int i = 0; i < artwidth/tileW; i++) {
    	for (int j = 0; j < artheight/tileH; j++) {
    	g.drawImage(tired, j* tileW, i*tileH +25, tileW, tileH, this);
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
