package cn.uuusee.pzwm;

import java.util.*;

public class No45 {

    /*给定一个非负整数数组，你最初位于数组的第一个位置。

    数组中的每个元素代表你在该位置可以跳跃的最大长度。

    你的目标是使用最少的跳跃次数到达数组的最后一个位置。

    示例:

    输入: [2,3,1,1,4]
    输出: 2
    解释: 跳到最后一个位置的最小跳跃数是 2。
                 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    说明:

    假设你总是可以到达数组的最后一个位置。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/jump-game-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    private static int step = 0;
    private static int local = 0;

    public static int jump(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> iCanChoose;
        while (local + 1 < length) {
            iCanChoose = new HashMap<>();
            int t = nums[local];
            if (local + t >= length){
                return step + 1;
            }
            for (int i = 1; i <= t; i++) {
                if (local + 1 + t  >= length) {
                    return step +1;
                }
                if (local + 1 + i + nums[local + i] >= length) {
                    return step + 2;
                }
                iCanChoose.put(i, nums[local + i]);
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(
                    iCanChoose.entrySet());
//            list.sort(Comparator.comparingInt(a -> a.getKey() + a.getValue()));
            list.sort((a, b) -> Integer.compare(b.getKey() + b.getValue(), a.getKey() + a.getValue()));
            for (Map.Entry<Integer, Integer> entry : list) {
                if (canIChoose(local, entry.getKey(), 9 + list.size(), nums)) {
                    System.out.print(entry.getValue() + " -> ");
                    choose(entry.getKey());
                    break;
                }
            }

        }
        return step;
    }

    /**
     * m步内没有死就算能选择
     *
     * @param l 当前走到数组的位置
     * @param n 向后走的步数
     * @param m 需要考虑的步数，因为数组内数字不大于10，所以考虑步数是当前可选步骤+9
     *          当考虑范围变成 entry.getKey()+entry.getValue() ，时间会减少两毫秒。
     * @param ns  能够将当前数组按照规则走完即可
     * @return
     */
    private static boolean canIChoose(int l, int n, int m, int[] ns) {
        List listA=Arrays.asList(ns);
        if(!listA.contains(0)){
            return true;
        }
        int end = l + m;
        if (end >= ns.length)
            end = ns.length - 1;
        int[] ms = Arrays.copyOfRange(ns, local + n, end);
        int tL = 0;
        int length = ms.length;
        if (tL + 1 < length) {
            HashMap<Integer, Integer> iCanChoose = new HashMap<>();
            int t = ns[l];
            if (l + t >= length)
                return true;
            for (int i = 1; i <= t; i++) {
                if (l + 1 + i + ns[l + i] >= length) {
                    return true;
                }
                iCanChoose.put(i, ns[l + i]);
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(
                    iCanChoose.entrySet());
            list.sort((a, b) -> Integer.compare(b.getKey() + b.getValue(), a.getKey() + a.getValue()));
            for (Map.Entry<Integer, Integer> entry : list) {
                if (canIChoose(tL, entry.getKey(), 9 + list.size(), ms)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void choose(int n) {
        local += n;
        step++;
    }

    public static void main(String[] args) {

        System.out.println("result:" + jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }
}
