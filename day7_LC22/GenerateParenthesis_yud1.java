package day7_LC22;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor yud1
 * @date 2022/11/4 08:45
 */
public class GenerateParenthesis_yud1 {

    public List<String> list = new ArrayList<>();


    /**
     * 方法一：不使用回溯法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        generateParenthesis("", n, n);
        return list;
    }


    /**
     * @param str   记录括号的添加顺序
     * @param left  左边括号还剩多少
     * @param right 右边括号还剩多少
     */
    public void generateParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }

        //如果剩余左右括号相等，下一次只能用左括号
        if (left == right) {
            generateParenthesis(str + "(", left - 1, right);
        } else {
            //剩余括号不相等，只有剩余左括号>右括号的情况，下一个左右括号都可以
            if (left > 0) {
                generateParenthesis(str + "(", left - 1, right);
            }
            generateParenthesis(str + ")", left, right - 1);
        }
    }

    /**
     * 方法二： 回溯法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return list;
    }

    /**
     * 回溯法
     *
     * @param sb    记录当前所添加的括号
     * @param open  左括号的数量
     * @param close 右括号的数量
     * @param max   n
     */
    public void backtrack(StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            list.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append("(");
            backtrack(sb, open + 1, close, max);
            //剪枝操作
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
