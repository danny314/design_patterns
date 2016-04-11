package com.design.chess;

public class ChessPieceFactory {

	public static Pawn createPawn() {
		return new Pawn();
	}

	public static Bishop createBishop() {
		return new Bishop();
	}

	public static Rook createRook() {
		return new Rook();
	}
}
