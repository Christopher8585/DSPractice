package Recursion;

public class nQueens {
	int x[];

	nQueens(int size) {
		x = new int[size];
	}

	public void print() {
		int size = x.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				if (x[i] == j)
					System.out.print("Q ");
				else
					System.out.print("* ");

			System.out.println();
		}
		System.out.println();
	}

	public boolean isSafe(int r, int c) {
		for (int i = 0; i < r; i++) {
			if (x[i] == c || i - r == c - x[i] || i - r == x[i] - c)
				return false;
		}
		return true;
	}

	public void findnQueenSoln(int row, int size) {
		for (int i = 0; i < size; i++) {
			if (isSafe(row, i)) {
				x[row] = i;	
				if (row == size - 1)
					print();
				else
					findnQueenSoln(row + 1, size);
			}
		}
	}
	
	public void runNQuees(){
		findnQueenSoln(0, x.length);
	}
}
