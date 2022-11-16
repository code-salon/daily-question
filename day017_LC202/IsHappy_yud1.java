package day017_LC202;

import java.util.HashSet;

/**
 * @autor yud1
 * @date 2022/11/15 16:33
 */
public class IsHappy_yud1 {


    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            int sum = 0;
            while (n != 0) {
                int x = n % 10;
                sum += x * x;
                n = n / 10;
            }
            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        IsHappy_yud1 yud1 = new IsHappy_yud1();
        System.out.println(yud1.isHappy(2));
    }
}
