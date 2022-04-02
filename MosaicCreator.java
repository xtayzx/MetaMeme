
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
* IAT 455 - Final Project (Meta Meme)
* Spring 2022
* Amena Salman (301363453)
* Taylen Lee-Chin (301371610)
**/

public class MosaicCreator extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public MosaicCreator(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		MainPanel mPanel = new MainPanel();
		ButtonPanel bPanel = new ButtonPanel(mPanel);
		mPanel.addActionListener(bPanel);
		
		setLayout(new BorderLayout());
		add(bPanel, BorderLayout.CENTER);
		add(mPanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new MosaicCreator("IAT 455 - Rocket Power");
	}

}