package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No1365Test {

    @Test
    public void test0(){
        Assert.assertEquals(new No1365().smallerNumbersThanCurrent(new int[]{8,1,2,2,3}),new int[]{4,0,1,1,3});
    }
}
