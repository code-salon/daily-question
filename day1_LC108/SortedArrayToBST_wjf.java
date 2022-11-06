package day1_LC108;

import java.util.Arrays;

/**
 * @Classname SortedArrayToBST_wjf
 * @Description
 * @Date 2022/11/3 14:38
 * @Created by wangjinfeng
 */
public class SortedArrayToBST_wjf {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0) {
            return null;
        }
        if (nums.length==1) {
            return new TreeNode(nums[0]);
        }
        int middle = nums.length/2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = sortedArrayToBST(Arrays.stream(nums).limit(middle).toArray());
        treeNode.right = sortedArrayToBST(Arrays.stream(nums).skip(middle+1).toArray());
        return treeNode;
    }
}
