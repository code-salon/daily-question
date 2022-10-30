package day1_LC108;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author yujie
 * @date 2022/10/30
 */
public class SortedArrayToBST_yujie {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int rootIndex = (j+i) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(nums, i, rootIndex - 1);
        root.right = sortedArrayToBST(nums, rootIndex + 1, j);
        return root;
    }

    public static void main(String[] args) {
        TreeNode res = new SortedArrayToBST_yujie().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    // 思路：二分查找 + 递归构造
}
