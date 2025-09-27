public class BinaryStrings {
    // Print all binary strings of length n without consecutive 1s
    public static void printBinaryStrings(int n, int last, String str) {
        if (n == 0) {             // base case: no more bits to place
            System.out.println(str);
            return;
        }

        // always can place '0'
        printBinaryStrings(n - 1, 0, str + "0");

        // place '1' only if last was '0'
        if (last == 0) {
            printBinaryStrings(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        printBinaryStrings(3, 0, ""); // generate for length 3
    }
}
