package com.design.chess;

public class Pawn extends ChessPiece {

	@Override
	protected void move(int steps) {
		System.out.println("Moved pawn " + steps + " steps");
	}

}
