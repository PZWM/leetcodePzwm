package cn.uuusee.pzwm;


import cn.uuusee.pzwm.utils.TreeUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class No129Test {
    @Test
    public void test0() {
        Assert.assertEquals(new No129().sumNumbers(TreeUtils.arrToTree(new Object[]{1, 2, 3})), 25);
    }

    @Test
    public void test1() {
        Assert.assertEquals(new No129().sumNumbers(TreeUtils.arrToTree(new Object[]{4,9,0,5,1})), 1026);
    }
}
