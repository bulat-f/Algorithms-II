public class Main {
	public static int[][] mult(int[][] a, int[][] b) {
		int l = a.length, m = b.length, n = b[0].length;
		int[][] c = new int[l][m];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < n; j++) {
				for (int r = 0; r < m; r++)
					c[i][j] += a[i][r] * b[r][j];
			}
		}
		return c;
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] c = mult(a, a);
		print(c);
	}
}