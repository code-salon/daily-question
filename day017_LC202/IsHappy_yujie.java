package day017_LC202;

import java.util.HashMap;
import java.util.Map;

/**
 * 202. 快乐数
 *
 * @author zhayujie
 * @date 2022/11/16
 */
public class IsHappy_yujie {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> map = new HashMap<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            // 判断是否为 100000...
            if (sum == 1) {
                return true;
            }
            // 判断是否无限循环
            if (map.get(sum) != null) {
                return false;
            }
            map.put(sum, Boolean.TRUE);
            n = sum;
        }
    }
}
