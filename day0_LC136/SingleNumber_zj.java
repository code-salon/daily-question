package day0_LC136;

/**
 * 136 只出现一次的数字
 *
 * @author zhujun
 * @date 2022/10/31
 */
public class SingleNumber_zj {
    /**
     * 异或也叫半加运算，其运算法则相当于不带进位的二进制加法：二进制下用1表示真，0表示假，
     * 则异或的运算法则为：0⊕0=0，1⊕0=1，0⊕1=1，1⊕1=0（同为0，异为1），
     * 1. 归零律： a^a = 0
     * 2. 恒等律： a^0 = a
     * 3. 交换律： a^b = b^a
     * 4. 结合律： a^b^c = a^(b^c) = (a^b)^c
     * 5. 自反：  a^b^a = a^a^b = 0^b = b
     *
     * 巧用：
     * 1.不用临时变量 交换变量
     * void swap(int a,int b)
     * {
     *  a=a^b;
     *  b=b^a;
     *  a=a^b;
     * }
     * 2.int值判断 if(a^b==0) 则 a==b
     * 3.连续异或可以对相同的数进行消除  如 a^b^c^c^b^a^d = a^a^b^b^c^c^d = d
     */

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    /**
     * 用异或来完成
     * 所有数异或一遍  假设数为 abccbad 则 a^b^c^c^b^a^d = a^a^b^b^c^c^d = d
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums is empty");
        }
        int val = 0;
        for (int i : nums) {
            val = val ^ i;
        }
        return val;
    }
}
