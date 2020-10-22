package cn.uuusee.pzwm;

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length())
            return false;
        char[] a = name.toCharArray();
        char[] b = typed.toCharArray();
        char c;
        char l = 0;
        int i = 0;
        int u = 0;
        while (i < a.length) {
            c = a[i];
            if (b[u] == c) {
                u++;
            } else if (b[u] == l) {
                while (b[u] == l) {
                    u++;
                    if (u == typed.length())
                        return false;
                    if (typed.length() - u < name.length() - i)
                        return false;
                }
                continue;
            } else
                return false;
            l = c;
            i++;
        }
        if (i == a.length && u == b.length) return true;
        else for (int j = u; j < b.length; j++) {
            if (b[j] != l)
                return false;
        }
        return true;
    }
}
