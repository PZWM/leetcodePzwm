package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No1046Test {

    @Test
    public void test0(){
        Assert.assertEquals(1,new No1046().lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
