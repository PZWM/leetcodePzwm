package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.PrintUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class No338Test {

    @Test
    public void test0() {
        int num=100;
        int[] res = new No338().countBits2(num);
        PrintUtils.printArray(res);
        int[] exp = new No338().countBits(num);
        Assert.assertEquals(res, exp);
    }
}
