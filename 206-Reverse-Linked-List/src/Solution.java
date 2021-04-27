/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseListR(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rev = reverseListR(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode reversedHead = new Solution().reverseListR(head);
        System.out.println(reversedHead);
    }
}