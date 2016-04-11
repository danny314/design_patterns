package com.design.chess;

public class Rook extends ChessPiece {

	@Override
	protected void move(int steps) {
		System.out.println("Moved rook " + steps + " steps");
	}

}
