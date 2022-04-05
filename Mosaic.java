
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import image.ImageTiles;
import image.ImportedImage;

/**
* IAT 455 - Final Project (Meta Meme)
* Spring 2022
* Amena Salman (301363453)
* Taylen Lee-Chin (301371610)
**/

public class Mosaic extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private final JFileChooser openFileChooser;
	private BufferedImage originalBI;
	
	private JButton openButton = new JButton("Open file");
	private JPanel openPanel;
	
	public Boolean open = false;
	
	public String fileUpload;
	
	public ImportedImage test;
	
//	public ImageTiles image = new ImageTiles();
	
	public Mosaic(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		MainPanel mPanel = new MainPanel();
		ButtonPanel bPanel = new ButtonPanel(mPanel);
		mPanel.addActionListener(bPanel);
		
		setLayout(new BorderLayout());
		add(bPanel, BorderLayout.CENTER);
		add(mPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
		
		openPanel = new JPanel();
		openPanel.setBorder(BorderFactory.createTitledBorder("Meta Meme Menu"));
		openPanel.setLayout(new FlowLayout(6,6,FlowLayout.LEFT));
		openPanel.add(openButton);
		add(openPanel, BorderLayout.SOUTH);
		
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File("c:\\temp"));
		openFileChooser.setFileFilter(new FileNameExtensionFilter("JPEG image", "jpeg", "jpg"));
		
		openButton.addActionListener(e -> {
            selectFile();
        });
	}

	public static void main(String[] args) {
		new Mosaic("IAT 455 - Rocket Power");
	}
	
	public void selectFile() {
		
		int returnValue = openFileChooser.showOpenDialog(this);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			try {
				originalBI = ImageIO.read(openFileChooser.getSelectedFile());
				fileUpload = "Image file successfully loaded";
				test = new ImportedImage(originalBI);
				test.draw(getGraphics());
				
				
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

	