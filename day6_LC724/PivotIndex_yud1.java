package day6_LC724;

/**
 * @autor yud1
 * @date 2022/11/3 12:57
 */
public class PivotIndex_yud1 {

    public int pivotIndex(int[] nums) {
        int right = 0;
        int left = 0;
        //算出以nums[0]为pivot的左右之和
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        if (left == right) {
            return 0;
        }
        // 左边加 右边减 即可
        for (int i = 1; i < nums.length; i++) {
            left += nums[i - 1];
            right -= nums[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
