package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.InputUtils;
import cn.uuusee.pzwm.utils.PrintUtils;
import org.testng.annotations.Test;

public class No867Test {

    @Test
    public void test0(){
        PrintUtils.printMatrixArray( new No867().transpose(InputUtils.inputArrays("[[1,2,3],[4,5,6],[7,8,9]]")));
    }

    @Test
    public void test1(){
        PrintUtils.printMatrixArray( new No867().transpose(InputUtils.inputArrays("[[1,2,3],[4,5,6]]")));
    }
    @Test
    public void test3(){
        String str= "aaa|BBBB|CCC";
        String[] split = str.split("\\|");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);
    }



}
