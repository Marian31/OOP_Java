public class MatrixPrint {
	public static void main(String args[]){
		int m = 5, n = 5;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= m; j++) {
				String num = (i == j - 1 || j == m - i) ? " * " : (i * 5 + j > 9) ? (i * 5 + j) + " " : " " + (i * 5 + j) + " ";
				System.out.print(num);
			}
			System.out.println();
		}
	}
}
