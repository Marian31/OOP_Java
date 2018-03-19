public class MatrixPrint {
	public static void main(String args[]){
		int m = 5, n = 5;
		String [n][m] Arr;
		for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == j || i == (j - (n - 1)))
                    Arr[i][j] = "*";
                else Arr[i][j] = (j + 1) + i * 5;
            }
		}
		/*String [][] Array= {{" *", " 2", " 3", " 4", " *"}, {" 6"," *", " 8", " *", "10"}, {"11", "12", " *", "14", "15"},
        {"16", " *", "18", " *", "20"}, {" *", "22", "23", "24"," *"}};
		 for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++)
	                System.out.print(Array[i][j] + " ");
	            System.out.println();*/
	}
	}
}
