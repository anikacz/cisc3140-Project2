import java.awt.*;
import java.util.Random;
import java.awt.image.*;

public class Game {
	private Random random;
	// declares a list of target objects
	private Ship ships; //the moving ship graphic
	private Planet homeplanet;	//where the ship starts
	private Planet destplanet;	//ships destination planet
	
	//images
	private BufferedImage shipImg;	//image for the ship
	private BufferedImage planetImg;	//image for the planet
	
	public Game()
	{
		Thread threadInitGame = new Thread() {
					@Override //Overrides the java thread class so threads won't just run, but will Initialize & load content
					public void run() {
						Initialize();	//initializes target objects
						LoadContent();	//loads content
						
					}
				};
		threadInitGame.start();
	}
	
	private void Initialize()
	{
		ships = new Ship(0, 0, 0, planetImg);
		homeplanet = new Planet();
		destplanet = new Planet();
	}
	
	private void LoadContent() //will load img content
	{
		java.net.URL shipImgUrl = this.getClass().getResource("/Ship.png");
		java.net.URL planetImgUrl = this.getClass().getResource("/Planet.png");
		
	}
	
}
