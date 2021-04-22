/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 使用虚拟头节点写法
 */
class Solution3 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode headNode = new ListNode(nums);
        System.out.println(headNode);
        Solution3 solution = new Solution3();

        headNode = solution.removeElements(headNode, 6);
        System.out.println(headNode);
    }
}