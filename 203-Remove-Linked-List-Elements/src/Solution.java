/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
class Solution {

    public ListNode removeElements(ListNode head, int val) {

        // 如果head以及head往后连续的值都为val，先删除
        while (head != null && head.val == val) {
            ListNode delHead = head;
            head = head.next;
            delHead.next = null;
        }

        // 如果都删完了，直接返回
        if (head == null) {
            return null;
        }

        // 循环遍历删除链表中其他元素
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode headNode = new ListNode(nums);
        System.out.println(headNode);
        Solution solution = new Solution();

        headNode = solution.removeElements(headNode, 6);
        System.out.println(headNode);
    }
}