package game.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateManager implements KeyListener{//gerenciamento dos estados do jogo
	public static final int NUMBER_STATES = 2;
	public static State[] states = new State[NUMBER_STATES];
	public static int currentState = 0;
	
	public static void setState(int state) {
		currentState = state;
		states[currentState].init();
	}
	
	public StateManager() {
		states[0] = new FPSState();
	}
	
	public void update() {
		states[currentState].update();//atualizar o estado da fase corrente
		
	}
	public void render(Graphics g) {
		states[currentState].render(g);//renderizar o estado atual
	}
	public static State getState() {
		return states[currentState];
	}
	
	
	//aplicando o controle 
	
	@Override
	public void keyPressed(KeyEvent e) {
		states[currentState].KeyReleased(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		states[currentState].KeyReleased(e.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

		
	}
	
	
}
