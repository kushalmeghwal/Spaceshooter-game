package inputs;

import java.awt.event.KeyEvent;
import spaceShooter.game;
import spaceShooter.GamePanel;
import java.awt.event.KeyListener;
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;
import spaceShooter.GamePanel;
public class KeyBoardinputs implements KeyListener {

	 private GamePanel gamePanel;
	 
	 public KeyBoardinputs(GamePanel gamePanel) {
		 this.gamePanel=gamePanel;
	 }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
			   gamePanel.getGame().getPlayer().setUp(true);
			   break;
	    case KeyEvent.VK_A:
	    	   gamePanel.getGame().getPlayer().setLeft(true);
	    	   break;
        case KeyEvent.VK_S:
        	   gamePanel.getGame().getPlayer().setDown(true);
        	   break;
        case KeyEvent.VK_D:
            gamePanel.getGame().getPlayer().setRight(true);
	        break;
	}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
			   gamePanel.getGame().getPlayer().setUp(false);
			   break;
	    case KeyEvent.VK_A:
	    	   gamePanel.getGame().getPlayer().setLeft(false);
	    	   break;
        case KeyEvent.VK_S:
        	   gamePanel.getGame().getPlayer().setDown(false);
        	   break;
        case KeyEvent.VK_D:
            gamePanel.getGame().getPlayer().setRight(false);
	        break;
	}
	
	}
}
