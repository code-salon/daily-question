/**
 * @autor zhujun
 * @date 2022/11/07 10:30
 */
public class TitleToNumber_zj {

    public static void main(String[] args) {
        System.out.println(new TitleToNumber_zj().titleToNumber("AB"));
        System.out.println(new TitleToNumber_zj().titleToNumber("A"));
    }

    /**
     * A-Z  1-26
     * AA-AZ 27-52
     * BA-BZ 53-78
     * <p>
     * 26进制转10进制  A-Z用 1-26表示
     * 可以通过ASCII表示 单个字符10进制值 = 字符-A+1
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        if (columnTitle.length() == 0 || columnTitle == null) {
            return 0;
        }
        int value = 0;
        for (char ch : columnTitle.toCharArray()) {
            value = value * 26 + (ch - 'A' + 1);
        }
        return value;
    }


}
