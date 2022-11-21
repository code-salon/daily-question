package day022_LC46;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor yud1
 * @date 2022/11/21 12:19
 */
public class Permute_yud1 {


    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        //下标记录 是否被访问过
        boolean[] visited  =  new boolean[nums.length];
        backTrack(nums,track,visited);
        return ans;
    }

    public void backTrack(int[] nums, LinkedList<Integer> track, boolean[] visited){
        if (track.size() == nums.length){
            //注意 不要直接把集合加入，那么后续的track修改 前面也会修改
            ans.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backTrack(nums,track,visited);
            //remove时  使用集合 linkedlist较为方便
            track.removeLast();
            visited[i] = false;
        }
    }
}
