package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game.Game;

public class MenuState implements State{
	
	private String[] options = { "START", "HELP", "EXIT" };
	private Font font1;
	private Font font2;
	private int choice = 0;
	private int x =0, y = 0, moveX = 1, moveY = 1;
	
	@Override
	public void init() {
		font1 = new Font("Dialog", Font.PLAIN, 48);
		font2 = new Font("Dialog", Font.PLAIN, 24);
		
	}

	@Override
	public void update() {
		x += moveX;
		y += moveY;
		
		limits();
		
	}
	private void limits() {//atribuindo os limites de movimentação da 'bola'
		if (x + 15 > Game.WIDTH) {//adicionando o tamanho 15(obj)
			moveX = -1; 
		}
		if (y + 15 > Game.HEIGHT) {
			moveY = -1;
		}
		if (x < 0) {
			moveX = 1;
		}
		if (y < 0) {
			moveY = 1;
		}
	}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		g.setColor(Color.WHITE);
		g.setFont(font1);
		//adicionando e centralizandro texto
		g.drawString("PONG", 
					Game.WIDTH / 2 - g.getFontMetrics().stringWidth("PONG") / 2,
					Game.HEIGHT * 1/4);
		
		g.setFont(font2);
		for (int i = 0; i< options.length; i++) {
			g.setColor(Color.WHITE);
			if(i == choice) {
				g.setColor(Color.YELLOW);
			}
			g.drawString(options[i],
					Game.WIDTH / 2 - g.getFontMetrics().stringWidth(options[i]) / 2,
					Game.HEIGHT * 3/4 + g.getFontMetrics(font2).getHeight() * i);
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 15, 15);
		
		
		
		
	}

	@Override
	public void KeyPressed(int cod) {
		
		
	}

	@Override
	public void KeyReleased(int cod) {//definindo teclas e interação com o menu
		if(cod == KeyEvent.VK_S) {
			choice--;
			if(choice < 0) {
				choice = options.length - 1;
			}
		}
		
		if(cod == KeyEvent.VK_W) {
			choice++;
			if(choice > options.length - 1) {
				choice = options.length - 1;
			}
		}
		if(cod == KeyEvent.VK_ENTER) {
			select();
			if(choice < 0) {
				choice = options.length - 1;
			}
		}
		
	}
	private void select() {
		switch(choice) {
		case 0:
			StateManager.setState(StateManager.LEVEL1);
			break;
		case 1:
			
			break;
		case 2:
			System.exit(0);
			break;
		default:
			break;
		}
		
	}	
}
