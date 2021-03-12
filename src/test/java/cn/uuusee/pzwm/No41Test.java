package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No41Test {

    @Test
    public void test0() {
        Assert.assertEquals(new No41().firstMissingPositive(new int[]{1, 2, 0}), 3);

    }


}
