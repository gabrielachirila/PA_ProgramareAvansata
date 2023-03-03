
public class bonus {
	public static void populateMatrix(int [][] matrix, int n)
	{
		for (int i=0; i<n; i++) {
			  matrix[i][(i+1) % n] = 1; 
			  matrix[(i+1) % n][i] = 1; 
			}
	}
	
	public static void printMatrix(int [][] matrix, int n)
	{
		System.out.print("Matrix A: ");
		System.out.println();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) 
				{
				    System.out.print(matrix[i][j] + " ");
				}
			System.out.println();
		}
	}
	
	public static void compute2Matrices(int [][] matrix1, int [][] matrix2, int [][] result, int n)
	{
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = sum +  matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }
    }
	
	public static void computeMatrices(int [][] matrix1, int [][] matrix2,int [][] result, int n)
	{
		compute2Matrices(matrix1,matrix2,result,n);
		System.out.print("A power 2:");
		System.out.println();
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
		
		int [][] result1 = new int[n][n];
		
		for(int k=3;k<=n;k++)
		{
			System.out.print("A power " + Integer.toString(k) + ": ");
			System.out.println();
			
			compute2Matrices(result,matrix1,result1,n);
			
			for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) 
	                System.out.print(result1[i][j] + " ");
	            System.out.println();
	        }
			
		    for(int i = 0; i< n; i++){
		        for (int j = 0; j < n; j++){
		           result[i][j] = result1[i][j];
		        }
		    }
		}
	}
	
	public static void main(String[] args)
	{
	int n = 4; 
	int[][] A = new int[n][n];

	populateMatrix(A,n);
	printMatrix(A,n);
	
	int [][] result = new int[n][n];
	computeMatrices(A,A,result,n);
	
	
	}
}
