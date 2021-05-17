package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @date 2021/5/14
 */
public class No1269Test {
    @Test
    public void test() {
        Assert.assertEquals(new No1269().numWays(3, 2), 4);
    }

    @Test
    public void test1() {
        Assert.assertEquals(new No1269().numWays(2, 4), 2);
    }

    @Test
    public void test2() {
        Assert.assertEquals(new No1269().numWays(4, 2), 8);
    }

    @Test
    public void test3() {
        Assert.assertEquals(new No1269().numWays(27, 7), numWays(27, 7));
    }


    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps);
        int[] dp = new int[maxColumn + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] dpNext = new int[maxColumn + 1];
            for (int j = 0; j <= maxColumn; j++) {
                dpNext[j] = dp[j];
                if (j - 1 >= 0) {
                    dpNext[j] = (dpNext[j] + dp[j - 1]) % MODULO;
                }
                if (j + 1 <= maxColumn) {
                    dpNext[j] = (dpNext[j] + dp[j + 1]) % MODULO;
                }
            }
            dp = dpNext;
        }
        return dp[0];
    }
}
