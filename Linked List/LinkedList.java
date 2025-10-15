public class LinkedList {
    // Node class - represents each element of Linked List
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;    // store data
            this.next = null;    // next points to null
        }
    }

    public static Node head;   // first node
    public static Node tail;   // last node
    public static int size;    // size of linked list

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data); // create new node
        size++;
        if(head == null) { // if list empty
            head = tail = newNode;
            return;
        }
        newNode.next = head; // link new node to old head
        head = newNode;      // move head to new node
    }

    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) { // if list empty
            head = tail = newNode;
            return;
        }
        tail.next = newNode; // link last node to new node
        tail = newNode;      // move tail to new node
    }

    // Add node at specific index
    public void add(int idx, int data) {
        if(idx == 0) { // if index 0
            addFirst(data);
            return;     
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1) { // reach previous node
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next; // link new node to next
        temp.next = newNode;      // link prev to new node
    }

    // Remove first node
    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        } else if(size == 1) { // only one node
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;   // store data
        head = head.next;      // move head
        size--;
        return val;            // return removed data
    }

    // Remove last node
    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // find 2nd last node
        Node prev = head;
        for(int i = 0; i < size-2; i++) {
            prev = prev.next;
        }

        int val = tail.data;   // store last data
        prev.next = null;      // remove last link
        tail = prev;           // update tail
        size--;
        return val;
    }

    // Search key using iteration
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        
        while(temp != null) {
            if(temp.data == key) { // found
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1; // not found
    }

    // Helper for recursive search
    public int helper(Node head, int key) {
        if(head == null) return -1;         // base case
        if(head.data == key) return 0;      // found

        int idx = helper(head.next, key);   // recursive call
        if(idx == -1) return -1;            // not found

        return idx + 1;                     // add offset
    }

    // Recursive search function
    public int recSearch(int key) {
        return helper(head, key);
    }

    // Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;   // store next
            curr.next = prev;   // reverse link
            prev = curr;        // move prev
            curr = next;        // move curr
        }
        head = prev;            // update head
    }

    // Delete nth node from end
    public void deleteNthFromEnd(int n) {
        // find total size
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) { // remove first node
            head = head.next;
            return;
        }

        // find (sz - n)th node
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next; // delete node
        return;
    }

    // Find middle using slow-fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;       // +1 step
            fast = fast.next.next;  // +2 steps
        }
        return slow; // mid node
    }

    // Check if list is palindrome
    public boolean checkPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }

        // step 1: find middle
        Node midNode = findMid(head);

        // step 2: reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // head of 2nd half
        Node left = head;  // head of 1st half

        // step 3: compare both halves
        while(right != null) {
            if(left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }

        return true; // all matched
    }

    // Print linked list
    public void print() {
        if(head == null) {
            System.out.println("LL is empty!");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main function to test all methods
    public static void main(String []args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2, 3);
        ll.print();
        System.out.println(size);

        ll.removeFirst();
        ll.print();
        System.out.println(size);

        ll.removeLast();
        ll.print();
        System.out.println(size);

        System.out.println(ll.itrSearch(4));
        System.out.println(ll.itrSearch(10));
        System.out.println(ll.recSearch(4));
        System.out.println(ll.recSearch(10));

        ll.reverse();
        ll.print();

        ll.deleteNthFromEnd(1);
        ll.print();

        ll.addFirst(4);
        ll.addFirst(3);
        ll.print();
        System.out.println(ll.checkPalindrome());
    }
}
