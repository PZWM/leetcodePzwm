package cn.uuusee.pzwm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No224 {
    //思路：将-后面括号中内容符号翻转即可
    public int calculate(String s) {
        boolean reverse = false;
        int result = 0;
        char[] chars = s.toCharArray();
        //true=+,false=-
        boolean pre = false;
        boolean opt = true;
        Stack<Boolean> queue = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c > 47 && c < 58) {
                sb.append(c);
                pre = true;
            } else {
                if (pre) {
                    int num = Integer.parseInt(sb.toString());
                    if (opt) {
                        if (reverse) {
                            result -= num;
                            System.out.println("-" + num);
                        } else {
                            result += num;
                            System.out.println("+" + num);
                        }
                    } else {
                        if (reverse) {
                            result += num;
                            System.out.println("+" + num);
                        } else {
                            result -= num;
                            System.out.println("-" + num);
                        }
                    }
                }
                pre = false;
                sb = new StringBuilder();
                if (c == '+') {
                    opt = true;
                } else if (c == '-') {
                    opt = false;
                } else if (c == '(') {
                    queue.push(reverse);
                    if (!opt) {
                        reverse = !reverse;
                    }
                    opt = true;
                } else if (c == ')') {
                    reverse = queue.pop();
                }
            }

        }
        if (sb.length() > 0) {
            int num = Integer.parseInt(sb.toString());
            if (opt)
                result += num;
            else
                result -= num;
        }
        return result;
    }
}
