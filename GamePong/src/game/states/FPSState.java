package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game.Game;

public class FPSState implements State {
	
	private long now, lastTime = System.nanoTime();
	private double timer = 0;
	private int tick = 0;
	private int aux;
	
	@Override
	public void init() {
		
		
	}

	@Override
	public void update() {
		now = System.nanoTime()	;
		timer += now - lastTime;
		lastTime = now;
		tick++;
	}

	@Override
	public void render(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT );//utilizando os atributos statics para definir tamnho do desenho
		
		if(timer >= 1000000000) {
			aux = tick;
			tick = 0;
			timer = 0;
			
		}
		
		g.setColor(Color.WHITE);
		Font font = new Font("Serif", Font.PLAIN, 12);
		g.setFont(font);//aplicando fonte personalizada
		
		String text = "FPS: "+aux;//renderizando texto
		g.drawString(text, g.getFontMetrics().stringWidth(text), g.getFontMetrics().getHeight());
	}

	@Override
	public void KeyPressed(int cod) {
		System.out.println("Press "+ cod);
		
	}

	@Override
	public void KeyReleased(int cod) {
		System.out.println("Release"+ cod);
		
	}

}
