package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.PrintUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author pzwm
 * @date 2021/5/6
 */
public class No1720Test {

    @Test
    public void test1(){
        No1720 no1720 = new No1720();
        int[] a=new int[]{1,2,3};
        PrintUtils.printArray(no1720.decode(a,1));
        Assert.assertEquals(no1720.decode(a,1),new int[]{1, 0, 2, 1});
    }

    @Test
    public void test2(){
        No1720 no1720 = new No1720();
        int[] a=new int[]{6,2,7,3};
        PrintUtils.printArray(no1720.decode(a,4));
        Assert.assertEquals(no1720.decode(a,4),new int[]{4,2,0,7,4});
    }
    @Test
    public void test3(){
        No1720 no1720 = new No1720();
        int[] a=new int[]{6};
        PrintUtils.printArray(no1720.decode(a,1));
        PrintUtils.printArray(decode(a,1));
        Assert.assertEquals(no1720.decode(a,1),decode(a,1));
    }



    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }

}
