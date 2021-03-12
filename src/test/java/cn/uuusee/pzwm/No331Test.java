package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No331Test {

    @Test
    public void test1() {
        Assert.assertEquals(new No331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"), true);
    }

    @Test
    public void test2() {
        Assert.assertEquals(new No331().isValidSerialization("1,#"), false);
    }

    @Test
    public void test3() {
        Assert.assertEquals(new No331().isValidSerialization("9,#,#,1"), false);
    }

    @Test
    public void test4() {
        Assert.assertEquals(new No331().isValidSerialization("#,#,3,5,#"), false);
    }

    @Test
    public void test5() {
        Assert.assertEquals(new No331().isValidSerialization("#,7,6,9,#,#,#"), false);
    }
}
