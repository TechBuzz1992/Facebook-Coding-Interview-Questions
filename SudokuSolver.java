package coding.questions;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean solveSudoku(char[][] grid) {
		return solve(grid, 0, 0);
	}

	private static boolean solve(char[][] grid, int row, int col) {
		if (col == grid[0].length) {
			col = 0;
			row += 1;
		}
		if (row == grid.length) {
			return true;
		}

		if (grid[row][col] != '.')
			return solve(grid, row, col + 1);

		for (char num = '1'; num <= '9'; num++) {
			if (checkValid(grid, row, col, num)) {
				grid[row][col] = num;
				boolean solved = solve(grid, row, col + 1);
				if (solved)
					return true;
				else
					grid[row][col] = '.';
			}
		}
		return false;
	}

	private static boolean checkValid(char[][] grid, int row, int col, char num) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][col] == num)
				return false;
			if (grid[row][col] == num)
				return false;
		}
		int boxRow = row / 3;
		int boxCol = col / 3;

		for (int i = boxRow * 3; i < (boxRow + 1) * 3; i++) {
			for (int j = boxCol * 3; j < (boxCol + 1) * 3; j++) {
				if (grid[boxRow][boxCol] == num) {
					return false;
				}
			}
		}
		return true;
	}

}
