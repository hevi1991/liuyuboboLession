import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> stack2 = new Stack<>();
        // 反过来塞进临时栈
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        // 把插入的元素压到栈顶
        stack.push(x);
        // 临时栈反着塞回去
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 以栈顶为队列头
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        // 以栈顶为队列头
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
    }
}
