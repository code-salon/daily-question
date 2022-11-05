package day8_LC34;

/**
 * @autor yud1
 * @date 2022/11/5 09:11
 */
public class SearchRange_yud1 {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;


    public int[] searchRange(int[] nums, int target) {
        searchRange(nums,0,nums.length-1,target);
        return min == Integer.MAX_VALUE ? new int[]{-1,-1} : new int[]{min,max};
    }


    /** 二分查找
     * @param nums
     * @param l
     * @param r
     * @param target
     */
    public void searchRange(int[] nums, int l, int r, int target) {
        if (l > r) return;
        if (l == r) {
            if (nums[l] == target) {
                min = Math.min(min, l);
                max = Math.max(max, l);
            }
            return;
        }
        int mid = l + ((r - l) >> 1);
        // ==时，说明左右仍然有target，继续二分
        if (nums[mid] == target){
            //记录每个target的下标，选出最大值和最小值
            min = Math.min(min, mid);
            max = Math.max(max, mid);
            searchRange(nums, l, mid-1,target);
            searchRange(nums,mid+1, r, target);
            //target 在左边
        } else if(nums[mid] > target){
            searchRange(nums, l, mid-1,target);
            //target 在左边
        }else{
            searchRange(nums,mid+1, r, target);
        }
    }
}
