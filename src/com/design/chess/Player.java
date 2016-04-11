package com.design.chess;

public class Player {
	
	private Board board;
	
	private String name;
	
	public Player(String name) {
		this.name = name;
	}

	public void move() {
		//Logic to evaluate what move to make and delegate the move to the appropriate chess piece
		System.out.println(name + " move");
		//Need to keep track of which pieces are my pieces
		board.getGrid()[0][0].move(2);
	}

	public void setBoard(Board board) {
		this.board = board;
	}
 }
