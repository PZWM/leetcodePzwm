package cn.uuusee.pzwm.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * 将力扣常用的input整理到这里方便编写测试案例
 */
public class InputUtils {

    /**
     * @param str 例如[[1,2,3],[4,5,6],[7,8,9]]
     * @return 组装好的数组
     */
    public static int[][] inputArrays(String str) {
        List<List<Integer>> t1 = new LinkedList<>();
        List<Integer> t2 = null;
        StringBuilder cache = new StringBuilder();
        int layer = 0;
        for (char c : str.toCharArray()) {
            if (c == '[') {
                if (layer++ == 0) {
                    continue;
                }
                t2 = new LinkedList<>();
            } else if (c == ',' || c == ']') {
                if(layer<2)
                    continue;
                t2.add(Integer.parseInt(cache.toString()));
                cache.delete(0, cache.length() );
            } else {
                cache.append(c);
            }
            if (c == ']') {
                t1.add(t2);
                if (layer-- == 1) {

                }
            }


        }
        //这里将list转为数组即可
        int[][] ints = new int[t1.size()][t1.get(0).size()];
        for (int i = 0; i < t1.size(); i++) {
            for (int j = 0; j < t1.get(0).size(); j++) {
                ints[i][j]=t1.get(i).get(j);
            }
        }
        return ints;
    }


}
