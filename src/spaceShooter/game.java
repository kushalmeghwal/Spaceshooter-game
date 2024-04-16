package spaceShooter;

import java.awt.Graphics;

import entities.Player;
import levels.LevelManager;

public class game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamepanel;
	private Thread gameThread;
	private final int FPS_SET=120;
	private final int UPS_SET=200;
	private Player player;
	private LevelManager levelManager;
	
	public static final int TILES_DEFAULT_SIZE=15;
	public static final float SCALE=3.0f;
	public static final int TILES_IN_WIDTH=14;
	public static final int TILES_IN_HEIGHT=26;
	public static final int TILES_SIZE=(int)(TILES_DEFAULT_SIZE*SCALE);
	public static final int GAME_WIDTH=TILES_SIZE*TILES_IN_WIDTH;
	public static final int GAME_HEIGHT=TILES_SIZE*TILES_IN_HEIGHT;
	
	
	
	
	public game() {
		initClasses();
		gamepanel=new GamePanel(this);
		gameWindow=new GameWindow(gamepanel);
		gamepanel.requestFocus();
		
		
		
		startGameLoop();
	
		
	}
	private void initClasses() {
		levelManager=new LevelManager(this);
		player=new Player(254,630,(int)(64*SCALE),(int)(40*SCALE));
		//player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		
	}
	private void startGameLoop() {
		gameThread=new Thread(this);
		gameThread.start();
	}
	public void run() {
		double timePerFrame=1000000000.0/FPS_SET;
		double timePerUpdate=1000000000.0/UPS_SET;
	
		long previousTime=System.nanoTime();
		int frames=0;
		int Updates=0;
		long lastcheck=System.currentTimeMillis();
		double deltaU=0;
		double deltaF=0;
		while(true) {
			
			long currentTime=System.nanoTime();
			
			deltaU+=(currentTime-previousTime)/timePerUpdate;
			deltaF+=(currentTime-previousTime)/timePerFrame;
			previousTime=currentTime;
			if(deltaU>=1) {
				update();
				Updates++;
				deltaU--;
			}
			
			
			if(deltaF>=1) {
				gamepanel.repaint();
				
				frames++;
				deltaF--;
			}
			
			if(System.currentTimeMillis()-lastcheck>=1000) {
				lastcheck=System.currentTimeMillis();
				System.out.println("FPS:"+frames+"  |  UPS:"+Updates);
				frames=0;
				Updates=0;
			}
		}
	}
	public void windowFocusLost() {
	player.resetDirBooleans();
	}
	private void update() {
	player.update();
	levelManager.update();
		
	}
	public void render(Graphics g) {
		levelManager.draw(g);
		player.render(g);
	}
	public Player getPlayer() {
		return player;
	}
}
