package br.pro.hashi.ensino.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Board {
	private int height;
	private int width;

	private boolean[][] open;


	private Board(int height, int width) {
		this.height = height;
		this.width = width;

		open = new boolean[height][width];
	}


	public Board(String fileName) {

		

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String line = reader.readLine();

			StringTokenizer tokenizer = new StringTokenizer(line);

			height = Integer.valueOf(tokenizer.nextToken());
			width = Integer.valueOf(tokenizer.nextToken());

			open = new boolean[height][width];

			for(int i = 0; i < height; i++) {
				line = reader.readLine();

				for(int j = 0; j < width; j++) {
					if(line.charAt(j) == ' ') {
						open[i][j] = true;
					}
					else {
						open[i][j] = false;
					}
				}
			}

			reader.close();
		}

		

		catch(IOException exception) {
			System.err.println("exception while loading board");
			System.exit(1);
		}
	}


	public Board clone() {
		Board board = new Board(height, width);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				board.setOpen(i, j, open[i][j]);
			}
		}

		return board;
	}


	public boolean isOpen(int row, int col) {
		if(row < 0 || row >= height || col < 0 || col >= width) {
			return false;
		}
		return open[row][col];
	}
	public void setOpen(int row, int col, boolean value) {
		open[row][col] = value;
	}


	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
}
