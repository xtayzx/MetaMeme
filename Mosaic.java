
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import image.ImportedImageTiles;

/**
* IAT 455 - Final Project (Meta Meme)
* Spring 2022
* Amena Salman (301363453)
* Taylen Lee-Chin (301371610)
**/

public class Mosaic extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public ImportedImageTiles mosaicTest;
	private final JFileChooser openFileChooser;
	private BufferedImage originalBI;

	public Boolean open = false;
	public String fileUpload;
	
	public Mosaic(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		ButtonPanel bPanel = new ButtonPanel();
		MainPanel mPanel = new MainPanel(bPanel);
		bPanel.addActionListener(mPanel);
		
		setLayout(new BorderLayout());
		add(bPanel, BorderLayout.SOUTH); //button panel
		add(mPanel, BorderLayout.CENTER); //main panel
		pack();
		setVisible(true);
		
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File("c:\\temp"));
		openFileChooser.setFileFilter(new FileNameExtensionFilter("JPEG image", "jpeg", "jpg"));

	}

	public static void main(String[] args) {
		new Mosaic("IAT 455 - Meta Meme");
	}

	public void selectFile() {
		
		int returnValue = openFileChooser.showOpenDialog(this);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			try {
				originalBI = ImageIO.read(openFileChooser.getSelectedFile());
				fileUpload = "Image file successfully loaded";
				mosaicTest = new ImportedImageTiles(originalBI);
				mosaicTest.draw(getGraphics());
				
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
	