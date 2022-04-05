import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	
	private static final long serialVersionUID = -6746983370236321708L;
	private JPanel imagePanel;
	public JButton image1;
	public JButton image2;
	public JButton image3;
	public JButton image4;
	
	private JPanel resetPanel;
	private JButton upload;
	private JButton reset;

	public ButtonPanel() {
		setComponent();
		setLayout(new FlowLayout(36, 12, FlowLayout.LEFT));
		add(imagePanel);
		add(resetPanel);
	}

	private void setComponent() {
		image1 = new JButton("Image 1");
		image2 = new JButton("Image 2");
		image3 = new JButton("Image 3");
		image4 = new JButton("Image 4");
		imagePanel = new JPanel();
		imagePanel.setBorder(BorderFactory.createTitledBorder("Image Selection"));
		imagePanel.setLayout(new FlowLayout(6,6,FlowLayout.LEFT));
		imagePanel.add(image1);
		imagePanel.add(image2);
		imagePanel.add(image3);
		imagePanel.add(image4);
		
		reset = new JButton("Reset Image");
		upload = new JButton("Upload Your Image");
		resetPanel = new JPanel();
		resetPanel.setBorder(BorderFactory.createTitledBorder("Main Menu"));
		resetPanel.setLayout(new FlowLayout(6,6,FlowLayout.LEFT));
		resetPanel.add(reset);
		resetPanel.add(upload);
	}
	
	public void addActionListener(MainPanel ep) {
		image1.addActionListener(ep);
		image2.addActionListener(ep);
		image3.addActionListener(ep);
		image4.addActionListener(ep);
		upload.addActionListener(ep);
		reset.addActionListener(ep);
	}

}

