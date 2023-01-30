package de.schucht.trashpandasoko;

import java.util.Scanner;

public class App {

	static GameBoard b;
	static Box box;
	static Player p;
	static String inp = "";

	public static void main(String[] args) {
		init(2, 1, 4, 2, 10, 5);

		Scanner sc = new Scanner(System.in);

		while (true) {
			
			System.out.println("Move: up, down, left, right");
			controls(sc.next());
			draw();
			win();
			
			
		}
	}

	public static void draw() {
		b.drawBoard();
	}

	public static void init(int px, int py, int bx, int by, int boardHeight, int boardWidth) {
		b = new GameBoard(boardHeight, boardWidth, 8,3);

		box = new Box(bx, by, b);
		box.draw(bx, by);

		p = new Player(px, py, b, box);
		p.draw(px, py);

		b.drawBoard();
	}

	public static void controls(String inp) {
		switch (inp) {
		case "u":
			p.moveUp();
			break;
		case "d":
			p.moveDown();
			break;
		case "l":
			p.moveLeft();
			break;
		case "r":
			p.moveRight();
			break;
		default:
			System.out.println("Please use a move command!");
			break;
		}
	}

	public static void win() {
		if(box.getX() == b.getGx() && box.getY() == b.getGy()) {
			
			System.out.println("You have won!!");
		} 
	}

}
