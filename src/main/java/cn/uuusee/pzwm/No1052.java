package cn.uuusee.pzwm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1052 {
    //思路1：第一是要将本来生气的分钟变成不生气，第二是要考虑连续的分钟里面最多有多少位顾客。
    //首先将本应该体验不好的顾客按照顺序排列
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                linkedHashMap.put(customers[i], i);
            }
        }
        linkedHashMap.entrySet().stream()
                .sorted((Comparator<Map.Entry<Integer, Integer>> & Serializable)
                        (c1, c2) -> Integer.compare(c2.getKey(), c1.getKey()))
                .forEach(entry -> System.out.println(entry.getKey()));
        //未完待续，突然就感觉好像还没有直接遍历复杂度低了。。。
        return 0;
    }

    //思路2：算出本来就体验好的顾客总数，然后遍历每一种结果，取最大值。
    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int[] result = new int[grumpy.length - X + 1];
        //首先算出所有满意客户
        int satisfiedCustom = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustom += customers[i];
            }
            if(i<grumpy.length-X+1){
                int temp=0;
                for (int j = 0; j < X; j++) {
                    if(grumpy[i+j]==1){
                        temp+=customers[i+j];
                    }
                }
                result[i]=temp;
            }
        }
        Arrays.sort(result);
        return satisfiedCustom+result[result.length-1];
    }
}
