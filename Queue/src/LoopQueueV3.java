/**
 * 循环队列的实现
 * 没有size成员变量的循环队列
 *
 * @param <E> 队列元素类型
 */
public class LoopQueueV3<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    public LoopQueueV3(int capacity) {
        // 循环队列，需要浪费一个元素位
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueueV3() {
        this(10);
    }

    @Override
    public int getSize() {
        // tail大于等于front，则没包起来，个数就是尾部-头；否则尾减头是负数，头尾已包起来，加上则为总数
        return tail >= front ? tail - front : tail - front + data.length;
    }

    /**
     * 查看容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            // 队列已满，要扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() <= (getCapacity() / 4) && getCapacity() / 2 != 0) {
            // 缩容
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return data[front];
    }

    /**
     * 调整容量大小
     *
     * @param capacity 容量
     */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < getSize(); i++) {
            // 将front所在元素插入到新队列中，并把front设置为0
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = getSize();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", getSize(), getCapacity()));
        res.append("front: [");
        // 两种遍历循环队列的方式
        for (int i = 0; i < getSize(); i++) {
            res.append(data[(i + front) % data.length]);
            if (i != getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueueV3<Integer> queue = new LoopQueueV3<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
