package cn.uuusee.pzwm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No473 {
    /*
    * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。

示例 1:

输入: [1,1,2,2,2]
输出: true

解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例 2:

输入: [3,3,3,3,4]
输出: false

解释: 不能用所有火柴拼成一个正方形。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/matchsticks-to-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */

    int bianchang;

    int curr = 0;

    HashMap<Integer, Integer> canChoose = new HashMap<>();


    public boolean makesquare(int[] nums) {

        //如果数组数量不大于3直接返回错误
        if (nums.length < 4)
            return false;

        //首先判断数组的和能不能整除4
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 4 != 0) return false;

        bianchang = total / 4;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > bianchang)
                return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (canChoose.get(nums[i]) == null) {
                canChoose.put(nums[i], 1);
            } else {
                canChoose.put(nums[i], canChoose.get(nums[i]) + 1);
            }
        }
       int f= canChoose.keySet().iterator().next();
       canChoose.put(f,canChoose.get(f)-1);
        backtrack(f);
        boolean flag = true;
        for (int i : canChoose.keySet()) {
            if (canChoose.get(i)!=0)
                flag = false;
        }
        return flag;
    }

    private boolean backtrack(int index) {
        if (!addCurr(index)) {
            return false;
        }
        int leave = 0;
        for (int i : canChoose.keySet()) {
            int t = canChoose.get(i);
            if(t==0)
                continue;
            leave+=t;
            canChoose.put(i, t - 1);
            if (!backtrack(i)) {
                subCurr(i);
                canChoose.put(i, t);
            } else {
                return true;
            }
        }
        return leave == 0;
    }

    private boolean addCurr(int num) {
        curr += num;
        if (curr > bianchang) {
            return false;
        }
        if (curr == bianchang) {
            curr = 0;
            return true;
        }
        return true;
    }

    private void subCurr(int num) {
        curr -= num;
        while (curr < 0) {
            curr += bianchang;
        }
    }


    public static void main(String[] args) {
        No473 no473 = new No473();
        System.out.println(no473.makesquare(new int[]{1,1,2,2,2}));
    }

}
