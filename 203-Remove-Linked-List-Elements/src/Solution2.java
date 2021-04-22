/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 使用虚拟头节点写法
 */
class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        // 使用虚拟头节点，优化掉head的特殊处理
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 循环遍历删除链表中其他元素
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        // 返回头节点（不能直接返回head的原因是链表删完了，没有head引用可返回的情况）
        return dummyHead.next;
    }
}