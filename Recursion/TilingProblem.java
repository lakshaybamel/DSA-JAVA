public class TilingProblem {

    // Count ways to tile a 2 x n floor
    public static int countWays(int n) {
        if (n < 2) return 1; // base case

        // vertical tile → (n-1)
        int v = countWays(n - 1);
        // horizontal pair → (n-2)
        int h = countWays(n - 2);

        return v + h; // total ways
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Ways to tile 2 x " + n + ": " + countWays(n));
    }
}
