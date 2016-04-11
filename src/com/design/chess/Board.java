package com.design.chess;

public class Board {
	
	private Player player1;
	
	private Player player2;
	
	private ChessPiece[][] grid = new ChessPiece[8][8];
	
	public Board() {
		//Create all 32 players and place them on the grid
		ChessPiece rook = ChessPieceFactory.createRook();
		grid[0][0] = rook;
		
		ChessPiece pawn = ChessPieceFactory.createPawn();
		grid[6][0] = pawn;
		//So on...
		
	}
	
	public void addPlayer(Player player) {
		if (player1 == null) {
			player1 = player;
			player1.setBoard(this);
		} else if (player2 == null) {
			player2 = player;
			player2.setBoard(this);
		} else {
			throw new IllegalArgumentException("Both players are already assigned");
		}
	}
	
	public ChessPiece[][] getGrid() {
		return this.grid;
	}
	
	public void play() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				player1.move();
			} else {
				player2.move();
			}
		}
		
	}

}
