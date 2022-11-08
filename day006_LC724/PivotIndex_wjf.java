package day006_LC724;

import java.util.Arrays;

/**
 * @Classname PivotIndex_wjf
 * @Description
 * @Date 2022/11/7 17:24
 * @Created by wangjinfeng
 */
public class PivotIndex_wjf {

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i=0;i<nums.length;i++) {
            if (leftSum*2+nums[i]==sum) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
