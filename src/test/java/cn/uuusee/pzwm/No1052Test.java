package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No1052Test {

    @Test
    public void test0(){
        Assert.assertEquals(16, new No1052().maxSatisfied2(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }
}
