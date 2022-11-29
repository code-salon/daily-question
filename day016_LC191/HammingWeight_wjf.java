package day016_LC191;

/**
 * @Classname HammingWeight_wjf
 * @Description
 * @Date 2022/11/29 11:09
 * @Created by wangjinfeng
 */
public class HammingWeight_wjf {

    public int hammingWeight(int n) {
        int total = 0;
        for (int i=0;i<32;i++) {
            if ((n&(1<<i))!=0) {
                total+=1;
            }
        }
        return total;
    }
}
