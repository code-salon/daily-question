package day001_LC108;

import structure.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author zhujun
 * @date 2022/11/03
 */
public class SortedArrayToBST_zj {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        //前后范围不合法，返回空
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
