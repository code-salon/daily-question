package day021_LC43;

/**
 *
 *
 * @author zhayujie
 * @date 2022/12/22
 */
public class Multiply_yujie {
    public String multiply(String num1, String num2) {
        String numStr = num1.length() > num2.length() ? num1 : num2;
        char[] ch2 = num1.length() > num2.length() ? num2.toCharArray() : num1.toCharArray();
        String sum = "0";
        for (int i = ch2.length - 1; i >= 0; i--) {
            String num = multiplySingle(numStr, ch2[i]-'0');
            sum = add(sum, multiplyPowTen(num, ch2.length-1-i));
        }
        return sum;
    }

    /**
     * 乘上10的次方
     */
    private String multiplyPowTen(String num1, int times) {
        StringBuilder num = new StringBuilder(num1);
        for (int i = 0; i < times; i++) {
            num.append("0");
        }
        return num.toString();
    }

    /**
     * 乘上一个0~10之间的整数
     */
    private String multiplySingle(String num1, int num2) {
        String res = "0";
        for (int i = 0; i < num2; i++) {
            res = add(res, num1);
        }
        return res;
    }

    /**
     * 两数相加
     */
    public String add(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();

        int i = ch1.length - 1;
        int j = ch2.length - 1;
        // 进位保存
        int plus = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i < 0 ? 0 : ch1[i] - '0';
            int b = j < 0 ? 0 : ch2[j] - '0';
            i--;
            j--;
            int num = (a + b + plus) % 10;
            res.append(num);
            plus = (a + b + plus) / 10;
        }
        if (plus > 0) {
            res.append(plus);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Multiply_yujie().multiply("2", "52"));
    }
}
