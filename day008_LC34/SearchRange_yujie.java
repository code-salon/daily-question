package day8_LC34;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author zhayujie
 * @date 2022/11/7
 */
public class SearchRange_yujie {
    public int[] searchRange(int[] nums, int target) {
        // 通过两次二分法，先找左侧边界，再找右侧边界
        int left = getTargetIndex(nums, target, true);
        int right = getTargetIndex(nums, target, false);
        if (left > right || left < 0 || right > nums.length - 1) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    private int getTargetIndex(int[] nums, int target, boolean isLeft) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                if (isLeft) {
                    // 寻找左侧边界时
                    hi = mid - 1;
                } else {
                    // 寻找右侧边界
                    lo = mid + 1;
                }
            }
        }
        return isLeft ? lo : hi;
    }

    public static void main(String[] args) {
        int[] res = new SearchRange_yujie().searchRange(new int[]{}, 6);
        System.out.println(Arrays.toString(res));
    }
}
