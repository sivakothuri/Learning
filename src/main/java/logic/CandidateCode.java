package logic;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CandidateCode {

	private static class Cell {

		int x;
		int y;

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private int X() {
			return x;
		}

		private int Y() {
			return y;
		}

		private boolean isValid(int m, int n) {
			return (x < m) && (y < n);
		}

		private boolean isTarget(int m, int n) {
			return (x == m - 1) && (y == n - 1);
		}

		private Cell evaluate(Directions direction, int m, int n) {
			Cell newCell = new Cell(x + direction.X(), y + direction.Y());
			if (newCell.isValid(m, n)) {
				return newCell;
			} else {
				return null;
			}
		}
	}

	private enum Directions {
		RIGHT(0, 1), DOWN(1, 0), DIAGONAL(1, 1);
		private int x;
		private int y;

		Directions(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private int X() {
			return x;
		}

		private int Y() {
			return y;
		}
	}
	
	private static Map<Integer, Set<Directions>> directions = getDirections();
	private static Map<Integer, Set<Directions>> getDirections() {
		Map<Integer, Set<Directions>> map = new HashMap<>();
		map.put(0, EnumSet.noneOf(Directions.class));
		map.put(1, EnumSet.of(Directions.RIGHT));
		map.put(2, EnumSet.of(Directions.DOWN));
		map.put(3, EnumSet.of(Directions.DIAGONAL));
		map.put(4, EnumSet.of(Directions.RIGHT, Directions.DOWN));
		map.put(5, EnumSet.of(Directions.RIGHT, Directions.DIAGONAL));
		map.put(6, EnumSet.of(Directions.DIAGONAL, Directions.DOWN));
		map.put(7, EnumSet.of(Directions.RIGHT, Directions.DIAGONAL, Directions.DOWN));
		return map;
	}

	private static int[][] constructArray(int[] input1, int[] input2) {
		assert input1.length == 2;

		int m = input1[0];
		int n = input1[1];

		assert input2.length == m * n;

		int[][] array = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = input2[(n * i) + j];
			}
		}
		return array;
	}

	public static int no_of_path(int[] input1, int[] input2) {
		int[][] array = constructArray(input1, input2);
		return helper(new Cell(0, 0), array, array.length, array[0].length);
	}
	
	private static int helper(Cell cell,int[][] array, int m, int n)
	{
		int count = 0;
		if (cell == null) return 0;
		if (cell.isTarget(m, n)) {
			return 1;
		}
		
		if (!cell.isValid(m, n)) {
			return 0;			
		}
		
		if (getCellValue(array, cell) == 0) {
			return 0;
		}
		
		for (Directions direction : directions.get(getCellValue(array, cell))) {
			count += helper(cell.evaluate(direction, m, n), array, m, n);
		}
		return count;
		
	}

	static int getCellValue(int[][] array, Cell cell) {
		return array[cell.X()][cell.Y()];
	}

	public static void main(String[] args) {
		int paths = no_of_path(new int[] { 2, 1 }, new int[] {1,0});
		System.out.println(paths);
	}
}
