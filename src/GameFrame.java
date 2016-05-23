import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GameFrame extends JFrame {
	
	public JLabel imageLabel;
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
		imageLabel = new JLabel(ship);
		imageLabel.setLocation(20, 20);
		imageLabel.setSize(400,400);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setVerticalAlignment(SwingConstants.CENTER);
		imageLabel.setVisible(true);
		add(imageLabel);
		
		ImageIcon planet = new ImageIcon("/Users/AnikaCzander/Desktop/planet.png");
		JLabel imageLabel2 = new JLabel(planet);
		imageLabel2.setLocation(500, 10);
		imageLabel2.setSize(400,400);
		imageLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel2.setVerticalAlignment(SwingConstants.CENTER);
		imageLabel2.setVisible(true);
		add(imageLabel2);
		
		ImageIcon planet2 = new ImageIcon("/Users/AnikaCzander/Desktop/planet.png");
		JLabel imageLabel3 = new JLabel(planet2);
		imageLabel3.setLocation(7, 10);
		imageLabel3.setSize(400,400);
		imageLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel3.setVerticalAlignment(SwingConstants.CENTER);
		imageLabel3.setVisible(true);
		add(imageLabel3);
		

		/*for(int i = 0; i <= 500; i++)
		{
			imageLabel.setLocation(20+i,20);
			this.repaint();
		}
		
		return;*/
	}
	
	
	public static void main(String[] args) throws IOException
	{
		//GameFrame frame = new GameFrame();
		//frame.setVisible(true);
		SpaceEmergency space = new SpaceEmergency();
	}
	
	public void moveImg()
	{
		for(int i = 0; i <= 500; i++)
		{
			this.imageLabel.setLocation(20+i,20);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
		}
		JLabel myText = new JLabel("Simulation Complete!");
        myText.setFont(new Font(Font.MONOSPACED,0,12));
        myText.setLocation(25,100);
        myText.setSize(800,800);
        myText.setHorizontalAlignment(SwingConstants.LEFT);
		myText.setVerticalAlignment(SwingConstants.TOP);
        myText.setVisible(true);
        this.add(myText);
        this.repaint();
		
	}
}
