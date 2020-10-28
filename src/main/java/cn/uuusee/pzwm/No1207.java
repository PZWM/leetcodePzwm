package cn.uuusee.pzwm;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] a = new int[2001];
        for (int r : arr
        ) {
            if (r > 0)
                r = r + 1000;
            else
                r = -r;
            a[r] = a[r] + 1;
        }
        Arrays.sort(a);
        int l = 1001;
        for (int t : a
        ) {
            if (t == 0)
                continue;
            if (t == l)
                return false;
            l = t;
        }
        return true;
    }
}
