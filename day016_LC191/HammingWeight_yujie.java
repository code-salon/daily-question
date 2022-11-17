package day016_LC191;

/**
 * @author zhayujie
 * @date 2022/11/16
 */
public class HammingWeight_yujie {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            // java里要用无符号位移，否则负数有问题
            n = (n >>> 1);
        }
        return count;
    }
}
