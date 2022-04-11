import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import image.BaseImage;
import image.ImageTemp;
import image.ImportedImageTiles;

public class MainPanel extends JPanel implements ActionListener{

		private static final long serialVersionUID = 8885065922598051928L;
		public static final int width = 760;
		public static final int height = 685;
		public String choice = "Welcome to Meta Meme! Select a menu option to begin.";
		private ButtonPanel mPanel;
		private ImageTemp img;
		private int tilePrevW, tilePrevH, pos1, pos2;
		
		private final JFileChooser openFileChooser;
		private BufferedImage originalBI, test, tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, tile10, tile11, tile12;
		public String fileUpload;
		
		public MainPanel(ButtonPanel m) {
			mPanel = m;
			setPreferredSize(new Dimension(width, height));
			img = new BaseImage();
			
			openFileChooser = new JFileChooser();
			openFileChooser.setCurrentDirectory(new File("c:\\temp"));
			openFileChooser.setFileFilter(new FileNameExtensionFilter("JPEG image", "jpeg", "jpg"));
			
			try {
				test = ImageIO.read(new File("handsome.jpg"));
				tile1 = ImageIO.read(new File("200tile1.jpg"));
				tile2 = ImageIO.read(new File("200tile2.jpg"));
				tile3 = ImageIO.read(new File("200tile3.jpg"));
				tile4 = ImageIO.read(new File("200tile4.jpg"));
				tile5 = ImageIO.read(new File("200tile5.jpg"));
				tile6 = ImageIO.read(new File("200tile6.jpg"));
				tile7 = ImageIO.read(new File("200tile7.jpg"));
				tile8 = ImageIO.read(new File("200tile8.jpg"));
				tile9 = ImageIO.read(new File("200tile9.jpg"));
				tile10 = ImageIO.read(new File("200tile10.jpg"));
				tile11 = ImageIO.read(new File("200tile11.jpg"));
				tile12 = ImageIO.read(new File("200tile12.jpg"));	
			}
			
			catch (Exception e) {
				System.out.println("Cannot load the provided image");
			}
			
			tilePrevW = 100;
			tilePrevH = 100;
			pos1 = 535;
			pos2 = 645;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.LIGHT_GRAY);
		}

		//action when a button is clicked
		@Override
		public void actionPerformed(ActionEvent event) {
			switch (event.getActionCommand()) {
			case "Generate Test Mosaic":
				choice = "You have generated a Handsome Squidward!";
				img = new ImportedImageTiles(test);
				mPanel.mosaic.setEnabled(false);
				mPanel.custom.setEnabled(false);
				break;
			case "Reset Image":
				choice = "Canvas reset!";
				img = new BaseImage();
				mPanel.mosaic.setEnabled(true);
				mPanel.custom.setEnabled(true);
				break;
			case "Upload Custom Image":
				choice = "You have generated a custom mosaic!";
				selectFile();
				mPanel.mosaic.setEnabled(false);
				mPanel.custom.setEnabled(false);
				break;
			}
			repaint();
		}

		public void paint(Graphics g) {
			int diff = 80;
			
			Color background = new Color(0,57,56);
			g.setColor(background);
			g.fillRect(0,0,width,height);
			
			g.setColor(Color.WHITE);
			g.fillRect(20,535,500,75);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(20,20,500,500);
			
			g.setColor(Color.WHITE);
		    Font f1 = new Font("Comic Sans MS", Font.PLAIN, 42);  
		    g.setFont(f1); 
			g.drawString("Meta Meme", width/2-230, height/2-80);

		    Font f2 = new Font("Calibri", Font.PLAIN, 16);  
		    g.setFont(f2);

			g.drawString("IAT 455: Computational Media", 20, height/2+300);
			g.drawString("Created by: Amena Salman and Taylen Lee-Chin", 20,height/2+320);
			
		    g.setColor(Color.BLACK);
			Font f3 = new Font("Comic Sans MS", Font.PLAIN, 18);  
		    g.setFont(f3);
		    g.drawString(choice, width/2-340, height/2+235);
		    
		    g.drawImage(tile1, pos1, 100-diff, tilePrevW, tilePrevH, this);
		    g.drawImage(tile2, pos2, 100-diff, tilePrevW, tilePrevH, this);
		    
		    g.drawImage(tile3, pos1, 210-diff, tilePrevW, tilePrevH, this);
		    g.drawImage(tile4, pos2, 210-diff, tilePrevW, tilePrevH, this);
		    
		    g.drawImage(tile5, pos1, 320-diff, tilePrevW, tilePrevH, this);
		    g.drawImage(tile6, pos2, 320-diff, tilePrevW, tilePrevH, this);
		    
		    g.drawImage(tile7, pos1, 430-diff, tilePrevW, tilePrevH, this);
		    g.drawImage(tile8, pos2, 430-diff, tilePrevW, tilePrevH, this);
		    
		    g.drawImage(tile9, pos1, 540-diff, tilePrevW, tilePrevH, this);
		    g.drawImage(tile10, pos2, 540-diff, tilePrevW, tilePrevH, this);
		    
		    g.drawImage(tile11, pos1, 650-diff, tilePrevW, tilePrevH, this);
		    g.drawImage(tile12, pos2, 650-diff, tilePrevW, tilePrevH, this);
		   
			img.draw(g);
		}
		
		public void selectFile() {
			int returnValue = openFileChooser.showOpenDialog(this);
			
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				try {
					originalBI = ImageIO.read(openFileChooser.getSelectedFile());
					fileUpload = "Image file successfully loaded";
					img = new ImportedImageTiles(originalBI);
					img.draw(getGraphics());
					
				} catch (IOException ioe) {
					fileUpload = "Fail to upload image file";
				}
			}
			
			else {
					fileUpload = "No file chosen";
				}
				System.out.println(fileUpload);
			}
		
}

