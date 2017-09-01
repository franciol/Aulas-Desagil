package br.pro.hashi.ensino.desagil.tequilada;

import java.util.Stack;


public class CpuPlayer extends Player {
	private class Cell extends Element {
		public Cell(int row, int col) {
			super(row, col);
		}
	}


	private Stack<Cell> stack;

	private Board board;
	private Board original;


	public CpuPlayer(Board original, int row, int col) {
		super(row, col);

		board = original.clone();
		this.original = original.clone();

	    stack = new Stack<>();
	    closeAndPush();
	}


	private void closeAndPush() {
	    board.setOpen(row, col, false);
	    stack.push(new Cell(row, col));
	}


	public void move() {
		if(board.isOpen(row - 1, col)) {
			row--;
		    closeAndPush();
		}
		else if(board.isOpen(row + 1, col)) {
			row++;
		    closeAndPush();
		}
		else if(board.isOpen(row, col - 1)) {
			col--;
		    closeAndPush();
		}
		else if(board.isOpen(row, col + 1)) {
			col++;
		    closeAndPush();
		}
		else {
			stack.pop();
			Cell cell = stack.peek();
			row = cell.getRow();
			col = cell.getCol();
		}
	}
	public void reset(){
		board = original.clone();
		stack.removeAllElements();
	}
}
