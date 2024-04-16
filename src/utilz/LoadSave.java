package utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import spaceShooter.game;

public class LoadSave {
	
	public static final String PLAYER_ATLUS="smoke3.png";
	public static final String LEVEL_ATLUS="border5.png";
	public static final String LAYER="layer.png";
	public static final String BACKG_ATLUS="backG.jpg";
	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage imgs=null;
	
		InputStream it=LoadSave.class.getResourceAsStream("/"+fileName);
		try {
			 imgs = ImageIO.read(it);
			}
		 catch (IOException e1) {
		
			e1.printStackTrace();
		}finally {
			try {
				it.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	return imgs;
	}
	
//	public static int[][] GetLevelData(){
//		int[][] lvlData=new int[13][7];
//		BufferedImage img=GetSpriteAtlas(LAYER);
//		for(int j=0;j<img.getHeight();j++)
//			for(int i=0;i<img.getWidth();i++) {
//				Color color=new Color(img.getRGB(i, j));
//				int value=color.getRed();
//				if(value>=91) value=0;
//				lvlData[j][i]=	value;	
//	          }
//	return lvlData;
//	
//}
}