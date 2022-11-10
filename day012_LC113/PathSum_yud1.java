package day012_LC113;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor yud1
 * @date 2022/11/10 13:18
 */
public class PathSum_yud1 {

    List<List<Integer>> paths = null;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        dfs(root, targetSum, new ArrayList<>());
        return paths;
    }


    /**
     * 深度优先遍历 记录前面的路径
     */
    public void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root.left == null && root.right == null) {
            path.add(targetSum);
            if (root.val == targetSum) {
                //要重新创建一个集合
                paths.add(new ArrayList<>(path));
            }
            //剪枝
            path.remove(path.size() -1 );
            return;
        }

        path.add(root.val);
        int size = path.size();
        if (root.left != null){
            dfs(root.left, targetSum - root.val,path);
        }


        if (root.right != null) {
            dfs(root.right, targetSum - root.val, path);
        }

        //剪枝
        path.remove(size -1 );
    }
}
