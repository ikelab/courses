package ds;


class GameEntry {

	String name;
	int score;

	GameEntry(String n, int s) {
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
