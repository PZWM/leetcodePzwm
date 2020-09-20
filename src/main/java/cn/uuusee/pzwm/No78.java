package cn.uuusee.pzwm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//TODO 未完成
public class No78 {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    int index;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length + 1; i++) {
            generateXBit(i);
        }
        return result;
    }

    private void generateXBit(int count) {
        index = 0;
        int a = 0;
        int[] ii = new int[count];
        next(0, ii);
        reset(0);
    }

    private void next(int a, int[] ii) {
        if (a > ii.length)
            result.add(asList(ii));
        ii[a] = nums[index];
        index++;
        next(a + 1, ii);
    }

    private void reset(int index) {
    }

    private List<Integer> asList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        return list;
    }
}
