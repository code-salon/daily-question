package day026_LC167;

/**
 *  两数之和 II - 输入有序数组
 *  更好的做法：双指针O(N)
 *
 * @author zhayujie
 * @date 2023/1/3
 */
public class TwoSum_yujie {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num > target / 2) {
                break;
            }
            int otherIndex = find(numbers, target-num, i+1, numbers.length-1);
            if (otherIndex != -1) {
                res[0] = i+1;
                res[1] = otherIndex+1;
                return res;
            }
        }
        return res;
    }

    private int find(int[] numbers, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (numbers[mid] < target) {
                lo = mid + 1;
            } else if (numbers[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
