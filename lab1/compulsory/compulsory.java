public class Main {
    public static int getSumOfDigits ( int number ){
        int sum = 0;
        while ( number != 0 ) {
            sum = sum + (number % 10);
            number = number/10;
        }
        return sum;
    }
  
    public static void main(String[] args) {
        //ex1
        System.out.println("Hello world!");

        //ex2
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        //ex3
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        //ex4
        int result = n * 3;
        int binary = 0b10101;
        result = result + binary;
        int hexa = 0xFF;
        result = result + hexa;
        result = result * 6;
        System.out.println(result);

        //ex5
        result = getSumOfDigits(result);
        while ( result > 9 )
        {
            result = getSumOfDigits(result);
        }
        System.out.println(result);

        //ex6
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}

