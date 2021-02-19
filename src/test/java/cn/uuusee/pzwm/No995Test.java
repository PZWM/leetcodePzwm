package cn.uuusee.pzwm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Random;

public class No995Test {

    @Test
    public void test0() {
        int[] A = new int[]{0, 0, 0, 1, 0, 1, 1, 0};
        Assert.assertEquals(3, new No995().minKBitFlips(A, 3));
    }

    @Test
    public void test1() {
        int[] A = new int[]{0, 1, 0};
        Assert.assertEquals(2, new No995().minKBitFlips(A, 1));
    }

    @Test
    public void test2() {
        int[] A = new int[]{1, 1, 0};
        Assert.assertEquals(-1, new No995().minKBitFlips(A, 2));
    }

    @Test
    public void testTime() {
        long time = new Date().getTime();
        int[] A = new int[30000];
        Random random = new Random();
        for (int i = 0; i < 30000; i++) {
            int a=random.nextInt(2);
            System.out.println(a);
            A[i] = a;
        }
        for (int i = 0; i < A.length; i++) {
            System.out.println("A["+i+"]="+A[i]);
        }
//        System.out.println(A);
        System.out.println(new No995().minKBitFlips(A, 100));
        System.out.println(new Date().getTime() - time);
    }

    public void testRandom(){

    }
}
