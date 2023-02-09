package day019_LC16;

import java.util.Arrays;
public class ThreeSumClosest_wjf{
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 100000;
        int result = 100000;
        // [-4, -1, 1, 2]
        for (int i=0;i<nums.length;i++) {
            int temp = target-nums[i];
            int start = i+1;
            int end = nums.length-1;
            while (end>start) {
                if (nums[start]+nums[end]==temp) {
                    return target;
                }
                if (Math.abs(temp-nums[start]-nums[end])<result) {
                    result = Math.abs(temp-nums[start]-nums[end]);
                    best = nums[start]+nums[end]+nums[i];
                }
                if (nums[start]+nums[end]>temp) {
                    end--;
                }else if (nums[start]+nums[end]<temp) {
                    start++;
                }
            }
        }
        return best;
    }
}