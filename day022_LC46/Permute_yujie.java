package day022_LC46;

import java.util.*;

/**
 * 46. 全排列
 *
 * @author zhayujie
 * @date 2022/11/20
 */
public class Permute_yujie {
    /**
     * 节点标记MAP
     */
    private Map<Integer, Boolean> markMap = new HashMap<>();

    /**
     * 路径栈
     */
    private LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteCore(nums, res, 0);
        return res;
    }

    private void permuteCore(int[] nums, List<List<Integer>> res, int pathLength) {
        if (pathLength == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int num : nums) {
            if (!Boolean.TRUE.equals(markMap.get(num))) {
                // 路径压栈和标记
                stack.addLast(num);
                markMap.put(num, Boolean.TRUE);
                // 递归
                permuteCore(nums, res, pathLength+1);
                // 回溯
                markMap.put(num, Boolean.FALSE);
                stack.removeLast();
            }
        }
    }
}
