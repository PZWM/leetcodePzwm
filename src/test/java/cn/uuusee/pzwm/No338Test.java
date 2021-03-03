package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No338Test {

    @Test
    public void test0(){
        Assert.assertEquals( new No338().countBits(5),new int[]{0,1,1,2,1,2});
    }
}
