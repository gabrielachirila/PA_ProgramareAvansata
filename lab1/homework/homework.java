public class homework1 {
    
    public static void populateMatrix(int [][] matrix, int n)
    {
        int line = 0;
        int nr = n+1;
        for (int i = 1; i <= n; i++)
        {
            int column = 0;
            int left = nr;
 
            while (left <= n)
            {
                matrix[line][column] = left;
                left++;
                column ++;
            }
     
            for (int j = 1; j < nr; j++)
            {
                matrix[line][column] = j;
                column ++;
            }
            
            line++;
            nr--;
        }
    }
        
    public static void getLines(int [][] matrix, int n)
    {
        
        for(int i=0; i<n; i++)
        {  
            StringBuilder line = new StringBuilder("Linia " + Integer.toString(i+1) + ": ");
            for(int j=0; j<n; j++)
                line.append(Integer.toString(matrix[i][j]) + " ");
            if(n<30000)
            System.out.println(line);
        }
    }
    
     public static void getColumns(int [][] matrix, int n)
    {
        
        for(int i=0; i<n; i++)
        {  
            StringBuilder line = new StringBuilder("Coloana " + Integer.toString(i+1) + ": ");
            for(int j=0; j<n; j++)
                line.append(Integer.toString(matrix[j][i]) + " ");
            if(n<30000)
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();
        
        if (args.length < 1) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }
        
        int n = Integer.parseInt(args[0]);
        
        try 
		{ 
			System.out.println(n + " is a valid integer"); 
		}  
		catch (NumberFormatException e)  
		{ 
			System.out.println(n + " is not a valid integer"); 
		} 

        
        int[][] matrix = new int[n][n];
        populateMatrix(matrix,n);
        getLines(matrix,n);
        getColumns(matrix,n);
        
        long endTime = System.currentTimeMillis();
        if(n>=30000)
        System.out.println("Time in milliseconds " + (endTime - startTime));
    }
}
