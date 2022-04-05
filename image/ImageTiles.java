package image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageTiles extends BaseImage {

	BufferedImage tired, handsome, art, blue, turq, bigSquidward, test, test2;
	
	int artWidth, tileW;
	int artHeight, tileH;
	
	
	//TODO:
	//should add into the constructor the image to pass in for the test value and implemented in draw
	public ImageTiles() {
		try {
			tired = ImageIO.read(new File("squidward.jpg"));
			handsome = ImageIO.read(new File("handsome.jpg"));
			art = ImageIO.read(new File("art.jpg"));
			turq = ImageIO.read(new File("turq.jpg"));
			blue = ImageIO.read(new File("blue.jpg"));
			test = ImageIO.read(new File("test.jpg"));
			test2 = ImageIO.read(new File("test2.jpg"));
			bigSquidward = ImageIO.read(new File("bigSquidward.jpg"));

		} 
		
		catch (Exception e) {
			System.out.println("Cannot load the provided image");
		}
		
		artWidth = test.getWidth()/2;
		artHeight = test.getHeight()/2;
		
		tileW = tired.getWidth();
		tileH = tired.getHeight();
	}
	
	
	public BufferedImage calcPixelAverage(BufferedImage src, int a, int z) { //average color for the square in the referenced image
	    int r = 0;
	    int g = 0;
	    int b = 0;
	    
	    int avgR = 0;
	    int avgG = 0;
	    int avgB = 0;
	    
	    int pixelNumber = 0; //used to print line about determining which pixel is being calculated
	    
	    int i1 = a + 50;
	    int j1 = z +50;
	    //for all the pixels in that specific square region
			    for (int i=0; i< 50; i++ ) {
			      for (int j=0; j < 50; j++ ) {   
			    	  
			    	//a and z is the different squares in the main image  
			    	Color srcRGB = new Color(src.getRGB(i+a, j+z));
			        r += srcRGB.getRed();
			        g += srcRGB.getGreen();
			        b += srcRGB.getBlue();
			        pixelNumber++;
			      
		            int num = 2500; //averaging pixel number in 50x50 pixel square
		            
		            avgR = (int) (r/num);
		            avgG = (int) (g/num);
		            avgB = (int) (b/num);
		            
		            if(avgR>255)
						avgR=255;
					if(avgG>255)
						avgG=255;
					if(avgB>255)
						avgB=255;
					
		            if(avgR<0)
						avgR=0;
		            if(avgG<0)
						avgG=0;
		            if(avgB<0)
						avgB=0;
		            
		    	    //src.setRGB(i,j,new Color(avgR,avgG,avgB).getRGB());
			        
			        int pixelAvg [] = new int[3];

//			        totalR += r;
//			        totalG += g;
//			        totalB += b;
			        
			        pixelAvg[0] = (int)avgR;
				    pixelAvg[1] = (int)avgG;
				    pixelAvg[2] = (int)avgB;
				    
				    src.setRGB(i,j,new Color(avgR,avgG,avgB).getRGB());
				    //print line about square region that is being calculated and the values for each individual pixel
				    System.out.println("A: "+a+" B: "+z+" // PIXEL: ("+pixelNumber+") "+pixelAvg[0]+" // "+pixelAvg[1]+" // "+pixelAvg[2]);
			      }
			    }
			    

//			    float hsv[] = new float[3]; //convert values to HSV
//			    float hue = 0; //need to make hue value larger as currently it is quite small
//			    
//			    hsv = Color.RGBtoHSB(avgR, avgG, avgB, null);
//			    
//			    //mult by 100 cause the values are super low currently
//			    hue = hsv[0]*100;
//			    
//			    //see values for the average of each square in the refernced image
//			    System.out.println("Hue : "+hue+" // Bright: "+hsv[2]+" // Final Totals:"+" // "+avgR+" // "+avgG+" // "+avgB);
//			    
//			    //depending on the hue value, select this image to return
//			    if(hue > 11 && hue <= 100) {
//			    	return blue;
//			    }
//			    
//			    else if(hue > 2.2 && hue <= 11) {
//			    	return art;
//			    }
//			    
//			    else if(hue > 0 && hue <= 2.2) {
//			    	return tired;
//			    }
			    
			    return src;

	 }
	
	public static Color getAverageRGBCircle(BufferedImage img, int x, int y, int radius) {
		  float r = 0;
		  float g = 0;
		  float b = 0;
		  int num = 0;
		  
		  /* Iterate through a bounding box in which the circle lies */
		  for (int i = x - radius; i < x + radius; i++) {
		    for (int j = y - radius; j < y + radius; j++) {
		      /* If the pixel is outside the canvas, skip it */
		      if (i < 0 || i >= img.getWidth() || j < 0 || j >= img.getHeight())
		        continue;

		      /* If the pixel is outside the circle, skip it */
		      double xi = Math.abs(i-x);
		      double yj = Math.abs(j-y);
		      if (Math.hypot(xi, yj) > r)
		        continue;

		      /* Get the color from the image, add to a running sum */
		      Color srcRGB = new Color(img.getRGB(i, j));
		      r += srcRGB.getRed();
		      g += srcRGB.getGreen();
		      b += srcRGB.getBlue();
		   
		      num++;
		    }
		  }
		  
		  int sqR = (int) Math.sqrt(r/num);
		  int sqG = (int) Math.sqrt(g/num);
		  int sqB = (int) Math.sqrt(b/num);
				  
		  Color c = new Color(sqR,sqG,sqB);
		  /* Return the mean of the R, G, and B components */
		  return c;
		}

	
		@Override
		public void draw(Graphics g) {
		
		int a = 0;
		int b = 0;
		int offsetHeight = 100;
		int offsetWidth = 125;
		
		int loop1 = artWidth/tileW; //place the individual tiles for the columns
		int loop2 = artHeight/tileH; //move the placement for the individual tiles to the next row
		
		g.setColor(Color.BLACK);
		Font f1 = new Font("Consolas", Font.PLAIN, 13);  
		g.setFont(f1); 
		
		for(int i = 0; i < loop1; i++) {
			for (int j = 0; j < loop2; j++) {
				
				//TODO:
				//test from the constructor to get passed into here
				
				BufferedImage tileImage = calcPixelAverage(test, a, b); //draw the image and pass the values for the origin point of 0,0 in the pixel calculations
				g.drawImage(tileImage, j* tileW+offsetWidth, i*tileH +offsetHeight, tileW, tileH, null);
			
				//move to the right
				a += 50;
				
				//reset back to the start on the left
				if (a > 500) {
					a = 0;
				}
			}
			
			//move down
			b += 50;
			}
		}

}
