package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No132Test {

    @Test
    public void test() {
        Assert.assertEquals(1, new No132().minCut("aab"));
    }
    @Test
    public void test1() {
        Assert.assertEquals(0, new No132().minCut("a"));
    }
    @Test
    public void test2() {
        Assert.assertEquals(1, new No132().minCut("ab"));
    }
    @Test
    public void test3() {
        Assert.assertEquals(1, new No132().minCut("bb"));
    }
}
