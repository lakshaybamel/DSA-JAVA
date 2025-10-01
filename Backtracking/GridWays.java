public class GridWays {

    // Function to count number of ways to reach bottom-right from (i,j)
    public static int ways(int i, int j, int n, int m) {
        if(i == n-1 && j == m-1){ // reached destination
            return 1;
        } else if(i == n || j == m) { // out of grid
            return 0;
        }

        // recursive calls: move down and move right
        int w1 = ways(i+1, j, n, m); // move down
        int w2 = ways(i, j+1, n, m); // move right

        return w1 + w2; // total ways
    }

    public static void main(String []args) {
        int n = 3, m = 3;
        System.out.println(ways(0, 0, n, m)); // print total ways from top-left
    }
}

/*
Time Complexity: O(2^(n*m)) - exponential, as each cell has 2 choices (down/right) recursively
Space Complexity: O(n + m) - maximum recursion stack depth
*/
