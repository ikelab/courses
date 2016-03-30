package ds;


class GameEntry1 {

	String name;
	int score;

	GameEntry1(String n, int s) {
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


public class Scoreboard1 {

	int numEntries = 0;
	GameEntry1[] board;

	Scoreboard1(int capacity) {
		board = new GameEntry1[capacity];
	}

	/** Attempt to add a new score to the collection (if it is high enough) */
	void add(GameEntry1 e) {
		int newScore = e.getScore();
		// is the new entry e really a high score?
		if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
			if (numEntries < board.length) // no score drops from the board
				numEntries++; // so overall number increases
			// shift any lower scores rightward to make room for the new entry
			int j = numEntries - 1;
			while (j > 0 && board[j - 1].getScore() < newScore) {
				board[j] = board[j - 1]; // shift entry from j-1 to j
				j--; // and decrement j
			}
			board[j] = e; // when done, add new entry
		}
	}

	/** Remove and return the high score at index i. */
	GameEntry1 remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= numEntries)
			throw new IndexOutOfBoundsException("Invalid index: " + i);
		GameEntry1 temp = board[i]; // save the object to be removed
		for (int j = i; j < numEntries - 1; j++)
			// count up from i (not down)
			board[j] = board[j + 1]; // move one cell to the left
		board[numEntries - 1] = null; // null out the old last score
		numEntries--;
		return temp; // return the removed object
	}

	/** Returns a string representation of the high scores list. */
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int j = 0; j < numEntries; j++) {
			if (j > 0)
				sb.append(", "); // separate entries by commas
			sb.append(board[j]);
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		// The main method
		Scoreboard1 highscores = new Scoreboard1(5);
		String[] names = { "Rob", "Mike", "Rose", "Jill", "Jack", "Anna",
				"Paul", "Bob" };
		int[] scores = { 750, 1105, 590, 740, 510, 660, 720, 400 };

		for (int i = 0; i < names.length; i++) {
			GameEntry1 gE = new GameEntry1(names[i], scores[i]);
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
