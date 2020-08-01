package game.chess.main;

public abstract class Piece {
	
	protected int x;
	protected int y;
	protected String name;
	protected boolean alive;
	
	int map[][] = new int[10][10];
	
	//
	public Piece() {
	}

	public Piece(int x, int y, String name, boolean alive) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.alive = alive;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	@Override
	public String toString() {
		return "Piece [x=" + x + ", y=" + y + ", name=" + name + ", alive=" + alive + "]";
	}
	public abstract void catchPiece();
}