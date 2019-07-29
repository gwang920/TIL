package game.chess.piece;

import game.chess.main.Piece;

public class Cannon extends Piece {
	
	
	@Override
	public void catchPiece() {
	}

	public Cannon() {
	}

	public Cannon(int x, int y, String name, boolean alive) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Cannon [x=" + x + ", y=" + y + ", name=" + name + ", alive=" + alive + "]";
	}
	
	
	

}
