/**
 * @autor yud1
 * @date 2022/10/29 14:16
 */
public class SingleNumber_yud1 {

    /**
     * 利用异或的原理，两个相同的数异或为0，数组中所有的数异或一遍的结果为只出现一次的数
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum = sum ^ i;
        }
        return sum;
    }
}
