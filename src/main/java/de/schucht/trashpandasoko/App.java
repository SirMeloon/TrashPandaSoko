package de.schucht.trashpandasoko;



import java.util.Scanner;

public class App {

	static GameBoard b;
	static Box box;
	static Player p;
	static String inp = "";
	static boolean win = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Trash Panda needs your help!");
		System.out.println("You have to move the box (o) to the garbage container (D), then the racoon (@) can get to the delicious food!");
		System.out.println("To start write 'start'");

		if (sc.next().equals("start")) {

			init(2, 1, 4, 2, 10, 5);

			while (win == false) {

				System.out.println("Move: (u)p, (d)own, (l)eft, (r)ight");
				controls(sc.next());
				draw();
				win();

			}
		} else {
			System.out.println("Please try again");
		}
	}

	public static void draw() {
		System.out.println("Level: " + b.getLevel());
		b.drawBoard();
	}

	public static void init(int px, int py, int bx, int by, int boardHeight, int boardWidth) {

		b = new GameBoard(boardHeight, boardWidth, 8,3);
		System.out.println("Level: " + b.getLevel());

		box = new Box(bx, by, b);
		box.draw(bx, by);

		p = new Player(px, py, b, box);
		p.draw(px, py);

		b.createObstacles(4,1);
		b.createObstacles(4,3);
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
			win = true;
			System.out.println("The racoon got his food!!");
		} 
	}

}
