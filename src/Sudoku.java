public class Sudoku {
	public static void main(String args[]) {

		int [][]grid = new int[][] { { 2, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		
		
		size = 9;
		print(grid);
		System.out.println();
		
		
		if (SolveSudoku(grid))
			print(grid);
		else
			System.out.println("No solution exists");

		//print(grid);
	}

	private static void print(int [][]grid) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
	}

	//static int grid[][];
	static int size;

	public static boolean isSafe(int [][]grid,int row, int col, int num) {
		return chkRow(grid,row, num) && chkCol(grid,col, num)
				&& chkFrame(grid,row - row % 3, col - col % 3, num);
	}

	public static boolean SolveSudoku(int [][]grid) {

		int row=0;
		int col=0;
		boolean found = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (grid[i][j] == 0) {
					row = i;
					col = j;
					found = true;
					break;
				}
			}
			if (found)
				break;
		}
		
		if (found) {
			for (int i = 1; i <= 9; i++) {
				if (isSafe(grid,row, col, i)) {
					grid[row][col] = i;

					if (SolveSudoku(grid))
						return true;

					grid[row][col] = 0;
				}
			}
		}
		else
			return true;

		return false;
	}

	private static boolean chkFrame(int [][]grid,int startRow, int startcol, int num) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (grid[i+startRow][j+startcol] == num)
					return false;

		return true;
	}

	private static boolean chkCol(int [][]grid,int col, int num) {
		for (int row = 0; row < size; row++) {
			if (grid[row][col] == num)
				return false;
		}

		return true;
	}

	private static boolean chkRow(int [][]grid,int row, int num) {
		for (int col = 0; col < size; col++) {
			if (grid[row][col] == num)
				return false;
		}

		return true;
	}
}
