public class LinkedList<E> {
    private class Node {
        // 元素内容
        public E e;
        // 下个节点
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return 个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     *
     * @return 结果
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表头部添加元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        // 上面三句话等于下面一句
        head = new Node(e, head);
        size++;
    }

    /**
     * 在链表的index（0-based）位置添加新的元素e
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            // 找到index上一个节点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    /**
     * 在链表末尾添加新的元素e
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

}
