package day015_LC215;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author zhayujie
 * @date 2022/11/14
 */
public class FindKthLargest_yujie {
    public int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length-1, k);
        return nums[k-1];
    }

    private void sort(int[] nums, int i, int j, int k) {
        int v = partition(nums, i, j);
        if (v > k - 1) {
            sort(nums, i, v-1, k);
        } else if (v < k - 1) {
            sort(nums, v+1, j,k);
        }
    }

    private int partition(int[] nums, int i, int j) {
        if (i >= j) {
            return j;
        }
        int mid = nums[i];
        int lo = i, hi = j+1;
        while (true) {
            while (nums[++lo] > mid) {
                if (lo >= j) {
                    break;
                }
            }
            while (nums[--hi] < mid) {
            }
            if (lo >= hi) {
                break;
            }
            swap(nums, lo, hi);
        }
        swap(nums, i, hi);
        return hi;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
