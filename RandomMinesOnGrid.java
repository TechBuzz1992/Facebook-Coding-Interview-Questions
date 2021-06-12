package coding.questions;

import java.util.*;

public class RandomMinesOnGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = new char[][] { { '-', '-', '-', '-' }, { '-', '-', '-', '-' }, { '-', '-', '-', '-' } };
		generateKMines(grid, 3);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void generateKMines(char[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		int count = 0;
		Random random = new Random();
		while (count != k) {
			int index = random.nextInt(m * n);
			int i = index % m;
			int j = index % n;
			if (grid[i][j] != 'X') {
				grid[i][j] = 'X';
				count++;
			}
		}
	}

}
