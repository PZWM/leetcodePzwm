package cn.uuusee.pzwm.utils;

import org.testng.annotations.Test;

public class InputUtilsTest {

    @Test
    public void testInputArrays(){
        PrintUtils.printMatrixArray(InputUtils.inputArrays("[[1,2,3],[4,5,6],[7,8,9]]"));
    }

}
