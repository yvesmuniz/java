package game;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.Display;
import game.input.KeyManager;
import game.states.StateManager;

public class Game implements Runnable{//possibilita a implementação do método Run()	; 

	private Display display; //atributo necessário para controle de exibição
	private Thread thread;
	private boolean running = false;
	private StateManager sm;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	private KeyManager km;
	
	
	public Game() {
		display = new Display("Pong", 400, 300);
		sm = new StateManager();
		km = new KeyManager();
		display.setKeyListener(sm);
		display.setKeyListener(km);
		StateManager.setState(StateManager.MENU);	
	}
	@Override
	public void run() {
		init();
		int FPS = 60;
		double timePerTick = 1000000000 / 60 ;//nano segundos/ tempo ideal
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta +=(now - lastTime) / timePerTick;//intervalo de tempo somado ao delta até = 1; constatando q o tempo q passou foi igual ao tempo ideal
			lastTime = now; //atualizando
			
			if(delta >= 1) {//quando o tempo for ideal  a tela será atualizada
				update();
				render();
				delta--; //repetindo o processo
			}
		
		}
		
	}
	
	private void init() {
		
		
	}
	private void update() {
		if(StateManager.getState() == null) return; //segurança
		sm.update();
		km.update();
	}
	private void render() {
		BufferStrategy bs = display.getBufferStrategy();//aplicar
		if(bs == null) {//caso n exista, irá criar
			display.createBufferStrategy();
			bs = display.getBufferStrategy();//aplicar/pegar
		}
		Graphics g = bs.getDrawGraphics();//pegar o elemento
		g.clearRect(0, 0, WIDTH, HEIGHT);//limpar a tela 60fps
		
		if(StateManager.getState() != null) {
			sm.render(g);//iniciando o render em cada fase(state) passando o objeto gráfico g
		}
		
		g.dispose();//disponibilizar 
		bs.show();//apresentar na tela
	}

	public synchronized void start() {
		if(thread != null) return;
		thread = new Thread(this);//criando a thread na classe que tenha o método run()
		thread.start();//iniciando
		running = true;//liberando o inicio da geração de FPS
	}
	public synchronized void stop() {//synchr é responsável por impedir que os métodos sejam chamados simultaneamente
		if(thread == null) return;
		try {
			thread.join();//juntando com a aplicação principal
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
