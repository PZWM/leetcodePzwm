package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.PrintUtils;
import org.testng.annotations.Test;

import java.util.List;

public class No47Test {
    @Test
    public void test0() {
        List<List<Integer>> lists = new No47().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> a : lists) PrintUtils.printList(a);
    }
}
