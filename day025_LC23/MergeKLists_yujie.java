package day025_LC23;

import structure.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 *
 * @author zhayujie
 * @date 2023/1/2
 */
public class MergeKLists_yujie {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        ListNode head = dummyHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> (o1.val - o2.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            head.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
