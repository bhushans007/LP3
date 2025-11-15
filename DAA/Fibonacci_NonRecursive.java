import java.util.Scanner;

public class Fibonacci_NonRecursive{

    static int fibonacci(int n) {
        if (n <= 1) {
            System.out.println("Fibonacci Series : " + n);
            return n;
        }

        int a = 0;
        int b = 1;
        int c = 0;

        System.out.print("Fibonacci Series : " + a + " " + b + " ");

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }

        return c;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int ans = fibonacci(n);
        System.out.println("\nFibonacci(" + n + ") = " + ans);

        sc.close();
    }
}
