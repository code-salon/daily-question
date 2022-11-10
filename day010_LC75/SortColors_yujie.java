package day010_LC75;

import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * @author zhayujie
 * @date 2022/11/10
 */
public class SortColors_yujie {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                // 注意当用2去和右边界交换时，i不用递增，因为可能交换一个0回来，还得继续交换
                swap(nums, i, right--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int nums[] = new int[]{2,1,0,2,0};
        new SortColors_yujie().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
