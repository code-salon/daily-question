package day10_LC75;

/**
 * @autor yud1
 * @date 2022/11/7 10:00
 * 快排3.0解决
 */
public class SortColors_yud1 {

    public void sortColors(int[] nums) {
        //小于1的边界
        int less = -1;
        //大于1的边界
        int more = nums.length;
        int i = 0;

        while (i < more) {
            if (nums[i] < 1) {
                swap(++less, i++, nums);
            } else if (i == 1) {
                i++;
            } else {
                swap(--more, i, nums);
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        SortColors_yud1 sc = new SortColors_yud1();
        sc.sortColors(new int[]{1, 2});
    }
}
