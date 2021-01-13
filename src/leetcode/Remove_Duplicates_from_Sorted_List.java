package leetcode;

public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while(curNode != null) {
            ListNode toNext = curNode.next;
            while(toNext != null && toNext.val == curNode.val) {
                toNext = toNext.next;
            }
            curNode.next = toNext;
            curNode = curNode.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
