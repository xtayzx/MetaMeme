import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	
	private static final long serialVersionUID = -6746983370236321708L;
	public JButton mosaic,reset,custom;
	public JPanel mainPanel;


	public ButtonPanel() {
		setComponent();
		setLayout(new FlowLayout(36, 12, FlowLayout.LEFT));
		add(mainPanel);
	}

	private void setComponent() {
		mosaic = new JButton("Generate Test Mosaic");
		reset = new JButton("Reset Image");
		custom = new JButton("Upload Custom Image");
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createTitledBorder("Main Menu"));
		mainPanel.setLayout(new FlowLayout(6,6,FlowLayout.LEFT));
		
		mainPanel.add(mosaic);
		mainPanel.add(custom);
		mainPanel.add(reset);
	}
	
	public void addActionListener(MainPanel ep) {
		mosaic.addActionListener(ep);
		reset.addActionListener(ep);
		custom.addActionListener(ep);
	}

}

