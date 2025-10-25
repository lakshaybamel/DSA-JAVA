public class CircularLL {
    // Node class
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    // Add at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // point to itself
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head; // circular link
    }

    // Add at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head; // maintain circular link
    }

    // Print Circular LL
    public void print() {
        if (head == null) {
            System.out.println("CLL is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // Delete from beginning
    public void removeFirst() {
        if (head == null) {
            System.out.println("CLL is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    // Delete from end
    public void removeLast() {
        if (head == null) {
            System.out.println("CLL is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularLL cll = new CircularLL();

        cll.addLast(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.addLast(4);

        System.out.println("After adding elements:");
        cll.print();

        cll.addFirst(0);
        System.out.println("\nAfter adding at first:");
        cll.print();

        cll.removeFirst();
        System.out.println("\nAfter removing first:");
        cll.print();

        cll.removeLast();
        System.out.println("\nAfter removing last:");
        cll.print();
    }
}
