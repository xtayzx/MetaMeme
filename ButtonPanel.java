import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import image.BaseImage;
import image.Image1;
import image.ImageTemp;
import image.ImageTiles;
import image.Image2;

public class ButtonPanel extends JPanel implements ActionListener {

		private static final long serialVersionUID = 8885065922598051928L;
		public static final int width = 750;
		public static final int height = 700;
		public String choice = "No button pressed";
		private MainPanel mPanel;
		private ImageTemp img;
		
		public ButtonPanel(MainPanel m) {
			mPanel = m;
			setPreferredSize(new Dimension(width, height));
			img = new BaseImage();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.LIGHT_GRAY);
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			switch (event.getActionCommand()) {
			case "Image 1":
				choice = "Image 1 selected";
				img = new Image1();
				mPanel.image2.setEnabled(false);
				mPanel.image3.setEnabled(false);
				mPanel.image4.setEnabled(false);
				break;
			case "Image 2":
				choice = "Image 2 selected";
				img = new Image2();
				mPanel.image1.setEnabled(false);
				mPanel.image3.setEnabled(false);
				mPanel.image4.setEnabled(false);
				break;
			case "Image 3":
				choice = "Image 3 selected";
				//TODO:
				//no method yet
				img = new ImageTiles();
				mPanel.image1.setEnabled(false);
				mPanel.image2.setEnabled(false);
				mPanel.image4.setEnabled(false);
				break;
			case "Image 4":
				choice = "Image 4 selected - but nothing happens rn tho lmao";
				//TODO:
				//no method yet
				mPanel.image1.setEnabled(false);
				mPanel.image2.setEnabled(false);
				mPanel.image3.setEnabled(false);
				break;		
			case "Upload Your Image":
				choice = "Upload selected";
				//TODO:
				//no method yet
				mPanel.image1.setEnabled(false);
				mPanel.image2.setEnabled(false);
				mPanel.image3.setEnabled(false);
				mPanel.image4.setEnabled(false);
				break;
			case "Reset Image":
				choice = "Reset selected - but nothing happens rn tho lmao";
				img = new BaseImage();
				mPanel.image1.setEnabled(true);
				mPanel.image2.setEnabled(true);
				mPanel.image3.setEnabled(true);
				mPanel.image4.setEnabled(true);
				break;
			}
			repaint();
		}

		public void paint(Graphics g) {
			g.drawString(choice, width/2-250, height/2+280); //log for what button is pressed
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(125,100,500,500);
			
			g.setColor(Color.WHITE);
		    Font f1 = new Font("Comic Sans MS", Font.PLAIN, 42);  
		    g.setFont(f1); 
			g.drawString("Meta Meme", width/2-125, height/2);
			
			img.draw(g);
		}
}

