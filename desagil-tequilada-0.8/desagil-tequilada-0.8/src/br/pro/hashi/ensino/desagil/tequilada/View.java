package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class View extends JPanel {
	private static final long serialVersionUID = 1L;

	/* NAO PRECISA ENTENDER A LINHA ACIMA POR ENQUANTO */

	private Random ran = new Random();
	private int cellSize;

	private Image humanPlayerImage;
	private Image cpuPlayerImage;
	private Image targetImage;

	private Board board;

	private HumanPlayer humanPlayer;
	private CpuPlayer cpuPlayer;
	private Target target;


	public View() {
		cellSize = 50;

		board = new Board("board.txt");

		int width = board.getWidth();
		int height = board.getHeight();

		setPreferredSize(new Dimension(width * cellSize, height * cellSize));

		humanPlayerImage = loadImage("humanPlayer");
		cpuPlayerImage = loadImage("cpuPlayer");
		targetImage = loadImage("target");

		humanPlayer = new HumanPlayer(board, 0, 0);
		cpuPlayer = new CpuPlayer(board, height - 1, width - 1);

		target = new Target(4, 14);
	}

	public void humanUpdate(int rowShift,int colShift) {
		humanPlayer.move(rowShift, colShift);
		repaint();
	}

	public void update() {
		cpuPlayer.move();
		repaint();
		}


	/* NAO PRECISA ENTENDER O METODO ABAIXO POR ENQUANTO */

	private Image loadImage(String filename) {
		URL url = getClass().getResource("/img/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}


	private void drawImage(Graphics g, Image image, Element element) {
		g.drawImage(image, element.getCol() * cellSize, element.getRow() * cellSize, cellSize, cellSize, null);
	}
	

	@Override
	public void paintComponent(Graphics g) {
		for(int i = 0; i < board.getHeight(); i++) {
			for(int j = 0; j < board.getWidth(); j++) {
				if(board.isOpen(i, j) == true) {
					g.setColor(Color.WHITE);
				}
				else {
					g.setColor(Color.BLACK);
				}

				g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
			}
		}

		drawImage(g, humanPlayerImage, humanPlayer);
		drawImage(g, cpuPlayerImage, cpuPlayer);
		drawImage(g, targetImage, target);

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }
	
	public boolean end() {
		if(humanPlayer.getPos().equals(target.getPos())){
			return true;
		}
		else if(cpuPlayer.getPos().equals(target.getPos())) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean winH(){
		if (humanPlayer.getPos().equals(target.getPos())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void infoBox(String infoMessage,String titleBar){
		JOptionPane.showMessageDialog(null, infoMessage,"RESULTADO: "+titleBar,JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void resetGame(){
		
		humanPlayer.setStart(0, 0);
		cpuPlayer.setStart(board.getHeight()-1,board.getWidth()-1 );
		cpuPlayer.reset();
		boolean yi = true;
		while(true) {
			int x = ran.nextInt(19)+1;
			int y = ran.nextInt(9)+1;
			if (board.isOpen(y,x)) {
				target.setStart(y,x);
				yi = false;
				break;
			}
			
		}
		this.end();
		repaint();
	}
	
	
}
