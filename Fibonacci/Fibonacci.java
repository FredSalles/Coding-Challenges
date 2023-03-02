package Practice;

public class Fibonacci {
    //
    // Fibonacci - xn = xn−1 + xn−2
    //
    public static void main(String[] args) {

        int result = recursiveFibonacci(10);
        System.out.println("recursive[10]= " + result);

        result = iterativeFibonacci(10);
        System.out.println("iterative[10]= " + result);
    }

    private static int iterativeFibonacci(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        int xn1 = 0;
        int xn2 = 1;
        int value = xn1 + xn2;
        for (int index = 2; index <= i; index++) {
            value = xn1 + xn2;
            xn1 = xn2;
            xn2 = value;
        }
        return value;
    }

    private static int recursiveFibonacci(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return recursiveFibonacci(i - 1) + recursiveFibonacci(i - 2);
    }
}
