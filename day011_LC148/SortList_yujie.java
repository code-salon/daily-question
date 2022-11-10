package day011_LC148;

import structure.ListNode;

/**
 * 148. 排序链表
 *
 * @author zhayujie
 * @date 2022/11/10
 */
public class SortList_yujie {
    public ListNode sortList(ListNode head) {
        int count = 0;
        ListNode node = head;
        // 计算链表长度
        while (node != null) {
            count++;
            node = node.next;
        }
        return sortList(head, count);
    }

    private ListNode sortList(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode node = head;
        ListNode right = head;
        while (node != null) {
            count++;
            if (count == n/2) {
                right = node.next;
                // 找到链表中间位置，一刀斩断
                node.next = null;
                break;
            }
            node = node.next;
        }
        // 排序左边链表
        ListNode sortedLeft = sortList(head, count);
        // 排序右边链表
        ListNode sortedRight = sortList(right, n-count);
        // 归并两边链表
        return mergeList(sortedLeft, sortedRight);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val <= right.val) {
            left.next = mergeList(left.next, right);
            return left;
        } else {
            right.next = mergeList(right.next, left);
            return right;
        }
    }
}
