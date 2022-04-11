package image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImportedImageTiles extends BaseImage implements ImageObserver {
	BufferedImage test, tiledImage;
	
	int width, tileW, height, tileH;
	
	public ArrayList<Integer> tileVal = new ArrayList<Integer>();
	
	public BufferedImage importedImage, tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8;
	
	public ImportedImageTiles(BufferedImage selected) {
		try {
//			tired = ImageIO.read(new File("squidward.jpg"));
//			test = ImageIO.read(new File("handsome.jpg"));
//			art = ImageIO.read(new File("art.jpg"));
//			turq = ImageIO.read(new File("turq.jpg"));
//			blue = ImageIO.read(new File("blue.jpg"));
//			handsome = ImageIO.read(new File("test.jpg"));
			test = ImageIO.read(new File("handsome.jpg"));
//			test2 = ImageIO.read(new File("test2.jpg"));
//			bigSquidward = ImageIO.read(new File("bigSquidward.jpg"));
			
			tile1 = ImageIO.read(new File("tile1.jpg"));
			tile2 = ImageIO.read(new File("tile2.jpg"));
			tile3 = ImageIO.read(new File("tile3.jpg"));
			tile4 = ImageIO.read(new File("tile4.jpg"));
			tile5 = ImageIO.read(new File("tile5.jpg"));
            tile6 = ImageIO.read(new File("tile6.jpg"));
            tile7 = ImageIO.read(new File("tile7.jpg"));
            tile8 = ImageIO.read(new File("tile8.jpg"));
		} 
		
		catch (Exception e) {
			System.out.println("Cannot load the provided image");
		}
		
		width = 500; // image width
		height = 500; // image height
		
		tileW = 10;
		tileH = 10;
		
		importedImage = selected;
		
		tileAverage(tile1);
		tileAverage(tile2);
		tileAverage(tile3);
		tileAverage(tile4);
		tileAverage(tile5);
		tileAverage(tile6);
		tileAverage(tile7);
		tileAverage(tile8);

		tiledImage = generateImage(importedImage, tileVal);
		
	}
	
	public BufferedImage compositeAverage(BufferedImage imported) {
		WritableRaster wRaster = imported.copyData(null);
		BufferedImage img = new BufferedImage(imported.getColorModel(), wRaster, imported.isAlphaPremultiplied(), null);
	
		for (int i = 0; i < width; i += tileW ) {
			for (int j = 0; j <  height; j += tileH) {
				
				int r = 0;
				int g = 0;
				int b = 0;

				int avgR = 0;
				int avgG = 0;
				int avgB = 0;
				
				int num = 0;
				
				Color averageColor;
				
				for (int u = i; u < i + tileW; u++ ) {
					for(int v = j; v < j + tileH; v++) {

						Color tRGB = new Color(imported.getRGB(u, v)); // get rgb values of each pixel

						// get separated rgb values of each pixel
						r += tRGB.getRed();
						g += tRGB.getGreen();
						b += tRGB.getBlue();
					}
				}

				//divide by pixels in the region
				num = tileW*tileH;
				
				avgR = (int) (r / num);
				avgG = (int) (g / num);
				avgB = (int) (b / num);

				System.out.println("R: " + avgR + "G: " + avgG + "B: " + avgB);

				if (avgR > 255)
					avgR = 255;
				if (avgG > 255)
					avgG = 255;
				if (avgB > 255)
					avgB = 255;

				if (avgR < 0)
					avgR = 0;
				if (avgG < 0)
					avgG = 0;
				if (avgB < 0)
					avgB = 0;
				
				System.out.println("R: " + avgR + " G:" + avgG + " B:" + avgB);
				averageColor = new Color(avgR, avgG, avgB);
				System.out.println("average: " + averageColor);

				//drawing each tile
				for (int u = i; u < i + tileW; u++ ) {
					for(int v = j; v < j + tileH; v++) {
						img.setRGB(u,v, new Color(avgR, avgG, avgB).getRGB());
					}
				}
			}
		}
		
		return img;
	}
	
	public ArrayList<Integer> regionAverage(BufferedImage src) { //goes through each til (50x50 squares of source image, average colour then returns)
		int avgCol= 0;
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		for (int i = 0; i < width; i += tileW ) {
			for (int j = 0; j <  height; j += tileH) {
				
				int r = 0;
				int g = 0;
				int b = 0;
				
				int avgR = 0;
				int avgG = 0;
				int avgB = 0;
			
				int num = tileW*tileH;

				Color averageColor;
				for (int u = i; u < i + tileW; u++ ) {
					for(int v = j; v < j + tileH; v++) {
					
						Color tRGB = new Color(importedImage.getRGB(u, v)); // get rgb values of each pixel

						// get separated rgb values of each pixel
						r += tRGB.getRed();
						g += tRGB.getGreen();
						b += tRGB.getBlue();
													
						avgR = (int) (r / num);
						avgG = (int) (g / num);
						avgB = (int) (b / num);

						//System.out.println("R: " + avgR + "G: " + avgG + "B: " + avgB);

						if (avgR > 255)
							avgR = 255;
						if (avgG > 255)
							avgG = 255;
						if (avgB > 255)
							avgB = 255;

						if (avgR < 0)
							avgR = 0;
						if (avgG < 0)
							avgG = 0;
						if (avgB < 0)
							avgB = 0;
						
						averageColor = new Color(avgR, avgG, avgB);
						avgCol = averageColor.getRGB();
					}
				}
				results.add(avgCol);
			}
		}
		for (int i = 0; i < results.size(); i++) {
		      System.out.println("Result #"+i+" :"+results.get(i));
		    }
		
		return results;
	}
	
	public void tileAverage(BufferedImage src) {
		int c = 0;
		int r = 0;
		int g = 0;
		int b = 0;
	
		int avgR = 0;
		int avgG = 0;
		int avgB = 0;
		
		Color averageColor;

		int num = tileW*tileH;
		for (int i = 0; i < tileW; i ++ ) {
			for (int j = 0; j <  tileH; j ++) {
				
				Color tRGB = new Color(src.getRGB(i, j)); // get rgb values of each pixel

				// get separated rgb values of each pixel
				r += tRGB.getRed();
				g += tRGB.getGreen();
				b += tRGB.getBlue();
											
				avgR = (int) (r / num);
				avgG = (int) (g / num);
				avgB = (int) (b / num);

				//System.out.println("R: " + avgR + "G: " + avgG + "B: " + avgB);

				if (avgR > 255)
					avgR = 255;
				if (avgG > 255)
					avgG = 255;
				if (avgB > 255)
					avgB = 255;

				if (avgR < 0)
					avgR = 0;
				if (avgG < 0)
					avgG = 0;
				if (avgB < 0)
					avgB = 0;
				
				averageColor = new Color(avgR, avgG, avgB);
				c = averageColor.getRGB();
			}
		}
		
		tileVal.add(c);
	}
	
	public BufferedImage generateImage(BufferedImage src, ArrayList<Integer> tile) {
		WritableRaster wRaster = src.copyData(null);
		BufferedImage img = new BufferedImage(src.getColorModel(), wRaster, src.isAlphaPremultiplied(), null);

		ArrayList<Integer> region = new ArrayList<Integer>();
		region = regionAverage(src);
		
		System.out.println( "SECTION# "+region.size()); //gives 2500 vals
		System.out.println( "TILE# "+tile.size()); //gives 2500 vals
		System.out.println( "TILE AVG " + tile); //gives 2500 vals
		
		int a = 0;
		int b = 0;

		for (int w = 0; w < region.size();w++) {
			float record = 256;
			int select = 0;
			
			float[] hsvTile = new float[3];
			float[] hsvRegion = new float[3];
			
			Color regionColor = new Color(region.get(w));
			int regionR = regionColor.getRed();
			int regionG = regionColor.getGreen();
			int regionB = regionColor.getBlue();
			
			
			//System.out.println("W//"  + w);
			
			for (int k = 0; k < tile.size(); k++) {
				
				Color tileColor = new Color(tile.get(k));
				int tileR = tileColor.getRed();
				int tileG = tileColor.getGreen();
				int tileB = tileColor.getBlue();
				
				hsvTile = Color.RGBtoHSB(tileR, tileG, tileB, null);
				hsvRegion = Color.RGBtoHSB(regionR, regionG, regionB, null);
				
				float diffH = Math.abs(hsvRegion[0] - hsvTile[0]);
				
				if (diffH < record) {
					record = diffH;
					select = k;
				}

			}
					
				for (int u = b; u < b + tileW; u++ ) {
					for(int v = a; v < a + tileH; v++) {
							
							if(select == 0) {
								for (int i = 0; i < tileW; i++ ) {
									for(int j = 0; j < tileH; j++) {
										Color tile1RGB = new Color(tile1.getRGB(i,j));
										int tile1R = tile1RGB.getRed();
										int tile1G = tile1RGB.getGreen();
										int tile1B = tile1RGB.getBlue();

										img.setRGB(i+b,j+a,new Color(tile1R,tile1G,tile1B).getRGB());
										}
									}
								System.out.println("Select tile 1 // Tile Number: "+w);
								}
								
								else if(select == 1) {
									for (int i = 0; i < tileW; i++ ) {
										for(int j = 0; j < tileH; j++) {
											Color tile2RGB = new Color(tile2.getRGB(i,j));
											int tile2R = tile2RGB.getRed();
											int tile2G = tile2RGB.getGreen();
											int tile2B = tile2RGB.getBlue();
											
											img.setRGB(i+b,j+a,new Color(tile2R,tile2G,tile2B).getRGB());

										}
									}
									System.out.println("Select tile 2 // Tile Number: "+w);
									
								}
								
								else if(select == 2) {
									for (int i = 0; i < tileW; i++ ) {
										for(int j = 0; j < tileH; j++) {
											Color tile3RGB = new Color(tile3.getRGB(i,j));
											int tile3R = tile3RGB.getRed();
											int tile3G = tile3RGB.getGreen();
											int tile3B = tile3RGB.getBlue();
		
											img.setRGB(i+b,j+a,new Color(tile3R,tile3G,tile3B).getRGB());
											
										}
									}
									System.out.println("Select tile 3 // Tile Number: "+w);
								}
								
								else if(select == 3) {
									for (int i = 0; i < tileW; i++ ) {
										for(int j = 0; j < tileH; j++) {
											Color tile4RGB = new Color(tile4.getRGB(i,j));
											int tile4R = tile4RGB.getRed();
											int tile4G = tile4RGB.getGreen();
											int tile4B = tile4RGB.getBlue();
											
											img.setRGB(i+b,j+a,new Color(tile4R,tile4G,tile4B).getRGB());
									
										}
									}
									System.out.println("Select tile 4 // Tile Number: "+w);
								}
							
								else if(select == 4) {
                                  for (int i = 0; i < tileW; i++ ) {
                                      for(int j = 0; j < tileH; j++) {
                                          Color tile5RGB = new Color(tile5.getRGB(i,j));
                                          int tile5R = tile5RGB.getRed();
                                          int tile5G = tile5RGB.getGreen();
                                          int tile5B = tile5RGB.getBlue();

                                          img.setRGB(i+b,j+a,new Color(tile5R,tile5G,tile5B).getRGB());

                                      }
                                  }
                                  System.out.println("Select tile 5 // Tile Number: "+w);
                              }
							
								else if(select == 5) {
                                  for (int i = 0; i < tileW; i++ ) {
                                      for(int j = 0; j < tileH; j++) {
                                    	  Color tile6RGB = new Color(tile6.getRGB(i,j));
                                          int tile6R = tile6RGB.getRed();
                                          int tile6G = tile6RGB.getGreen();
                                          int tile6B = tile6RGB.getBlue();

                                          img.setRGB(i+b,j+a,new Color(tile6R,tile6G,tile6B).getRGB());

                                      }
                                  }
                                  System.out.println("Select tile 6 // Tile Number: "+w);
                              }
							
								else if(select == 6) {
                                  for (int i = 0; i < tileW; i++ ) {
                                      for(int j = 0; j < tileH; j++) {
                                          Color tile7RGB = new Color(tile8.getRGB(i,j));
                                          int tile7R = tile7RGB.getRed();
                                          int tile7G = tile7RGB.getGreen();
                                          int tile7B = tile7RGB.getBlue();

                                          img.setRGB(i+b,j+a,new Color(tile7R,tile7G,tile7B).getRGB());

                                      }
                                  }
                                  System.out.println("Select tile 7 // Tile Number: "+w);
                              }
							
								else if(select == 7) {
                                  for (int i = 0; i < tileW; i++ ) {
                                      for(int j = 0; j < tileH; j++) {
                                          Color tile8RGB = new Color(tile7.getRGB(i,j));
                                          int tile8R = tile8RGB.getRed();
                                          int tile8G = tile8RGB.getGreen();
                                          int tile8B = tile8RGB.getBlue();

                                          img.setRGB(i+b,j+a,new Color(tile8R,tile8G,tile8B).getRGB());

                                      }
                                  }
                                  System.out.println("Select tile 8 // Tile Number: "+w);
                              }
						}
					}

			System.out.println("END OF REGION: "+w+" // b value: "+b);
			
			if(a <= (width-tileW)) {
				a+= tileW;
			}
			
			if (a>= width) {
				b += tileH;
				a = 0;
			}
		}
		
		return img;

	}
	
//	public BufferedImage tiler(BufferedImage imported) {
//		
//		WritableRaster wRaster = imported.copyData(null);
//		BufferedImage img = new BufferedImage(imported.getColorModel(), wRaster, imported.isAlphaPremultiplied(), null);
//	
//		for (int i = 0; i < width; i += tileW ) {
//			for (int j = 0; j <  height; j += tileH) {
//				
//				int r = 0;
//				int g = 0;
//				int b = 0;
//
//				int avgR = 0;
//				int avgG = 0;
//				int avgB = 0;
//				
//				int num = 0;
//				
//				Color averageColor;
//				
//				
//				for (int u = i; u < i + tileW; u++ ) {
//					for(int v = j; v < j + tileH; v++) {
////						System.out.println("I:" + i);
////						
////						System.out.println("U:" + u);
////						
////						System.out.println("J:"+ j);
////						
////						System.out.println("V:"+ v);
//
//						Color tRGB = new Color(imported.getRGB(u, v)); // get rgb values of each pixel
//
//						// get separated rgb values of each pixel
//						r += tRGB.getRed();
//						g += tRGB.getGreen();
//						b += tRGB.getBlue();
//					
//					}
//				}
//
//				num = tileW*tileH;
//				
//				avgR = (int) (r / num);
//				avgG = (int) (g / num);
//				avgB = (int) (b / num);
//
//				System.out.println("R: " + avgR + "G: " + avgG + "B: " + avgB);
//
//				if (avgR > 255)
//					avgR = 255;
//				if (avgG > 255)
//					avgG = 255;
//				if (avgB > 255)
//					avgB = 255;
//
//				if (avgR < 0)
//					avgR = 0;
//				if (avgG < 0)
//					avgG = 0;
//				if (avgB < 0)
//					avgB = 0;
//				
//				System.out.println("R: " + avgR + " G:" + avgG + " B:" + avgB);
//
//				averageColor = new Color(avgR, avgG, avgB);
//				System.out.println("average: " + averageColor);
//
//
//				for (int u = i; u < i + tileW; u++ ) {
//					for(int v = j; v < j + tileH; v++) {
//						img.setRGB(u,v, new Color(avgR, avgG, avgB).getRGB());
//					}
//				}
//			}
//		}
//		
//		return img;
//	}
	
	public void draw(Graphics g) {
		// draw all the images and texts
		int w = width;
		int h = height;

//		this.setSize(width * 3, (int) (height * 1.5));
		
		g.drawImage(tiledImage, 125, 100, w, h, this);

	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
