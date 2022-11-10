package day008_LC34;

/**
 * @Classname SearchRange_wjf
 * @Description
 * @Date 2022/11/9 9:52
 * @Created by wangjinfeng
 */
public class SearchRange_wjf {

    public static int[] searchRange(int[] nums, int target) {
        return childMethod(nums, 0, nums.length - 1, target);
    }

    public static int[] childMethod(int[] nums, int start, int end, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                result[0] = 0;
            }
        }
        if (end - start == 1) {
            if (nums[start] == target) {
                result[0] = start;
            }
            if (nums[end] == target) {
                result[1] = end;
            }
            return result;
        }
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            int left = middle - 1;
            int right = middle + 1;
            while (left >= start) {
                if (nums[left] == target) {
                    if (left == start) {
                        result[0] = start;
                        break;
                    } else {
                        --left;
                    }
                } else {
                    result[0] = left + 1;
                    break;
                }
            }

            while (right <= end) {
                if (nums[right] == target) {
                    if (right == end) {
                        result[1] = end;
                        break;
                    } else {
                        ++right;
                    }
                } else {
                    result[1] = right - 1;
                    break;
                }
            }
        }
        if (nums[middle] > target) {
            return childMethod(nums, start, middle - 1, target);
        } else if (nums[middle] < target) {
            return childMethod(nums, middle, end, target);
        }
        return result;
    }
}
