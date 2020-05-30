package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys = new boolean[256];//totas as teclas
	public static boolean w, s, up, down;
	
	
	public void update() {
		w = keys[KeyEvent.VK_W];//guarda a numeração das letras
		s = keys[KeyEvent.VK_S];
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		
	}
	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getKeyCode() < 0 || k.getKeyCode() > 255) {
			return;
		}
		keys[k.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		if(k.getKeyCode() < 0 || k.getKeyCode() > 255) {
			return;
		}
		keys[k.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent k) {
		
		
	}


}
