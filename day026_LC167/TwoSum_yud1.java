package day026_LC167;

/**
 * @autor yud1
 * @date 2022/11/27 14:55
 */
public class TwoSum_yud1 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length -1 ;
        while (numbers[l] + numbers[r] != target){
            if (numbers[l] + numbers[r] > target){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{l+1,r+1};
    }
}
