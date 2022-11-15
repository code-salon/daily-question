package day015_LC215;

import java.util.PriorityQueue;

/**
 * @autor yud1
 * @date 2022/11/15 15:28
 */
public class FindKthLargest_yud1 {
    public int findKthLargest(int[] nums, int k) {

        //默认小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //前k个数加入到小根堆
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        //依次遍历数组后面的数 使得 堆里保持着k个最大的数
        for (int i = k; i < nums.length; i++) {
            //该树 比小根堆的最小数大，则将该数添加进小根堆，并且将堆顶元素弹出
            if (nums[i] > queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.poll();

    }
}
