///**
// * IAT 455 - Final Project (Meta Meme)
// * Spring 2022
// * Amena Salman (301363453)
// * Taylen Lee-Chin (301371610)
// **/
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Frame;
//import java.awt.Graphics;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.image.BufferedImage;
//import java.io.File;
//
//import javax.imageio.ImageIO;
//import javax.swing.JFrame;
//
//class Mosaic extends JFrame { 
//	
//	BufferedImage tired, handsome, art, blue, turq, bigSquidward, test, test2;
//	
//	int artwidth, tileW;
//	int artheight, tileH;
//
//	public Mosaic() {
//
//		try {
//			tired = ImageIO.read(new File("squidward.jpg"));
//			handsome = ImageIO.read(new File("handsome.jpg"));
//			art = ImageIO.read(new File("art.jpg"));
//			turq = ImageIO.read(new File("turq.jpg"));
//			blue = ImageIO.read(new File("blue.jpg"));
//			test = ImageIO.read(new File("test.jpg"));
//			test2 = ImageIO.read(new File("test2.jpg"));
//			bigSquidward = ImageIO.read(new File("bigSquidward.jpg"));
//
//		} 
//		
//		catch (Exception e) {
//			System.out.println("Cannot load the provided image");
//		}
//		
//		this.setTitle("IAT 455 - Rocket Power");
//		this.setVisible(true);
//
//		this.addWindowListener(
//				new WindowAdapter(){
//					public void windowClosing(WindowEvent e){
//						System.exit(0);
//					}
//				}
//		);
//		
//		//image is currently 1000x1000 so this is calculated down in half to make 500x500
//		artwidth = test.getWidth()/2;
//		artheight = test.getHeight()/2;
//		
//		tileW = tired.getWidth();
//		tileH = tired.getHeight();
//
//	}
//	    
////	 public BufferedImage calcPixelAverage(BufferedImage src, int a, int z) { //average color for the square in the referenced image
////		    int r = 0;
////		    int g = 0;
////		    int b = 0;
////		    
////		    int totalR = 0;
////		    int totalG = 0;
////		    int totalB = 0;
////		    
////		    int finalR = 0;
////		    int finalG = 0;
////		    int finalB = 0;
////		    
////		    int pixelNumber = 0; //used to print line about determining which pixel is being calculated
////		    
////		    //for all the pixels in that specific square region
////				    for (int i=0; i< 50; i++ ) {
////				      for (int j=0; j < 50; j++ ) {   
////				    	  
////				    	//a and z is the different squares in the main image  
////				    	Color srcRGB = new Color(src.getRGB(i+a, j+z));
////				        r = srcRGB.getRed();
////				        g = srcRGB.getGreen();
////				        b = srcRGB.getBlue();
////				        pixelNumber++;
////				        
////				        int pixelAvg [] = new int[3];
////				     
////				        totalR += r;
////				        totalG += g;
////				        totalB += b;
////				        
////				        pixelAvg[0] = (int)r;
////					    pixelAvg[1] = (int)g;
////					    pixelAvg[2] = (int)b;
////					    
////					    //print line about square region that is being calculated and the values for each individual pixel
////					    //System.out.println("A: "+a+" B: "+z+" // PIXEL: ("+pixelNumber+") "+pixelAvg[0]+" // "+pixelAvg[1]+" // "+pixelAvg[2]);
////				      }
////				    }
////				    
////				    //average out the pixel values of the calculated square area
////				    finalR = totalR/2500;
////				    finalG = totalG/2500;
////				    finalB = totalB/2500;
////
////				    float hsv[] = new float[3]; //convert values to HSV
////				    float hue = 0; //need to make hue value larger as currently it is quite small
////				    
////				    hsv = Color.RGBtoHSB(finalR, finalG, finalB, null);
////				    
////				    //mult by 100 cause the values are super low currently
////				    hue = hsv[0]*100;
////				    
////				    //see values for the average of each square in the refernced image
////				    System.out.println("Hue : "+hue+" // Bright: "+hsv[2]+" // Final Totals:"+" // "+finalR+" // "+finalG+" // "+finalB);
////				    
////				    //depending on the hue value, select this image to return
////				    if(hue > 11 && hue <= 100) {
////				    	return blue;
////				    }
////				    
////				    else if(hue > 2.2 && hue <= 11) {
////				    	return art;
////				    }
////				    
////				    else if(hue > 0 && hue <= 2.2) {
////				    	return tired;
////				    }
////				    
////				    else return bigSquidward;
////
////		 }
////	
////
////public void paint(Graphics g) {
////	
////	//slightly offset as it currently creates the first image out of bounds of the window size
////	this.setSize(artwidth + 5, artheight + 25);
////    
////    int a = 0;
////	int b = 0;
////	
////	int loop1 = artwidth/tileW; //place the individual tiles for the columns
////	int loop2 = artheight/tileH; //move the placement for the individual tiles to the next row
////	
////	g.setColor(Color.BLACK);
////    Font f1 = new Font("Consolas", Font.PLAIN, 13);  
////    g.setFont(f1); 
////	
////    for(int i = 0; i < loop1; i++) {
////    	for (int j = 0; j < loop2; j++) {
////    		BufferedImage tileImage = calcPixelAverage(test, a, b); //draw the image and pass the values for the origin point of 0,0 in the pixel calculations
////    		g.drawImage(tileImage, j* tileW, i*tileH +25, tileW, tileH, this);
////    	
////    		//move to the right
////    		a+=50;
////    		
////    		//reset back to the start on the left
////    		if (a > 500) {
////    			a = 0;
////    		}
////    	}
////    	
////    	//move down
////    	b+=50;
////    }
//    
////  g.drawImage(bigSquidward, 0, 25, 500, 500, this);
//    
//}
//
////test function created to see if images would be placed properly in selected areas
//
////public BufferedImage randomImage() {
////	
////	int[] image1 = averagePixel(tired);
////	int[] image2 = averagePixel(handsome);
////	int[] image3 = averagePixel(art);
////	
////	int value = generateNumber(1,5);
////	
////	if (value == 1) {
////		return tired;
////	}
////	
////	else if (value == 2) {
////		return blue;
////	}
////	
////	else if (value == 3) {
////		return art;
////	}
////	
////	else if (value == 4) {
////		return turq;
////	}
////	
////	else
////	return tired;
////}
//
////test function to generate a random number with min value and max value
//
////public int generateNumber(int f, int l) {
////	int min = f;
////	int max = l;
////	int randomNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
////	return randomNumber;
////}
//
//public static void main(String[] args) {
//	Mosaic img = new Mosaic();
//	img.repaint();
//	}
//}
