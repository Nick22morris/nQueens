import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
// import java.nio.file;

public class Queen {
	private int n;
	private String[][] grid;
	private ArrayList<Integer> xs = new ArrayList<Integer>();
	private ArrayList<Integer> ys = new ArrayList<Integer>();
	

	public Queen(int n) {
		this.n = n;
		build(n);
	}

	public void build(int d) {
		grid = new String[d][d];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				grid[row][col] = " ";
			}
		}
	}

	public String toString() {
		String msg = "";
		for (int row = 0; row < grid.length; row++) {
			msg += "|";
			for (int col = 0; col < grid.length; col++) {
				msg += grid[row][col] + "|";
			}
			msg += "\n";
		}
		return msg;
	}

	public boolean isSafe(int row, int col) {
		for (int i = 0; i < xs.size(); i++) {
			if (xs.get(i) == row)
				return false;
			if (ys.get(i) == col)
				return false;
			if (Math.abs(row - xs.get(i)) == Math.abs(col - ys.get(i)))
				return false;
		}
		return true;
	}

	public void placeQueen(int r, int c) {
		grid[r][c] = "Q";
		xs.add(r);
		ys.add(c);
	}

	public void removeQueen(int r, int c) {
		grid[r][c] = " ";
		xs.remove(xs.size() - 1);
		ys.remove(ys.size() - 1);
	}

	public void playGame(int v) {
		if (v < n) {
			for (int i = 0; i < grid[v].length; i++) {
				if (isSafe(v, i)) {
					placeQueen(v, i);
					playGame(v + 1);
					removeQueen(v, i);
				}
			}
		} else
			System.out.println(toString());
	}
}
