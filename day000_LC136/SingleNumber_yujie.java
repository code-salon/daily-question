package day000_LC136;

/**
 * 136 只出现一次的数字
 *
 * @author yujie
 * @date 2022/10/29
 */
public class SingleNumber_yujie {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[i] ^ nums[0];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber_yujie().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    // 异或的使用:  a ^ a = 0,   a ^ 0 = a,   1001 ^ 1111 = 0110(取反)
}
