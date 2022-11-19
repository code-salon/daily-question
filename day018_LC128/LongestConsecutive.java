package day018_LC128;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 *
 * @author zhayujie
 * @date 2022/11/19
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        // 集合最大元素数
        int max = 0;
        // 集合节点Map
        Map<Integer, Node> union = new HashMap<>();

        // 构建集合Map
        for (int num : nums) {
            union.put(num, new Node(num, num, 1));
        }

        // 与相邻数字所在集合合并
        for (Integer p : union.keySet()) {
            Node node = union.get(p);
            Node left = union.get(p-1);
            Node right = union.get(p+1);
            merge(union, left, node);
            merge(union, right, node);
        }

        // 统计拥有最多元素的集合大小
        for (Integer p : union.keySet()) {
            max = Math.max(max, union.get(p).size);
        }

        return max;
    }

    /**
     * 找到节点所在集合的根节点
     */
    private Node find(Map<Integer, Node> union, Node node) {
        while (!node.parent.equals(node.id)) {
            node = union.get(node.parent);
        }
        return node;
    }

    /**
     * 合并p和q所在的集合
     */
    private void merge(Map<Integer, Node> union, Node p, Node q) {
        if (p == null || q == null) {
            return;
        }
        Node pRoot = find(union, p);
        Node qRoot = find(union, q);
        if (!pRoot.id.equals(qRoot.id)) {
            qRoot.parent = pRoot.id;
            pRoot.size += qRoot.size;
        }
    }

    /**
     * 元素节点结构
     */
    private class Node {
        /**
         * 节点ID
         */
        Integer id;

        /**
         * 父节点的编号
         */
        Integer parent;

        /**
         * 该节点下面的元素数量
         */
        Integer size;

        Node(int id, int parent, int size) {
            this.id = id;
            this.parent = parent;
            this.size = size;
        }
    }
}
