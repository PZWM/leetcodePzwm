package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No224Test {

    @Test
    public void test(){
        Assert.assertEquals(new No224().calculate("(1+(4+5+2)-3)+(6+8)"),23);
    }

    @Test
    public void test1(){
        Assert.assertEquals(new No224().calculate("1 + 1"),2);
    }
    @Test
    public void test2(){
        Assert.assertEquals(new No224().calculate(" 2-1 + 2 "),3);
    }
    @Test
    public void test3(){
        Assert.assertEquals(new No224().calculate("2147483647"),2147483647);
    }
    @Test
    public void test4(){
        Assert.assertEquals(new No224().calculate("214748364-(1+(4+5+2)-3)+(6+8)"),214748369);
    }
}
