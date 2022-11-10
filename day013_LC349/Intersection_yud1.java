package day013_LC349;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @autor yud1
 * @date 2022/11/10 14:48
 */
public class Intersection_yud1 {

    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }


    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }

        for (int num: nums2) {
            if (set.contains(num)){
                set1.add(num);
            }
        }

        return set1.stream().mapToInt(Integer::valueOf).toArray();
    }
}
