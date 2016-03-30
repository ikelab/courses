package ds;


import java.util.Vector;


class GameEntry2 {

	String name;
	int score;

	GameEntry2(String n, int s) {
		name = n;
		score = s;
	}

	String getName() {
		return name;
	}

	int getScore() {
		return score;
	}

	public String toString() {
		return "(" + name + ", " + score + ")";
	}
}


public class Scoreboard2 {

	int capacity;
	Vector<GameEntry2> board = new Vector<GameEntry2>();

	Scoreboard2(int capa) {
		capacity = capa;
	}

	/** Attempt to add a new score to the collection (if it is high enough) */
	void add(GameEntry2 e) {
		int newScore = e.getScore();
		
		// 어느 cell에 넣을지 구한다.
		int j = 0;
		while (j < board.size()) {
			if (board.elementAt(j).getScore() < newScore) {
				break;
			}
			j++;
		}
		
		// 넣는다.
		board.insertElementAt(e, j);
		
		// 크기가 크면 줄인다.
		if (board.size() > capacity) {
			board.setSize(capacity);
		}
	}

	/** Remove and return the high score at index i. */
	GameEntry2 remove(int i) {
		return board.remove(i);
	}

	/** Returns a string representation of the high scores list. */
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int j = 0; j < board.size(); j++) {
			if (j > 0) {
				sb.append(", ");
			}
			sb.append(board.elementAt(j));
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		// The main method
		Scoreboard2 highscores = new Scoreboard2(5);
		String[] names = { "Rob", "Mike", "Rose", "Jill", "Jack", "Anna",
				"Paul", "Bob" };
		int[] scores = { 750, 1105, 590, 740, 510, 660, 720, 400 };

		for (int i = 0; i < names.length; i++) {
			GameEntry2 gE = new GameEntry2(names[i], scores[i]);
			System.out.println("Adding " + gE);
			highscores.add(gE);
			System.out.println(" Scoreboard: " + highscores);
		}
		System.out.println("Removing score at index " + 3);
		highscores.remove(3);
		System.out.println(highscores);
		System.out.println("Removing score at index " + 0);
		highscores.remove(0);
		System.out.println(highscores);
		System.out.println("Removing score at index " + 1);
		highscores.remove(1);
		System.out.println(highscores);
		System.out.println("Removing score at index " + 1);
		highscores.remove(1);
		System.out.println(highscores);
		System.out.println("Removing score at index " + 0);
		highscores.remove(0);
		System.out.println(highscores);
	}
}
