package cn.uuusee.pzwm;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No132 {

    //这个比较难，先随便做做
    public int minCut(String s) {
        char[] chars = s.toCharArray();
        if(chars.length==1)
            return 0;
        int result = 0;
        int alr = 0;
        while (alr < chars.length) {
            int start = chars.length - 1;
            int r = chars.length - 1;
            A:while (start > alr) {
                for (int i = alr; i < chars.length; i++) {
                    if (chars[i] != chars[r - i]) {
                        start = r;
                        r = i;
                        break;
                    }
                    if(i>=r-i){
                        break A;
                    }
                }
            }
            result++;
            alr = start + 1;
        }
        return result;
    }
}
