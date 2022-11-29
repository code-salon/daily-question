package day017_LC202;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname IsHappy_wjf
 * @Description
 * @Date 2022/11/29 11:40
 * @Created by wangjinfeng
 */
public class IsHappy_wjf {

    public static boolean isHappy(int n) {
        Set<Integer> resultSet = new HashSet<>();
        while (true) {
            int total=0;
            while (n > 0) {
                int temp = n % 10;
                n = n / 10;
                total += temp * temp;
            }
            if (!resultSet.add(total)) {
                return false;
            }
            if (total==1) {
                return true;
            }
            n=total;
        }
    }
}
