public interface Queue<E> {

    /**
     * 取队列包含多少个元素
     *
     * @return 数量
     */
    int getSize();

    /**
     * 查看队列是否为空
     *
     * @return 结果
     */
    boolean isEmpty();

    /**
     * 加入队列
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 出队列
     *
     * @return 元素
     */
    E dequeue();

    /**
     * 查看队列首位元素
     *
     * @return 元素
     */
    E getFront();
}
