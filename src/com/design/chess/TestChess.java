package com.design.chess;

public class TestChess {

	public static void main(String[] args) {
		
		Player player1 = PlayerFactory.createPlayer("white");
		Player player2 = PlayerFactory.createPlayer("black");
		
		Board board = new Board();
		board.addPlayer(player1);
		board.addPlayer(player2);
		
		board.play();
	}

}
