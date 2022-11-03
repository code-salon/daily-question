package day6_LC724;

/**
 * 进步抱告 724.寻找数组的中心下标
 *
 * @author zhayujie
 * @date 2022/11/3
 */
public class PivotIndex_yujie {
    public int pivotIndex(int[] nums) {
        // 数组总和
        int sum = 0;
        // 当前下标之前元素的总和
        int curSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curSum == sum - nums[i] - curSum) {
                return i;
            }
            curSum += nums[i];
        }
        return -1;
    }
}
