import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GameFrame extends JFrame {
	public GameFrame() {
		setTitle("Game Frame");
		setSize(800,800); //default size is 0,0
		//setLocation(10,200);	//default is 0,0 which is top left corner
		
		//adds window listener
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			} //Window closing
		} );

		
		setLayout(null);
		ImageIcon ship = new ImageIcon("/Users/AnikaCzander/Desktop/rocketship14.png");
		JLabel imageLabel = new JLabel(ship);
		imageLabel.setLocation(20, 20);
		imageLabel.setSize(400,400);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setVerticalAlignment(SwingConstants.CENTER);
		imageLabel.setVisible(true);
		add(imageLabel);
		
		ImageIcon planet = new ImageIcon("/Users/AnikaCzander/Desktop/planet.png");
		JLabel imageLabel2 = new JLabel(planet);
		imageLabel2.setLocation(10, 10);
		imageLabel2.setSize(400,400);
		imageLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel2.setVerticalAlignment(SwingConstants.CENTER);
		imageLabel2.setVisible(true);
		add(imageLabel2);
		
		
	}
	
	public static void main(String[] args) throws IOException
	{
		//Frame frame = new GameFrame();
		//frame.setVisible(true);
		SpaceEmergency space = new SpaceEmergency();
	}
}
