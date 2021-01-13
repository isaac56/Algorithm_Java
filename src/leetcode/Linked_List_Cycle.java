package leetcode;

import java.util.*;

public class Linked_List_Cycle {
    //내 풀이
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curNode = head;
        while(curNode != null) {
            if(set.contains(curNode))
                return true;
            set.add(curNode);
            curNode = curNode.next;
        }
        return false;
    }

    //해설 보고 푼 풀이
    //시간복잡도는 같지만 공간복잡도는 O(1)이 됨
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode faster = head;
        while(faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;
            if(slow == faster)
                return true;
        }
        return false;
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