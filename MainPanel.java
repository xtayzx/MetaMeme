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
		public static final int width = 750;
		public static final int height = 700;
		public String choice = "Welcome to Meta Meme! Select an option to begin.";
		private ButtonPanel mPanel;
		private ImageTemp img;
		
		private final JFileChooser openFileChooser;
		private BufferedImage originalBI, test;
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
			}
			
			catch (Exception e) {
				System.out.println("Cannot load the provided image");
			}
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
			g.setColor(Color.WHITE);
			g.fillRect(0,0,width,height);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(125,100,500,500);
			
			g.setColor(Color.WHITE);
		    Font f1 = new Font("Comic Sans MS", Font.PLAIN, 42);  
		    g.setFont(f1); 
			g.drawString("Meta Meme", width/2-110, height/2);

		    Font f2 = new Font("Calibri", Font.PLAIN, 16);  
		    g.setFont(f2);
		    
		    g.setColor(Color.BLACK);
			g.drawString("IAT 455: Computational Media", 10, 25);
			g.drawString("Created by: Amena Salman and Taylen Lee-Chin", width-325, 25);
			
			Font f3 = new Font("Comic Sans MS", Font.PLAIN, 18);  
		    g.setFont(f3);
		    g.drawString(choice, width/2-250, height/2+300);
			
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

