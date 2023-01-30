package de.schucht.trashpandasoko;


public class GameBoard {

	private int height;
	private int width;
	
	private int gx;
	private int gy;

	private int level = 1;



	public char[][] board;

	/**
	 * 
	 * @param height
	 * @param width
	 * @param gx
	 * @param gy
	 */
	public GameBoard(int height, int width, int gx, int gy) {
		this.height = height;
		this.width = width;
		this.gx = gx;
		this.gy = gy;
		board = buildBoard(height, width);
		drawGoal();
	}

	public void drawBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}

	}
	
	public void drawGoal() {
		if (isObstacle(gx, gy) == false) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j <board[i].length; j++) {
					if (i == gy && j == gx) {
						board[gy][gx] = 'D';
					}
				}
			}
		} else {
			System.out.println("Goal spawned out of bounds");
		}
	}

	public char[][] buildBoard(int width, int height) {
		char[][] temp = new char[height][width];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (i == 0 || i == temp.length - 1) {
					temp[i][j] = '#';
				} else if (j == 0 || j == temp[i].length - 1) {
					temp[i][j] = '#';
				} else {
					temp[i][j] = ' ';
				}
			}
		}
		return temp;
	}

	public void createObstacles(int x, int y) {
		if (isObstacle(x, y) == false) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (i == y && j == x) {
						board[y][x] = '#';
					}
				}
			}
		} else {
			System.out.println("Obstacle spawned out of bounds");
		}
	}
	
	public boolean isObstacle(int x, int y) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(i == y && j == x) {
					if(board[i][j] == '#') {
						return true;
					}
				}
			}
		}
		return false;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getGx() {
		return gx;
	}

	public int getGy() {
		return gy;
	}

	public void setGx(int gx) {
		this.gx = gx;
	}

	public void setGy(int gy) {
		this.gy = gy;
	}

}
