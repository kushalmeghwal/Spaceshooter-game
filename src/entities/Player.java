package entities;


import static utilz.Constants.PlayerConstants.IDLE;

import static utilz.Constants.PlayerConstants.RUNNING;
import static utilz.Constants.PlayerConstants.getSpriteAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import utilz.LoadSave;

public class Player extends Entity {
	private BufferedImage img,subImg,smoke,subSmoke,border,subBor,backG,subBack;
	private int PlayerAction=IDLE;
	private boolean up,down,right,left;
	private boolean moving=false;
	private BufferedImage[][] animation;
	private int aniTick,aniIndex,aniSpeed=10;
	private float playerSpeed = 2.0f;
	private int[][] lvlData;
	
	
	public Player(float x, float y,int width,int height) {
		super(x,y, height, height);
		loadAnimation();
	}
	
	public void update() {
		updatePos();
		updateHitbox();
		updateAnimationTick();
		setAnimation();
	    
	}
	
	public void render(Graphics g) {

	   subImg = img.getSubimage(455, 250, 195, 134);
	   //subBack=backG.getSubimage(0, 0, 4000, 6000);
	    //subSmoke=smoke.getSubimage(0, 0, 60, 60);
	   //subBor = border.getSubimage(0, 0, 430, 530);
	   g.drawImage(backG,0,0,630,1000, null);
	   g.drawImage(border,-130,-55,850,935, null);
	   g.drawImage(subImg,(int)x,(int)y,95, 70, null);
	   
		g.drawImage(animation[PlayerAction][aniIndex], (int)x+29, (int)y+66, 45,60,null);
		//drawHitbox(g);
		//g.drawImage(subBor,-206,-130,950, 1005, null);
		
	}
//	
    public void setMoving(boolean moving ) {
    	this.moving=moving;
    }
	

	private void updateAnimationTick() {
		// TODO Auto-generated method stub
	aniTick++;
	if(aniTick>=aniSpeed) {
		aniTick=0;
		aniIndex++;
		if(aniIndex>=getSpriteAmount(PlayerAction))  //
			aniIndex =0;
		}
	}
	private void setAnimation() {
	
		PlayerAction=RUNNING;
	
			  
		}
		
	
	private void updatePos() {
		moving=false;
		if(!left && !right && !up && !down)
			return;
		
		//float xSpeed=0,ySpeed=0;
		
	if(left && !right) {
		x-=playerSpeed;
	     moving=true;
	}
	else if(right && !left) { 
		x+=playerSpeed;
		moving=true;
	}
	if(up && !down) {
		y-=playerSpeed;
		moving=true;
	}
	else if(down && !up) {
		y+=playerSpeed;
        moving=true;
	}
	
//	if(canMoveHere(x+xSpeed,y+ySpeed,width,height,lvlData)) {
//		this.x+=xSpeed;
//		this.y+=ySpeed;
//		moving=true;
//	}
	if(x<50)
		x=50;
	else if (x>460)
		x=460;
	if(y<400)
		y=400;
	else if (y>650)
		y =650;
		
	}

		
	
	public Boolean getUp() {
		return up;
	}

	public void setUp(Boolean up) {
		this.up = up;
	}

	public Boolean getDown() {
		return down;
	}

	public void setDown(Boolean down) {
		this.down = down;
	}

	public Boolean getRight() {
		return right;
	}

	public void setRight(Boolean right) {
		this.right = right;
	}

	public Boolean getLeft() {
		return left;
	}

	public void setLeft(Boolean left) {
		this.left = left;
	}

	private void loadAnimation() {
		 
		InputStream bk=getClass().getResourceAsStream("/background.jpg");
		InputStream bo=getClass().getResourceAsStream("/border4.png");
		InputStream is=getClass().getResourceAsStream("/spaceRocket.png");
		try {
			 border=ImageIO.read(bo);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	
		
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
		try {
			 backG=ImageIO.read(bk);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	
	
	 
		smoke=LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLUS);
		//backG=LoadSave.GetSpriteAtlus(LoadSave.BACKG_ATLUS);
			animation = new BufferedImage[2][3];
			for(int i=0;i<animation.length;i++) {
				for(int j=0;j<animation[i].length;j++) {
					animation[i][j]= smoke.getSubimage(j*190, i*200, 190, 200);
				}
			}
	}
	
	public void loadLvlData(int[][] lvlData) {
		this.lvlData=lvlData;
	}
	public void resetDirBooleans() {
		left=false;
		right=false;
		up=false;
		down=false;
	}
		
		
}
