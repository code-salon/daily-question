package day020_LC33;

/**
 * @autor yud1
 * @date 2022/11/21 09:44
 */
public class Search_yud1 {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while(l < r){
            int mid = l + ((r-l) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            //左边有序
            if (nums[0] < nums[mid]) {
                //肯定在左边
                if (target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid +1;
                }
                //右边有序
            }else{
                if(target > nums[mid] && target <= nums[nums.length -1]){
                    l = mid+1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return l;
    }
}
