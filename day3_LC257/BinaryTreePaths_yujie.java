package day3_LC257;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 进步抱告 257.二叉树的所有路径
 *
 * @author zhayujie
 * @date 2022/10/31
 */
public class BinaryTreePaths_yujie {
    public List<String> binaryTreePaths(TreeNode root) {
        // 最终结果集
        List<String> res = new ArrayList<>();
        // 保存当前路径
        LinkedList<Integer> stack = new LinkedList<>();
        // 前序遍历并保存节点
        binaryTreePathsCore(root, stack, res);
        return res;
    }

    private void binaryTreePathsCore(TreeNode node, LinkedList<Integer> stack, List<String> res) {
        if (node == null) {
            return;
        }
        stack.addLast(node.val);
        if (node.left == null && node.right == null) {
            // 到达叶子节点时将路径加入结果集
            res.add(formatPath(stack));
        } else {
            // 非叶子节点时继续遍历
            binaryTreePathsCore(node.left, stack, res);
            binaryTreePathsCore(node.right, stack, res);
        }
        // 弹出当前节点
        stack.removeLast();
    }

    private String formatPath(LinkedList<Integer> stack) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            res.append(stack.get(i));
            if (i < stack.size() - 1) {
                res.append("->");
            }
        }
        return res.toString();
    }
}
