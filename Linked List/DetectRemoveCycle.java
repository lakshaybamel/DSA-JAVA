public class DetectRemoveCycle {

    // Node class to represent each element of the linked list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    // Floyd’s Cycle Detection Algorithm (Tortoise and Hare)
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move by 1
            fast = fast.next.next;      // move by 2

            if (slow == fast) {
                return true;            // cycle detected
            }
        }

        return false;                   // no cycle
    }

    // Main function to test cycle detection
    public static void main(String[] args) {
        // Create a cycle: 1 -> 2 -> 3 -> (back to 1)
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

        // Output: true (cycle exists)
        System.out.println(isCycle());
    }
}
