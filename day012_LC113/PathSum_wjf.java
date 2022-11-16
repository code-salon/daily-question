package day012_LC113;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PathSum_wjf
 * @Description
 * @Date 2022/11/16 10:29
 * @Created by wangjinfeng
 */
public class PathSum_wjf {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        pathSumMethod(root, targetSum, new ArrayList<Integer>());
        return result;
    }

    public static void pathSumMethod(TreeNode root, int targetSum, List<Integer> pathList) {
        Integer sum=pathList.stream().reduce(Integer::sum).orElse(0)+root.val;
        pathList.add(root.val);
        if (root.left==null&&root.right==null) {
            if (sum==targetSum) {
                result.add(pathList);
            }
        }
        if (sum<targetSum) {
            if (root.left!=null) {
                List<Integer> left = new ArrayList<Integer>();
                left.addAll(pathList);
                // List<Integer> left = pathList;
                pathSumMethod(root.left, targetSum, left);
            }

            if (root.right!=null) {
                List<Integer> right = new ArrayList<>();
                right.addAll(pathList);
                //List<Integer> right = pathList;
                pathSumMethod(root.right, targetSum, right);
            }
        }
    }
}
