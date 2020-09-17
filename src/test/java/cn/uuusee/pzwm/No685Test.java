package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No685Test {
    @Test
    public void test0() {
        int[][] a = new int[5][];
        a[0] = new int[]{4, 2};
        a[1] = new int[]{1, 5};
        a[2] = new int[]{5, 2};
        a[3] = new int[]{5, 3};
        a[4] = new int[]{2, 4};
        Assert.assertEquals(new int[]{4, 2}, new No685().findRedundantDirectedConnection(a));
    }
    @Test
    public void testCycle() {
        int[][] a = new int[5][];
        a[0] = new int[]{1, 2};
        a[1] = new int[]{2, 3};
        a[2] = new int[]{3, 4};
        a[3] = new int[]{4, 1};
        a[4] = new int[]{1, 5};
        Assert.assertEquals(new int[]{4, 1}, new No685().findRedundantDirectedConnection(a));
    }
    @Test
    public void testFather() {
        int[][] a = new int[3][];
        a[0] = new int[]{1, 2};
        a[1] = new int[]{1, 3};
        a[2] = new int[]{2,3};
        Assert.assertEquals(new int[]{2, 3}, new No685().findRedundantDirectedConnection(a));
    }

    @Test
    public void test1() {
        int[][] a = new int[5][];
        a[0] = new int[]{4, 2};
        a[1] = new int[]{1, 5};
        a[2] = new int[]{5, 2};
        a[3] = new int[]{4, 3};
        a[4] = new int[]{4, 1};
        Assert.assertEquals(new int[]{5, 2}, new No685().findRedundantDirectedConnection(a));
    }
}
