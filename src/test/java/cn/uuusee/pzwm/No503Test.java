package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.InputUtils;
import cn.uuusee.pzwm.utils.PrintUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class No503Test {

    @Test
    public void test() {
        int[] result = new No503().nextGreaterElements(new int[]{1, 2, 1});
        PrintUtils.printArray(result);
        Assert.assertEquals(result, new int[]{2, -1, 2});
    }


    @Test
    public void test1() {
        int[] result = new No503().nextGreaterElements(new int[]{2, 1, 3, 2, 5, 7, 6, 5, 8, 7, 1, 4});
        PrintUtils.printArray(result);
        Assert.assertEquals(result, new int[]{3, 3, 5, 5, 7, 8, 8, 8, -1, 8, 4, 5});
    }

}
