package day019_LC16;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @author zhayujie
 * @date 2022/11/20
 */
public class ThreeSumClosest_yujie {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int minSum = 0;

        // 先对数组序
        Arrays.sort(nums);

        // 三指针：每一轮中，i不动， k=i+1 和 j=length-1 不断往中间靠拢
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    minSum = sum;
                }
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return sum;
                }
            }
        }
        return minSum;
    }
}
