package structure;

/**
 * @autor yud1
 * @date 2022/11/8 11:27
 */
public class ListNode {


    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            str.append(node.val);
            if (node.next != null) {
                str.append(",");
            }
            node = node.next;
        }
        return str.toString();
    }
}
