package game.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

//classe responsável pela criação e administração da janela
public class Display {

	private JFrame jframe; //responsável por criar a tela
	private Canvas canvas; //classe responsável prla área de desenho da tela

	public Display(String title, int width, int height) {//
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension (width, height));
		canvas.setMaximumSize(new Dimension (width, height));
		canvas.setMinimumSize(new Dimension (width, height));
		 
		jframe = new JFrame(title);
		
		canvas.setFocusable(false);
		jframe.add(canvas);
		
		
		jframe.pack();//redimensiona a janela de acordo com a área de pintura. deve ser chamado antes do setLocationRelativeTo 
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//parar operaçao ao fechar janela
		jframe.setResizable(false);//impossibilitando redimensionamento da janela, a fim de diminuir complexidade do jogo
		jframe.setLocationRelativeTo(null);//não utilizar janelas como referência para o posicionamento
		jframe.setVisible(true);//configurando para ficar visível quando for instanciada
 	
	}	
	
	public BufferStrategy getBufferStrategy() {//tela de pintura do canvas
		return canvas.getBufferStrategy();
	}
	
	public void createBufferStrategy() {//definir quantidade de imagens a serem guardadas para exibição
		canvas.createBufferStrategy(3);//
		//envia uma quantidade de imagens para serem exibidas em fila.
		//Assim, se não der tempo de desenhar uma tela, o monitor terá  outras guardadas enquanto espera chegar. Definido 3 por ser suficiente 
	}
	
	public void setKeyListener(KeyListener kl) {
		jframe.addKeyListener(kl);
	}
}
