/**
 * 循环队列的实现
 * 不浪费一个空间的循环队列
 *
 * @param <E> 队列元素类型
 */
public class LoopQueueV2<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueueV2(int capacity) {
        data = (E[]) new Object[capacity];// 不浪费空间
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueV2() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 查看容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
            // 队列已满，要扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size <= (getCapacity() / 4) && getCapacity() / 2 != 0) {
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
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            // 将front所在元素插入到新队列中，并把front设置为0
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front: [");
        // 两种遍历循环队列的方式
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if ((i + front + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueueV2<Integer> queue = new LoopQueueV2<>();
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
