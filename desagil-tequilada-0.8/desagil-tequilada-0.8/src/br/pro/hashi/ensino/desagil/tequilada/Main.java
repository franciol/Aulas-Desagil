package br.pro.hashi.ensino.desagil.tequilada;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {

		// Estrutura basica de um programa Swing. Nao precisa entender os detalhes por enquanto.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	

            	// Cria a tela principal.
            	View view = new View();
            	
            	// Cria o Controller.
            	Controller controller = new Controller(view);

            	// Cria a janela.
            	JFrame frame = new JFrame();

            	// Coloca a tela principal na janela.
            	frame.setContentPane(view);

            	// Configura a janela para encerrar o programa quando for fechada.
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            	// Configura a janela para nao ser redimensionavel.
            	frame.setResizable(false);

            	// Redimensiona a janela de acordo com o tamanho do conteudo.
            	frame.pack();

            	// Mostra a janela.
            	frame.setVisible(true);
            	
            	
            	frame.addKeyListener(controller);
            	
            	
            	
            	
            	
            	
            	
            }
        });
    }
}
