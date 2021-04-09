public interface Stack<E> {

    /**
     * 取栈大小
     *
     * @return 栈有多少元素
     */
    int getSize();

    /**
     * 栈是否为空
     *
     * @return 结果
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e 元素
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return 元素
     */
    E pop();

    /**
     * 查看栈顶
     *
     * @return 栈顶元素
     */
    E peek();
}
