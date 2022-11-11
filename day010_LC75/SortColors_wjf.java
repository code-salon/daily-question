package day010_LC75;

/**
 * @Classname SortColors_wjf
 * @Description
 * @Date 2022/11/11 10:54
 * @Created by wangjinfeng
 */
public class SortColors_wjf {

    /**
     *  使用冒泡排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        for (int i=0;i<nums.length-1;i++) {
            for (int j=0;j<nums.length-1-i;j++) {
                if (nums[j]>nums[j+1]) {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}
