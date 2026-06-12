class BrowserHistory {
    static class Node {
        Node prev;
        String url;
        Node next;

        Node(Node prev, String url, Node next) {
            this.prev = prev;
            this.url = url;
            this.next = next;
        }
    }
    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(null, homepage, null);
    }
    
    public void visit(String url) {
        Node newNode = new Node(current, url, null);
        current.next = newNode;
        current = newNode;
    }
    
    public String back(int steps) {
        for (int i=0; i<steps; i++) {
            if (current.prev == null) {
                break;
            }
            current = current.prev;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        for (int i=0; i<steps; i++) {
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */