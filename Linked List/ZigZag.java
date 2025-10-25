// Program to rearrange a Singly Linked List in Zig-Zag fashion in Java
// Example: 1 -> 2 -> 3 -> 4 -> 5 becomes 1 -> 5 -> 2 -> 4 -> 3
public class ZigZag {

    // Node class representing each element of the linked list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list
    public static Node head;

    // Function to add a node at the beginning of the linked list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to rearrange the linked list in Zig-Zag manner
    public void zigZagLL() {
        // Step 1: Find the middle of the linked list using slow-fast pointers
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // Step 2: Reverse the second half of the linked list
        Node curr = mid.next;
        mid.next = null; // break the list into two halves
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Now 'prev' is the head of the reversed second half
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // Step 3: Merge both halves in alternating (zig-zag) order
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // Move to next pair
            left = nextL;
            right = nextR;
        }
    }

    // Main method to test the Zig-Zag Linked List rearrangement
    public static void main(String[] args) {
        ZigZag ll = new ZigZag();

        // Adding elements to linked list (initial order: 1 -> 2 -> 3 -> 4 -> 5)
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        System.out.println("Original Linked List:");
        ll.printList(head);

        // Apply Zig-Zag rearrangement
        ll.zigZagLL();

        System.out.println("Zig-Zag Linked List:");
        ll.printList(head);
    }
}
