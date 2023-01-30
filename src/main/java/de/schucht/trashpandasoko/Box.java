package de.schucht.trashpandasoko;

public class Box implements Object {

	private int x;
	private int y;
	private GameBoard b;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param GameBoard
	 */
	public Box(int x, int y, GameBoard b) {
		this.x = x;
		this.y = y;
		this.b = b;
	}

	public void draw(int x, int y) {
		if (b.isObstacle(x, y) == false) {
			for (int i = 0; i < b.board.length; i++) {
				for (int j = 0; j < b.board[i].length; j++) {
					if (i == y && j == x) {
						b.board[y][x] = '0';
					}
				}
			}
		} else {
			System.out.println("Box spawned out of bounds");
		}
	}

	public void clear(int x, int y) {
		b.board[y][x] = ' ';
	}

	public boolean isBox(int x, int y) {
		for (int i = 0; i < b.board.length; i++) {
			for (int j = 0; j < b.board[i].length; j++) {
				if (i == y && j == x) {
					if (b.board[i][j] == '0') {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void moveUp() {
		if (b.isObstacle(x, y - 1) == false) {
			clear(x, y);
			y -= 1;
			draw(x, y);
		} else {
			System.out.println("Can't go up!");
		}

	}

	public void moveDown() {
		if (b.isObstacle(x, y + 1) == false) {
			clear(x, y);
			y += 1;
			draw(x, y);
		} else {
			System.out.println("Can't go down!");
		}
	}

	public void moveLeft() {
		if (b.isObstacle(x - 1, y) == false) {
			clear(x, y);
			x -= 1;
			draw(x, y);
		} else {
			System.out.println("Can't go left!");
		}
	}

	public void moveRight() {
		if (b.isObstacle(x + 1, y) == false) {
			clear(x, y);
			x += 1;
			draw(x, y);
		} else {
			System.out.println("Can't go right!");
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
