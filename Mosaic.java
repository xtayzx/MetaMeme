import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;

class Mosaic extends Frame { 
	
	BufferedImage tired, handsome, art, blue, turq, bigSquidward, test, test2;
	
	int artwidth, tileW;
	int artheight, tileH;

	public Mosaic() {

		try {
			tired = ImageIO.read(new File("squidward.jpg"));
			handsome = ImageIO.read(new File("handsome.jpg"));
			art = ImageIO.read(new File("art.jpg"));
			turq = ImageIO.read(new File("turq.jpg"));
			blue = ImageIO.read(new File("blue.jpg"));
			test = ImageIO.read(new File("test.jpg"));
			test2 = ImageIO.read(new File("test2.jpg"));
			bigSquidward = ImageIO.read(new File("bigSquidward.jpg"));

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
		
		artwidth = test.getWidth()/2;
		artheight = test.getHeight()/2;
		
		tileW = tired.getWidth();
		tileH = tired.getHeight();

	}
	    
	 public BufferedImage calcPixelAverage(BufferedImage src, int a, int z) { //average colour for the square
		    int r = 0;
		    int g = 0;
		    int b = 0;
		    
		    int totalR = 0;
		    int totalG = 0;
		    int totalB = 0;
		    
		    int finalR = 0;
		    int finalG = 0;
		    int finalB = 0;
		    
		    int pixelNumber = 0;
		    
		    //Take the RGB values of the pixels to get the total
				    for (int i=0; i< 50; i++ ) {
				      for (int j=0; j < 50; j++ ) {   
				    	  
				    	//a and z is the different squares in the main image  
				    	Color srcRGB = new Color(src.getRGB(i+a, j+z));
				        r = srcRGB.getRed();
				        g = srcRGB.getGreen();
				        b = srcRGB.getBlue();
				        pixelNumber++;
				        
				        int pixelAvg [] = new int[3];
				     
				        totalR += r;
				        totalG += g;
				        totalB += b;
				        
				        pixelAvg[0] = (int)r;
					    pixelAvg[1] = (int)g;
					    pixelAvg[2] = (int)b;
					    
//					    System.out.println("A: "+a+" B: "+z+" // PIXEL: ("+pixelNumber+") "+pixelAvg[0]+" // "+pixelAvg[1]+" // "+pixelAvg[2]);
				      }
				    }
				    
				    //average out the values of the calculated area
				    finalR = totalR/2500;
				    finalG = totalG/2500;
				    finalB = totalB/2500;

				    float hsv[] = new float[3];
				    float hue = 0;
				    hsv = Color.RGBtoHSB(finalR, finalG, finalB, null);
				    
				    //mult by 100 cause the values are super low
				    hue = hsv[0]*100;
				    
				    System.out.println("Hue : "+hue+" // Bright: "+hsv[2]+" // Final Totals:"+" // "+finalR+" // "+finalG+" // "+finalB);
				    
				    if(hue > 11 && hue <= 100) {
				    	return blue;
				    }
				    
				    else if(hue > 2.2 && hue <= 11) {
				    	return art;
				    }
				    
				    else if(hue > 0 && hue <= 2.2) {
				    	return tired;
				    }
				    
				    else return bigSquidward;

		 }
	
//	public static int colorDecide (int v) { // I just stole this from the pokemon link and was going to try and decode
//		
//		int num = 0;	//Array subscript
//		int difference;	//Array value-Absolute value of RGB value v
//		
//		int[] list = {64,128,192,192};
//
//		difference = Math.abs( list[0] - v );
//		for (int i = 1; i < list.length; i++ ) {
//			if ( Math.abs( list[i] - v ) < difference ) {
//				num = i;
//				difference = Math.abs( list[i] - v );
//			}
//		}
//		
// 		return list[num];
//  }
	

public void paint(Graphics g) {
	this.setSize(artwidth + 5, artheight + 25);
	
//	calcPixelAverage(turq);
//	calcPixelAverage(bigSquidward);
//	calcPixel(blue);
	
	g.setColor(Color.BLACK);
    Font f1 = new Font("Consolas", Font.PLAIN, 13);  
    g.setFont(f1); 
    
    g.drawString("hoi amena i'd like to share with you the best meme to state how the rest of the semester be feeling like",30,55);
    
    int a = 0;
	int b = 0;
	
	int loop1 = artwidth/tileW;
	int loop2 = artheight/tileH;
	
    for(int i = 0; i < loop1; i++) {
    	for (int j = 0; j < loop2; j++) {

    		BufferedImage tileImage = calcPixelAverage(test, a, b);
    		g.drawImage(tileImage, j* tileW, i*tileH +25, tileW, tileH, this);
    	
    		//move to the right
    		a+=50;
    		
    		//reset back to the start
    		if (a > 500) {
    			a = 0;
    		}
    	}
    	
    	//move down
    	b+=50;
    }
    
//    g.drawImage(bigSquidward, 0, 25, 500, 500, this);
    g.setColor(Color.BLUE);
    Font f2 = new Font("Comic Sans MS", Font.PLAIN, 13);  
    g.setFont(f2); 
    g.drawString("when herbert says we need study for the final midterm as well as prepare a report and presentation",70,570); 
    
}

//public BufferedImage randomImage() {
//	
////	int[] image1 = averagePixel(tired);
////	int[] image2 = averagePixel(handsome);
////	int[] image3 = averagePixel(art);
//	
//	int value = generateNumber(1,5);
//	
//	if (value == 1) {
//		return tired;
//	}
//	
//	else if (value == 2) {
//		return blue;
//	}
//	
//	else if (value == 3) {
//		return art;
//	}
//	
//	else if (value == 4) {
//		return turq;
//	}
//	
//	else
//	return tired;
//}

//public int generateNumber(int f, int l) {
//	int min = f;
//	int max = l;
//	int randomNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
//	return randomNumber;
//}

public static void main(String[] args) {
	Mosaic img = new Mosaic();
	img.repaint();
	}
}
