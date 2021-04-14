import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 225 用队列实现栈
 */
class MyStack {

    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Queue<Integer> queue2 = new LinkedList<>();
        while (queue.size() > 1) {
            queue2.add(queue.remove());
        }
        Integer ret = queue.remove();
        queue = queue2;
        return ret;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        /*
         * Your MyStack object will be instantiated and called as such:
         * MyStack obj = new MyStack();
         * obj.push(x);
         * int param_2 = obj.pop();
         * int param_3 = obj.top();
         * boolean param_4 = obj.empty();
         */
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
        System.out.println(obj);
    }
}

