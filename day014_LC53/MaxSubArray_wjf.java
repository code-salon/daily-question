package day014_LC53;

/**
 * @Classname MaxSubArray_wjf
 * @Description
 * @Date 2022/11/19 18:25
 * @Created by wangjinfeng
 */
public class MaxSubArray_wjf {

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++) {
            if (sum<0) {
                sum=nums[i];
                if (max<nums[i])
                    max=nums[i];
            } else {
                sum+=nums[i];
                if (sum>max) {
                    max=sum;
                }
            }
        }
        return max;
    }
}
