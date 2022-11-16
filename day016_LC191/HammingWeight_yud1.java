package day016_LC191;

/**
 * @autor yud1
 * @date 2022/11/15 16:21
 */
public class HammingWeight_yud1 {

    /**
     *
     * 6 & 5    0110
     *          0101
     * -----------------------------------
     * 4 & 3    0100
     *          0011
     *          0000
     *
     * n & (n-1) : 结果为去除了二进制最低位的1其他位不变的数
     */
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            n = n & (n-1);
            res++;
        }
        return res;
    }
}
