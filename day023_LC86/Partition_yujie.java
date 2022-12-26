package day023_LC86;

import structure.ListNode;


/**
 * 86. 分隔链表
 * 更好的方法：两个链表，一个小于目标节点，一个大于等于目标数，接起来就行
 *
 * @author zhayujie
 * @date 2022/12/26
 */
public class Partition_yujie {
    public ListNode partition(ListNode head, int x) {
        ListNode node = head;

        // 模拟的头结点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        // 目标节点的前置节点，初始状态为模拟节点
        ListNode targetPre = dummyHead;

        // 先找到目标节点
        ListNode target = null;
        while (node != null) {
            if (node.val >= x) {
                target = node;
                break;
            }
            targetPre = node;
            node = node.next;
        }

        // 遍历目标节点的右半边
        node = target;
        while (node != null && node.next != null) {
            if (node.next.val < x) {
                // 小于目标节点，放到前面去
                ListNode changeNode = node.next;
                node.next = changeNode.next;
                targetPre.next = changeNode;
                changeNode.next = target;
                targetPre = changeNode;
            } else {
                node = node.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode node6 = new ListNode(2);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(0, node4);
        ListNode node1 = new ListNode(3, node3);
        ListNode node2 = new ListNode(4, node1);
        ListNode head = new ListNode(1, node2);
        System.out.println(new Partition_yujie().partition(head, 3));
    }
}
