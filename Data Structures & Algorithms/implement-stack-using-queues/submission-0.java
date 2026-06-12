class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        Queue<Integer> aux = new LinkedList<>();
        aux.add(x);

        Integer queueItem = queue.poll();
        while (queueItem != null) {
            aux.add(queueItem);
            queueItem = queue.poll();
        }
        queue = aux;
    }
    
    public int pop() {
        Integer queueItem = queue.poll();
        if (queueItem == null){
            return -1;
        }
        return queueItem;
    }
    
    public int top() {
        Integer queueItem = queue.peek();
        if (queueItem == null){
            return -1;
        }
        return queueItem;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */