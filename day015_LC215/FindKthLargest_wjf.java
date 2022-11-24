package day015_LC215;

/**
 * @Classname FindKthLargest_wjf
 * @Description
 * @Date 2022/11/24 17:08
 * @Created by wangjinfeng
 */
public class FindKthLargest_wjf {

    public int findKthLargest(int[] nums, int k) {
        Quick_Sort(nums, 0, nums.length-1);
        return nums[nums.length-1-k];
    }

    public void Quick_Sort(int[] arr, int begin, int end){
        if(begin > end)
            return;
        int tmp = arr[begin];
        int i = begin;
        int j = end;
        while(i != j){
            while(arr[j] >= tmp && j > i)
                j--;
            while(arr[i] <= tmp && j > i)
                i++;
            if(j > i){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[begin] = arr[i];
        arr[i] = tmp;
        Quick_Sort(arr, begin, i-1);
        Quick_Sort(arr, i+1, end);
    }
}
