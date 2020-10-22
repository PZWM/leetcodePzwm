package cn.uuusee.pzwm;

/**
 * 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
 * <p>
 * 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
 * <p>
 * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：D = ["1","3","5","7"], N = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 * <p>
 * 输入：D = ["1","4","9"], N = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 *  
 * <p>
 * 提示：
 * <p>
 * D 是按排序顺序的数字 '1'-'9' 的子集。
 * 1 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No902 {


    /**
     * 思路 ：
     * 不大于存在两种情况：
     * 首先是首位看子集中有没有小于首位的，然后用小于的数量（没有的话就是1）*从第二位起全排列的数量
     * 当首位相同时，还要按照以上逻辑将首位去掉，将第二位当作首位。
     * <p>
     * 存在两种情况：
     * 1、长度=目标数长度
     * 2、长度小于
     *
     * @param digits 输入的数组集
     * @param n      不能超过的数
     * @return 返回统计个数
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int result = 0;
        if (n == 0)
            return result;
        String f = (n + "").substring(0, 1);
        boolean isEq = false;
        int lt = 0;
        for (String s : digits) {
            if (s.equals(f)) {
                isEq = true;
            }
            if (compare(s, f) < 0) {
                lt++;
            }
        }
        if (isEq) {
            if (n > 9) {
                String s = (n + "").substring(1);
                if (!s.startsWith("0"))
                    result = atMostNGivenDigitSet1(digits, Integer.parseInt(s));
            }
        }
        double re = 0;
        double base = digits.length;
        int p = (n + "").length() - 1;
        if (p > 0)
            result = result + (int) Math.pow(base, p) * lt;
        while (p > 0) {
            re = re + Math.pow(base, p);
            p--;
        }
        //这里lt+1是包含不需要第一位，必定小于的情况
        if (n > 9)
            result = result + (int) re;
        else if (isEq)
            result = result + lt + 1;
        else
            result = result + lt;
        return result;
    }

    public int atMostNGivenDigitSet1(String[] digits, int n) {
        int result = 0;
        if (n == 0)
            return 0;
        String f = (n + "").substring(0, 1);
        boolean isEq = false;
        int lt = 0;
        for (String s : digits) {
            if (s.equals(f)) {
                isEq = true;
            }
            if (compare(s, f) < 0) {
                lt++;
            }
        }
        if (isEq) {
            if (n > 9) {
                String s = (n + "").substring(1);
                if (!s.startsWith("0"))
                    result = atMostNGivenDigitSet1(digits, Integer.parseInt(s));
            }
        }
        double re = 0;

        double base = digits.length;
        int p = (n + "").length() - 1;
        if (p > 0)
            result = result + (int) Math.pow(base, p) * lt;
        if (n < 10)
            if (isEq)
                result = result + lt + 1;
            else
                result = result + lt;
        return result;
    }


    private int compare(String a, String b) {
        return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
    }

}
