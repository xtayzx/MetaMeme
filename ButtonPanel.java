import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	
	private static final long serialVersionUID = -6746983370236321708L;
//	private JPanel imagePanel;
//	public JButton image1;
//	public JButton image2;
	public JButton mosaic,reset,custom;
//	public JButton image4;
	
	public JPanel mainPanel;
//	private JButton upload;

	public ButtonPanel() {
		setComponent();
		setLayout(new FlowLayout(36, 12, FlowLayout.LEFT));
//		add(imagePanel);
		add(mainPanel);
	}

	private void setComponent() {
//		image1 = new JButton("Image 1");
//		image2 = new JButton("Image 2");
		mosaic = new JButton("Generate Test Mosaic");
//		image4 = new JButton("Image 4");
//		imagePanel = new JPanel();
//		imagePanel.setBorder(BorderFactory.createTitledBorder("Image Selection"));
//		imagePanel.setLayout(new FlowLayout(6,6,FlowLayout.LEFT));
//		imagePanel.add(image1);
//		imagePanel.add(image2);
//		imagePanel.add(image3);
//		imagePanel.add(image4);
		
		reset = new JButton("Reset Image");
		custom = new JButton("Upload File");
//		upload = new JButton("Upload Your Image");
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createTitledBorder("Main Menu"));
		mainPanel.setLayout(new FlowLayout(6,6,FlowLayout.LEFT));
		
		mainPanel.add(mosaic);
		mainPanel.add(custom);
		mainPanel.add(reset);
	}
	
	public void addActionListener(MainPanel ep) {
//		image1.addActionListener(ep);
//		image2.addActionListener(ep);
//		image3.addActionListener(ep);
//		image4.addActionListener(ep);
		mosaic.addActionListener(ep);
		reset.addActionListener(ep);
		custom.addActionListener(ep);
	}

}

