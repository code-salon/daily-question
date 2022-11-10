package day012_LC113;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * @author zhayujie
 * @date 2022/11/10
 */
public class PathSum_yujie {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        pathSum(root, targetSum, path, res, 0);
        return res;
    }

    private void pathSum(TreeNode root, int targetSum, LinkedList<Integer> path, List<List<Integer>> res, int total) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        pathSum(root.left, targetSum, path, res, total+root.val);
        pathSum(root.right, targetSum, path, res, total+root.val);

        if (root.left == null && root.right == null && total + root.val == targetSum) {
            // 满足目标和的叶子节点
            addDeepCopyList(res, path);
        }

        // 移除叶子节点，回溯
        path.removeLast();
    }

    private void addDeepCopyList(List<List<Integer>> res, List<Integer> path) {
        List<Integer> targetPath = new ArrayList<>();
        targetPath.addAll(path);
        res.add(targetPath);
    }
}
