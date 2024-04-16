package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
    protected float x,y;
    protected int width,height;
    protected Rectangle hitBox;
    public Entity(float x, float y,int width,int height) {
    	this.x=x;
    	this.y=y;
    	this.height=height;
    	this.width=width;
    	initHitbox();
    }
    protected void drawHitbox(Graphics g) {
    	g.setColor(Color.pink);
    	//g.drawRect(hitBox.x,hitBox.y,hitBox.width,hitBox.height);
    }
	protected  void initHitbox() {
		hitBox=new Rectangle((int)x,(int)y,width,height);
	}
	protected void updateHitbox() {
		hitBox.x=(int)x;
		hitBox.y=(int)y;
	}
	public Rectangle getHitbox() {
		return hitBox;
	}
    
    
}
