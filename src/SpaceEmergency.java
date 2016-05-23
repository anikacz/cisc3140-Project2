import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SpaceEmergency extends GameFrame {

    private static Scanner scanner;
    public GameFrame frame = new GameFrame();
    
	public SpaceEmergency() throws  IOException {

        scanner = new Scanner(new File("/Users/AnikaCzander/Documents/workspace/Project2/src/AB-small-practice.in"));
       // PrintStream out = new PrintStream(new File("space.out"));
        int testcases = scanner.nextInt();

        // we multiply distances and speed with two so we don't have floats
        // this means regular speed is 1, boosted speed is 2
        
        //JFrame frame = new GameFrame();
        String labelText = "<html>";
       // JPanel panel = new JPanel();

        for (int casenr = 1; casenr <= testcases; casenr++) {

            Integer time = 0;
            //Integer position = 0;
            Integer boosters = scanner.nextInt();       // L
            long buildTime = scanner.nextLong();      // t
            Integer finalStar = scanner.nextInt();      // N
            Integer stars = scanner.nextInt();          // C
            List<Integer> distances = new ArrayList<Integer>();
            for (int i = 0; i < stars; i++) {
                distances.add(scanner.nextInt() * 2);
            }

            // lay out the track we'll travel
            List<Integer> track = new ArrayList<Integer>();
            for (int i = 0; i < finalStar; i++) {
                track.add(distances.get(i % distances.size()));
            }


            // let the ship fly till the boosters are ready
            while (track.size()>0 && track.get(0) <= buildTime) {
                time += track.get(0);
                buildTime -= track.get(0);
                track.remove(0);

            }
            // check if we're between two planets when the boosters are ready
            if (track.size() > 0 && buildTime > 0) {
                time += (int) buildTime;
                track.set(0, track.get(0) - (int)buildTime);
            }

            // reorder by distance use boosters on longest distance until we're out of boosters
            Collections.sort(track);
            Collections.reverse(track);

            while (track.size() > 0) {
                if (boosters > 0) {
                    time += track.get(0) / 2;
                    track.remove(0);
                    boosters--;
                } else {
                    time += track.get(0);
                    track.remove(0);
                }
            }
          //System.out.printf("Case #%d: %s\n", casenr, time);
            //String str = ("Case #%d: %s\n"+casenr+time);
            //out.printf("Case #%d: %s\n", casenr, time);
            if((casenr%5) == 0)
            {
            	labelText += "Case # "+casenr+ " : "+time+"<br>";	
            }
            else
            	labelText += "Case # "+casenr+ " : "+time+"\t\t\t";
         
        }
        labelText += "</html>";
       
       /* JLabel myText = new JLabel(labelText);
        myText.setFont(new Font("Verdana",0,12));
       // panel.add(myText);
        myText.setLocation(100,100);
        myText.setSize(800,800);
        myText.setHorizontalAlignment(SwingConstants.LEFT);
		myText.setVerticalAlignment(SwingConstants.CENTER);
        myText.setVisible(true);
        frame.add(myText);*/
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.moveImg();
        DisplayCases(labelText);
        
    }
	
	public void DisplayCases(String info)
	{
		 JLabel myText = new JLabel(info);
	     myText.setFont(new Font(Font.MONOSPACED,0,12));
	     myText.setLocation(100,100);
	     myText.setSize(800,800);
	     myText.setHorizontalAlignment(SwingConstants.LEFT);
	     myText.setVerticalAlignment(SwingConstants.CENTER);
	     
	     frame.add(myText);
	     myText.setVisible(true);
	     frame.setVisible(true);
	     frame.repaint();
		
	}
	

}