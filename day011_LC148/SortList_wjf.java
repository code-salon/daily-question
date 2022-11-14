package day011_LC148;

import structure.ListNode;

/**
 * @Classname SortList_wjf
 * @Description
 * @Date 2022/11/14 18:03
 * @Created by wangjinfeng
 */
public class SortList_wjf {

    public static ListNode sortList(ListNode head) {
        // 归并排序
        if (head.next==null) {
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast.next!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
