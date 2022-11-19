package day018_LC128;

import java.util.HashSet;

/**
 * @autor yud1
 * @date 2022/11/19 16:38
 */
public class LongestConsecutive_yud1 {


    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {

            //已经走过的元素 不用再走了
            if (!set.contains(num)){
                continue;
            }
            int left = num - 1;
            int right = num + 1;
            int longestConsecutive = 1;
            //从这个元素出发向左走
            while (set.contains(left)){
                longestConsecutive++;
                set.remove(left);
                left = left - 1 ;
            }

            //向右走
            while (set.contains(right)){
                longestConsecutive++;
                set.remove(right);
                right = right + 1 ;
            }

            max = Math.max(max, longestConsecutive);

        }
        return max;
    }
}
