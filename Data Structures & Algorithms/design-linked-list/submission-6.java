class MyLinkedList {

    static class Node {
        Node prev;
        int val;
        Node next;

        Node(Node prev, int val,  Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    Node head = null;
    Node tail = null;

    public MyLinkedList() {

    }
    
    public int get(int index) {
        Node curr = head;
        int currIndex = 0;
        while (currIndex < index && curr != null) {
            curr = curr.next;
            currIndex++;
        }
        if (curr == null) {
            return -1;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(null, val, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(tail, val, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0) index = 0;
        Node curr = head;
        int currIndex = 0;
        while (currIndex < index && curr != null) {
            curr = curr.next;
            currIndex++;
        }
        if (currIndex < index) {
            // If index is greater than the length, the node will not be inserted.
            return;
        }
        
        // Insert first
        // - (null, val, null), head = new, tail = new
        if (head == null && tail == null) {
            Node newNode = new Node(null, val, null);
            head = newNode;
            tail = newNode;
            return;
        }
        // Insert begin
        // - (null, val, head); head.prev = new, head = new
        if (currIndex == 0) {
            Node newNode = new Node(null, val, head);
            head.prev = newNode;
            head = newNode;
            return;
        }
        // Insert end
        // - (tail, val, null), tail.next = new, tail = new
        if (curr == null) {
            Node newNode = new Node(tail, val, null);
            tail.next = newNode;
            tail = newNode;
            return;
        }

        // Insert middle
        // - (prev, val, next), prev.next = new, next.prev = new
        Node newNode = new Node(curr.prev, val, curr);
        curr.prev.next = newNode;
        curr.prev = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if (head == null || index < 0) {
            return;
        }

        Node curr = head;
        int currIndex = 0;
        while (currIndex < index && curr != null) {
            curr = curr.next;
            currIndex++;
        }
        if (curr == null) {
            // If index is greater than the length, the node will not be removed.
            return;
        }

        // Delete single
        // - head = null; tail = null;
        if (curr == head && curr == tail) {
            head = null;
            tail = null;
            return;
        }

        // Delete begin
        // - head.next.prev = null; head = head.next
        if (curr == head) {
            head = head.next;
            head.prev = null;
            return;
        }
        
        // Delete end
        // - tail.prev.next = null; tail = tail.prev
        if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Delete middle
        // - curr.prev.next = curr.next
        // - curr.next.prev = curr.prev
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
}