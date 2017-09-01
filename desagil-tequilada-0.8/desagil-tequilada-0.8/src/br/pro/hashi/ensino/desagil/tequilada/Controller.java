package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;


public class Controller implements ActionListener,KeyListener {
	private View view;
	int humanoPontos = 0;
	int cpuPpontos = 0;
	Timer timer = new Timer(100, this);
	

	public Controller(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		view.update();
		if (view.end()) {
			timer.stop();
			if (view.winH()){
				humanoPontos ++;
				view.infoBox("Parabens, Voce Ganhou!!! \nPontua��o: \nSeus Pontos: "+humanoPontos+"\nPontos do Advers�rio: "+cpuPpontos,"Vit�ria!!!");
			}
			else{
				cpuPpontos++;
				view.infoBox("Que pena, voc� perdeu!!!\n\nPontua��o: \nSeus Pontos: "+humanoPontos+"\nPontos do Advers�rio: "+cpuPpontos, "DERROTA!!!");
			}
			
			
		}
		
		}

	@Override
	public void keyPressed(KeyEvent e) {
		if(view.end() == false) {
			timer.start();
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				view.humanUpdate(0,1);	
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				view.humanUpdate(0,-1);	
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				view.humanUpdate(-1,0);	
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				view.humanUpdate(1,0);	
			}	
		}else {
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				view.resetGame();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
