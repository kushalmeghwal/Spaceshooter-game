package levels;
import java.awt.Graphics;
import static spaceShooter.game.*;
import java.awt.image.BufferedImage;

import spaceShooter.game;
import utilz.LoadSave;

public class LevelManager {

	private game game;
	private BufferedImage[] levelSprite;
	private BufferedImage level;
	private Level levelOne;
	
	public LevelManager(game game) {
		this.game=game;
		//levelSprite=LoadSave.GetSpriteAtlus(LoadSave.LEVEL_ATLUS);
		//levelSprite1=LoadSave.GetSpriteAtlus(LoadSave.BACKG_ATLUS);
		//level=LoadSave.GetSpriteAtlus(LoadSave.BACKG_ATLUS);
		//importOutsideSprite();
		
		importBorder();
		//levelOne=new Level(LoadSave.GetLevelData());
	}
	
//	private void importOutsideSprite() {
//		BufferedImage bord=LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLUS);
//		levelSprite=new BufferedImage[91];
//		for(int j=0;j<13;j++)
//			for(int i=0;i<7;i++) {
//				int index=j*7+i;
//				levelSprite[index]=bord.getSubimage(i*7, j*13, 7,13);
//			}
//		
//		
//	}

	private void importBorder() {
		
		
	}

	public void draw(Graphics g) {
//		for(int j=0;j<game.TILES_IN_HEIGHT;j++)
//			for(int i=0;i<game.TILES_IN_WIDTH;i++) {
//				int index=levelOne.getSpriteIndex(i, j);
//				g.drawImage(levelSprite[index],game.TILES_SIZE*i,game.TILES_SIZE*j,game.TILES_SIZE,game.TILES_SIZE,null);
//			}
	
	
	
	//	g.drawImage(level,GAME_WIDTH, GAME_HEIGHT, null);
	//g.drawImage(levelSprite[9],0,0,null);
	}
	public void update() {
		
	}
	
	public Level getCurrentLevel() {
		return levelOne;
	}
}
