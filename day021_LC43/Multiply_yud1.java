package day021_LC43;

/**
 * @autor yud1
 * @date 2022/11/21 11:01
 */
public class Multiply_yud1 {
    
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m-1; i >= 0 ; i--) {
            for (int j = n-1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //高位
                int p1 = i + j;
                //低位
                int p2 = i + j + 1;
                int sum = mul + ans[p2];
                ans[p2] = sum % 10;
                ans[p1] += sum / 10;
            }
        }
        int i = 0;
        //去除前缀0
        while(i < ans.length && ans[i] == 0){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j <ans.length; j++) {
            sb.append(ans[j]);
        }

        return sb.length() == 0 ? "0" : sb.toString();

    }

    public static void main(String[] args) {
        Multiply_yud1 yud1 = new Multiply_yud1();
        System.out.println(yud1.multiply("123","456"));
    }
}
