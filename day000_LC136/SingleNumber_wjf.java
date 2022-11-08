package day0_LC136;

import java.util.Arrays;

/**
 * @Classname SingleNumber_wjf
 * @Description 136. 只出现一次的数字
 * @Date 2022/11/3 9:24
 * @Created by wangjinfeng
 */
public class SingleNumber_wjf {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=1;
        while (j<nums.length) {
            if (nums[i]==nums[j]) {
                i=i+2;
                j=j+2;
            }
            return nums[i];
        }
        return nums[i];
    }
}
