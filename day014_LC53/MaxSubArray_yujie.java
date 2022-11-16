package day014_LC53;

/**
 * 53. 最大子数组和
 *
 * @author zhayujie
 * @date 2022/11/14
 */
public class MaxSubArray_yujie {
    public int maxSubArray(int[] nums) {
        // dp[i]: 以i为结尾的最大和
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = (dp[i-1] + nums[i]) > nums[i] ? (dp[i-1] + nums[i]) : nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
