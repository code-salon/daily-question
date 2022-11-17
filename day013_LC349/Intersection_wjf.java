package day013_LC349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Intersection_wjf
 * @Description
 * @Date 2022/11/17 19:41
 * @Created by wangjinfeng
 */
public class Intersection_wjf {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setArr = new HashSet<Integer>();
        for (int i=0;i<nums1.length;i++) {
            setArr.add(nums1[i]);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        int[] ints = {};
        for (int j=0;j<nums1.length;j++) {
            if (!setArr.add(nums2[j])) {
                integers.add(nums2[j]);
            }
        }
        for (int i=0;i<integers.size();i++) {
            ints[i]=integers.get(i);
        }
        return ints;
    }
}
