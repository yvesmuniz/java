package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import game.Game;
import game.input.KeyManager;

public class Level1States implements State{
	//definino tamanho da bola
	private Rectangle ball = new Rectangle(Game.WIDTH / 2 - 5, Game.HEIGHT / 2 - 5, 10, 10);
	private int x =0, y = 0, moveX = 1, moveY = 1;
	private Rectangle p1 = new Rectangle(0, 0, 10, 50);
	private Rectangle p2 = new Rectangle(Game.WIDTH - 10, 0, 10, 50);//posicionando jogador
	private int score1 = 0, score2 = 0;
	
	@Override
	public void init() {
		start();	
	}
	
	public void start() {
		ball.x = Game.WIDTH / 2 - 5;
		ball.y = Game.WIDTH / 2 - 5;
		
		Random r = new Random();
		moveX = (r.nextInt(2) == 0) ? 1 : -2;
		moveY = (r.nextInt(2) == 0) ? 1 : -2;
	}

	@Override
	public void update() {
		ball.x += moveX;
		ball.y += moveY;
		limitsBall();
		
		if(KeyManager.w) {
			p1.y -=8;
		}
		if(KeyManager.s) {
			p1.y +=8;
		}
		if(KeyManager.up) {
			p1.y -=8;
		}
		if(KeyManager.down) {
			p1.y +=8;
		}
		
		limitsPlayers();
		
	}
	
	private void limitsPlayers() {
		if(p1.y < 0) {
			p1.y = 0;
		}
		if(p1.y > Game.HEIGHT - p1.height) {
			p1.y = Game.HEIGHT - p1.height;
		}
		if(p2.y < 0) {
			p2.y = 0;
		}
		if(p2.y > Game.HEIGHT - p2.height) {
			p2.y = Game.HEIGHT - p2.height;
		}
		
	}

	private void limitsBall() {
		if (ball.x + 15 > Game.WIDTH) {
			score1++;
			start();
		}
		if (ball.y + 15 > Game.HEIGHT) {
			score2++;
			moveY = -2;
		}
		if (ball.x < 0) {
			start();
		}
		if (ball.y < 0) {
			moveY = 2;
		}
		if (p1.intersects(ball) || p2.intersects(ball)) {
			moveX *= -1;//invertando o sinal
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.WHITE);
		
		Font fonte = new Font("Dialog", Font.BOLD, 12);
		g.setFont(fonte);
		g.drawString("Player 1: "+score1, Game.WIDTH *1/4 - g.getFontMetrics().stringWidth("Player 1: "+score1)/2, g.getFontMetrics(fonte).getHeight());
		g.drawString("Player 2: "+score2, Game.WIDTH *3/4 - g.getFontMetrics().stringWidth("Player 2: "+score2)/2, g.getFontMetrics(fonte).getHeight());
		g.fillRect(Game.WIDTH / 2 - 3, 0, 6, Game.HEIGHT);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
		g.fillRect(p1.x, p1.y, p1.width, p1.height);
		g.fillRect(p2.x, p2.y, p2.width, p2.height);
	}

	@Override
	public void KeyPressed(int cod) {

	}

	@Override
	public void KeyReleased(int cod) {
		
	}

}
