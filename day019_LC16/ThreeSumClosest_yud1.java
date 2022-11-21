package day019_LC16;

import java.util.Arrays;

/**
 * @autor yud1
 * @date 2022/11/19 17:16
 */
public class ThreeSumClosest_yud1 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;
        int minClosest = Integer.MAX_VALUE;
        int minSum = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum-target) < minClosest){
                    minClosest = Math.abs(sum-target);
                    minSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return minSum;
    }


    public static void main(String[] args) {
        ThreeSumClosest_yud1 main = new ThreeSumClosest_yud1();
        System.out.println(main.threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
