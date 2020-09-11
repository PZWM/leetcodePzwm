package cn.uuusee.pzwm;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No767 {
    public String reorganizeString(String S) {


        char[] ss = S.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char s : ss
        ) {
            Integer num = map.getOrDefault(s, 0);
            num++;
            map.put(s, num);
        }
        char[] cc = new char[ss.length];
        char last = '~';
        for (int i = 0; i < ss.length; i++) {
            Character t = null;
            int num = 0;
            for (Map.Entry<Character, Integer> entry :
                    map.entrySet()) {
                if (last == entry.getKey())
                    continue;
                if (entry.getValue() > num) {
                    t = entry.getKey();
                    num = entry.getValue();
                }
            }
            if (t == null)
                return "";
            cc[i] = t;
            last = t;
            map.put(t, num - 1);
        }
        return new String(cc);

    }

}
