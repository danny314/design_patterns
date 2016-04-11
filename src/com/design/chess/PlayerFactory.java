package com.design.chess;

public class PlayerFactory {

	public static Player createPlayer(String name) {
		return new Player(name);
	}

}
