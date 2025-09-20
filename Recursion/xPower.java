public class xPower{
    //time - O(n)
    public static int pow(int x, int n) {
        if(n == 0) return 1;
        int xn = x * pow(x, n-1);
        return xn;
    }

    // Optimized recursion O(log n)
    public static int opPow(int x, int n){
        if(n == 0) return 1;

        int halfPower = opPow(x, n/2);         // compute x^(n/2)
        int halfPowerSquare = halfPower * halfPower;

        if(n % 2 != 0) {                       // if n is odd
            return x * halfPowerSquare;
        }
        return halfPowerSquare;                // if n is even
    }

    public static void main(String[] args) {
        int x = 2, n = 10;
        System.out.println(opPow(x, n));
    }
}