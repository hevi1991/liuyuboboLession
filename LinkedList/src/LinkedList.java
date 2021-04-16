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

    private Node dummyHead;// 虚拟头节点
    private int size;

    public LinkedList() {
        dummyHead = new Node();
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
     * 在链表的index（0-based）位置添加新的元素e
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        // 由于虚拟头节点，所以直接循环index次，即会找到需要插入的位置的上一个
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 链表头部添加元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的第index（0-based）个位置的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * /获得链表的第一个元素
     *
     * @return 元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * /获得链表的最后一个元素
     *
     * @return 元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index（0-based）个位置的元素为e
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e 元素
     * @return 结果
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index（0-based）位置的元素，返回删除的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     *
     * @return 元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     *
     * @return 元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList: ");
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }

        /* 另一种遍历方法
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }*/
        res.append("NULL");
        return res.toString();
    }
}
