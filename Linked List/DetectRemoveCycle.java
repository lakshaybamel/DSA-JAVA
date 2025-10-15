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

        // Traverse the list with two pointers: slow moves 1 step, fast moves 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move slow by 1 step
            fast = fast.next.next;      // move fast by 2 steps

            if (slow == fast) {
                return true;            // cycle detected
            }
        }

        return false;                   // no cycle
    }

    // Function to remove the cycle from the linked list
    public static void removeCycle() {
        // Step 1: Detect if there's a cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected when slow and fast pointers meet
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        // If no cycle exists, nothing to remove
        if (!cycle) {
            System.out.println("No cycle to remove.");
            return;
        }

        // Step 2: Find the starting point of the cycle
        slow = head; // reset slow pointer to head
        Node prev = null; // To store the last node before the cycle begins

        // Move slow and fast one step at a time until they meet at the cycle's start
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Remove the cycle by setting the last node's next pointer to null
        prev.next = null;
        System.out.println("Cycle removed.");
    }

    // Main function to test cycle detection and removal
    public static void main(String[] args) {
        // Create a cycle: 1 -> 2 -> 3 -> (back to 2)
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp; // cycle starts here

        // Before removal, check if there's a cycle
        System.out.println("Cycle exists before removal: " + isCycle()); // Output: true

        // Remove the cycle
        removeCycle();

        // After removal, check again
        System.out.println("Cycle exists after removal: " + isCycle()); // Output: false
    }
}
