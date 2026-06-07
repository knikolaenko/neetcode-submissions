class MinStack {
    static class Node {
        int val;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        int getVal() {
            return val;
        }

        int getMin() {
            return min;
        }
    }

    Stack<Node> stack = new Stack();

    public MinStack() {
    }
    
    public void push(int val) {
        int min = val;
        if (!stack.empty()) {
            if (stack.peek().min < min) {
                min = stack.peek().min;
            }
        }
        stack.push(new Node(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getVal();
    }
    
    public int getMin() {
        return stack.peek().getMin();
    }
}
