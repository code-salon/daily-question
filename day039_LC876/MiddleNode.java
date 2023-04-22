package day039_LC876;

import structure.ListNode;

/**
 * @autor yud1
 * @date 2023/4/22 11:59
 */
public class MiddleNode {

    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        //虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode q = dummy;
        while(q.next != null && q.next.next!=null){
            p = p.next;
            q = q.next.next;
        }
        return  p.next;
    }
}
