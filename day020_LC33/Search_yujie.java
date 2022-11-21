package day020_LC33;

/**
 * 33. 搜索旋转排序数组
 *
 * @author zhayujie
 * @date 2022/11/20
 */
public class Search_yujie {
    public int search(int[] nums, int target) {
        // 右半边数组一定小于该数，左半边数组一定大于该数
        int partition = nums[0];

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // 第一层判断：二分法中间的数和目标比
            if (nums[mid] < target) {
                // 第二层：中间数在左数组还是右数组
                if (nums[mid] >= partition) {
                    lo++;
                } else {
                    // 第三层：目标数在左数组还是右数组
                    if (target >= partition) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            } else if (nums[mid] > target) {
                if (nums[mid] < partition) {
                    hi--;
                } else {
                    if (target >= partition) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}
