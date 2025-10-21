// Program to implement Merge Sort on a Singly Linked List in Java
public class MergeSortLL {

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

    // Utility function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Utility function to add a node at the beginning of the linked list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Function to find the middle node using slow-fast pointer approach
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        // Move fast by 2 steps and slow by 1 step until fast reaches end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow will be at mid
    }

    // Function to merge two sorted linked lists
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // Dummy node
        Node temp = mergedLL;

        // Compare nodes from both lists and attach the smaller one
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes (if any)
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next; // Skip dummy node and return head of merged list
    }

    // Recursive Merge Sort function
    public Node mergeSort(Node head) {
        // Base case: if list has 0 or 1 node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle node
        Node mid = getMid(head);

        // Step 2: Split the list into two halves
        Node rightHead = mid.next;
        mid.next = null;

        // Step 3: Recursively sort the left and right halves
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Step 4: Merge the two sorted halves
        return merge(newLeft, newRight);
    }

    // Main method to test the Merge Sort on Linked List
    public static void main(String[] args) {
        MergeSortLL ll = new MergeSortLL();

        // Add elements (unsorted)
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        System.out.println("Original Linked List:");
        ll.printList(head);

        // Sort the linked list using Merge Sort
        head = ll.mergeSort(head);

        System.out.println("Sorted Linked List:");
        ll.printList(head);
    }
}
