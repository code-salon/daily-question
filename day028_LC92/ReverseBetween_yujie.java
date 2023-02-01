package day028_LC92;

import structure.ListNode;

/**
 * 92. 反转链表 II
 *
 * @author zhayujie
 * @date 2023/2/1
 */
public class ReverseBetween_yujie {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;

        // dummy head
        ListNode dummy = new ListNode(0, head);
        ListNode leftNode = dummy;
        int count = 1;

        // find the left node
        while (count < left) {
          leftNode = node;
          node = node.next;
          count++;
        }

        // do reverse
        ListNode pre = node;
        while (count <= right) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
            count++;
        }

        // left node connect reversed list
        leftNode.next.next = node;
        leftNode.next = pre;
        return dummy.next;
    }

    public static void main(String args[]) {
        ListNode node5 = new ListNode(5);
        ListNode node3 = new ListNode(3, node5);
        System.out.println(node3);

        System.out.println(new ReverseBetween_yujie().reverseBetween(node3, 1, 2));
    }
}
