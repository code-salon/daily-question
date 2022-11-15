package day014_LC53;

/**
 * @autor yud1
 * @date 2022/11/15 15:14
 */
public class MaxSubArray_yud1 {


    /**
     * dp[i]: 表示已下标i结尾的最大子数组和
     * dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i]
     * 边界条件：dp[0] = nums[0]
     */
    public int maxSubArray(int[] nums) {
        //记录最大的子数组和
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] =  nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
