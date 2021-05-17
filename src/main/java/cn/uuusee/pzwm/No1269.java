package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.PrintUtils;

/**
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1269 {
    class Func1 {

        public static final int LEFT = 1;
        public static final int DONT_MOVE = 2;
        public static final int RIGHT = 3;

        int[] stepRecord = null;
        int arrIndex = 0;
        int arrLen = 0;
        int result = 0;

        /**
         * 第一次尝试，通过回溯算法去完成
         *
         * @param steps  步骤
         * @param arrLen 数组长度
         * @return
         */
        public int numWays(int steps, int arrLen) {
            stepRecord = new int[steps];
            this.arrLen = arrLen;
            deal(0);
            return result % 1000000007;
        }

        private void deal(int dealIndex) {
            int ori = arrIndex;
            int curr;
            while (stepRecord[dealIndex] < RIGHT) {
                stepRecord[dealIndex]++;
                curr = ori;
                switch (stepRecord[dealIndex]) {
                    case LEFT:
                        curr--;
                        break;
                    case DONT_MOVE:
                        break;
                    case RIGHT:
                        curr++;
                }
                if (curr < 0 || curr >= arrLen) {
                    //错误，直接不用继续了
                    continue;
                }
                //就算后面全是左也无法回到坐标的情况
                if (curr > stepRecord.length - dealIndex) {
                    continue;
                }
                arrIndex = curr;
                if (dealIndex < stepRecord.length - 1)
                    deal(dealIndex + 1);
                else if (arrIndex == 0) {
                    PrintUtils.printArray(stepRecord);
                    System.out.println("");
                    result++;
                    break;
                }
            }
//        if (dealIndex < stepRecord.length-1) {
            stepRecord[dealIndex] = 0;
//        }
            arrIndex = 0;
            for (int i = 0; i < dealIndex; i++) {
                switch (stepRecord[i]) {
                    case LEFT:
                        arrIndex--;
                        break;
                    case DONT_MOVE:
                        break;
                    case RIGHT:
                        arrIndex++;
                }
            }
        }
    }

    /**
     * 最终使用这种方式，一步步规划出最终可能性
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {
        final int mod = 1_000_000_007;
        int maxLen = Math.min(steps / 2, arrLen - 1);
        long[] dp = new long[maxLen + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            long last = 0;
            for (int j = 0; j <= maxLen; j++) {
                //因为左边的值在计算之后会被覆盖，我们提前把它保存下来，
                //供下次运算的时候使用
                long temp = dp[j];
//                //要想走到位置j，可以有3个方向过来
//                //从上面下来，这一步可以省略
//                dp[j] = dp[j];
                //从右边过来，如果右边靠墙了，不能从右边的墙外面过来
                if (j < maxLen)
                    dp[j] += dp[j + 1];
                //从左边过来，但前提是j不能是最左边那一列，
                //否则靠墙了，没法从左边过来
                if (j > 0) {
                    dp[j] += last;
                }
                dp[j] %= mod;
                last = temp;
            }
        }
        return (int) dp[0];
    }
}


