package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No902Test {

    @Test
    public void test0() {
        int a = 99;
        int b = a / 10;
        System.out.println(b);
    }

    @Test
    //D = ["1","3","5","7"], N = 100
    public void test1() {
        String[] D = new String[]{"1", "3", "5", "7"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 100),20);
    }

    @Test
    //D = ["1","4","9"], N = 1000000000
    public void test2() {
        String[] D = new String[]{"1","4","9"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 1000000000),29523);
    }
    @Test
    //D = ["7"], N = 8
    public void test3() {
        String[] D = new String[]{"7"};
        System.out.println(new No902().atMostNGivenDigitSet(D, 8));
    }

    @Test
    //D = ["3","4","8"], N = 7
    public void test4() {
        String[] D = new String[]{"3","4","8"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 4),2);
    }

    @Test
    //D = ["3","4","5","6"], N = 64
    public void test5() {
        String[] D = new String[]{"3","4","5","6"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 64),18);
    }

    @Test
    //D = ["1"], N = 834
    public void test6() {
        String[] D = new String[]{"1"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 834),3);
    }

    @Test
    //D = ["7"], N = 8
    public void test7() {
        String[] D = new String[]{"7"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 8),1);
    }

    @Test
    //D = ["1","7"], N = 231
    public void test8() {
        String[] D = new String[]{"1","7"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 231),10);
        //4+4+2
    }

    @Test
    //D = [["1","2","3","6","7","8"]], N = 211
    public void test9() {
        String[] D = new String[]{"1","2","3","6","7","8"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 211),79);
        //36+36+6+1
    }

    @Test
    //D = ["1","5","7","8"], N = 10212
    public void test10() {
        String[] D = new String[]{"1","5","7","8"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 10212),340);
        //256+64+16+4
    }

    @Test
    //D = ["1","3","4","5","6","9"], N = 45702
    public void test11() {
        String[] D = new String[]{"1","3","4","5","6","9"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 45702),4974);
        //2592+1296+648+180
    }
    @Test
    //D = ["5","7","8"],N=59
    public void test12() {
        String[] D = new String[]{"5","7","8"};
        Assert.assertEquals(new No902().atMostNGivenDigitSet(D, 59),6);
        //2+3+1
    }
}
