package day013_LC349;

import java.util.*;

/**
 * 349. 两个数组的交集
 *
 * @author zhayujie
 * @date 2022/11/10
 */
public class Intersection_yujie {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, true);
        }
        for (int num : nums2) {
            if (map.get(num) != null) {
                set.add(num);
            }
        }

        int[] nums = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            nums[i++] = num;
        }

        return nums;
    }
}
