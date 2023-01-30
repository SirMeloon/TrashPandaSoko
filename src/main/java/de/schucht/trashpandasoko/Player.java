package de.schucht.trashpandasoko;

public class Player implements Object {

	private int x;
	private int y;
	private GameBoard b;
	private Box box;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param GameBoard
	 */
	public Player(int x, int y, GameBoard b, Box box) {
		this.x = x;
		this.y = y;
		this.b = b;
		this.box = box;
	}

	public void draw(int x, int y) {
		if (b.isObstacle(x, y) == false) {
			for (int i = 0; i < b.board.length; i++) {
				for (int j = 0; j < b.board[i].length; j++) {
					if (i == y && j == x) {
						b.board[y][x] = '@';
					}
				}
			}
		} else {
			System.out.println("player spawned out of bounds");
		}
	}

	public void clear(int x, int y) {
		b.board[y][x] = ' ';
	}

	public void moveUp() {

		if (b.isObstacle(x, y - 1) == false) {
			if (box.isBox(x, y - 1) == true) {
				if (b.isObstacle(x, y - 2) == true) {
					System.out.println("Can't go down!");
				} else {
					box.moveUp();
					clear(x, y);
					y -= 1;
					draw(x, y);
				}
			} else {
				clear(x, y);
				y -= 1;
				draw(x, y);
			}
		} else {
			System.out.println("Can't go down!");
		}
	}

	public void moveLeft() {

		if (b.isObstacle(x - 1, y) == false) {
			if (box.isBox(x - 1, y) == true) {
				if (b.isObstacle(x - 2, y) == true) {
					System.out.println("Can't go down!");
				} else {
					box.moveLeft();
					clear(x, y);
					x -= 1;
					draw(x, y);
				}
			} else {
				clear(x, y);
				x -= 1;
				draw(x, y);
			}
		} else {
			System.out.println("Can't go down!");
		}

	}

	public void moveRight() {
		if (b.isObstacle(x + 1, y) == false) {
			if (box.isBox(x + 1, y) == true) {
				if (b.isObstacle(x + 2, y) == true) {
					System.out.println("Can't go down!");
				} else {
					box.moveRight();
					clear(x, y);
					x += 1;
					draw(x, y);
				}
			} else {
				clear(x, y);
				x += 1;
				draw(x, y);
			}
		} else {
			System.out.println("Can't go down!");
		}
	}

	public void moveDown() {
		if (b.isObstacle(x, y + 1) == false) {
			if (box.isBox(x, y + 1) == true) {
				if (b.isObstacle(x, y + 2) == true) {
					System.out.println("Can't go down!");
				} else {
					box.moveDown();
					clear(x, y);
					y += 1;
					draw(x, y);
				}
			} else {
				clear(x, y);
				y += 1;
				draw(x, y);
			}
		} else {
			System.out.println("Can't go down!");
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
