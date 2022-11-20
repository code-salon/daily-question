package day023_LC86;

import structure.ListNode;

/**
 * @autor yud1
 * @date 2022/11/20 20:54
 */
public class Partition_yud1 {
    
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode more = new ListNode();
        ListNode p = less;
        ListNode q = more;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                p.next = node;
                p = node;
            } else {
                q.next = node;
                q = node;
            }
            ListNode temp = node.next;
            node.next = null;
            node = temp;
        }
        p.next = more.next;
        return less.next;
    }
}
