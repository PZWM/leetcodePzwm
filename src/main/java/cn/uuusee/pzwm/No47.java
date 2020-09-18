package cn.uuusee.pzwm;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No47 {

    int[] ori;

    int[] left;

    List<List<Integer>> list = new ArrayList<>();

    List<Integer> all = new ArrayList<>();

    int[] result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new int[nums.length];
        ori = nums;
        left = ori.clone();
        int[] result = nums.clone();
        for (int i : nums) {
            if (all.contains(i))
                continue;
            all.add(i);
        }
        reset(result, 0);
        return list;
    }

    private void reset(int[] result, int i) {
        for (int j = 0; j < all.size(); j++) {
            left = ori.clone();
            for (int k = 0; k < i; k++) {
                removeLeft(result[k]);
            }
            if (!hasNum(all.get(j)))
                continue;
            result[i] = all.get(j);
            removeLeft(all.get(j));
            if (i + 1 == result.length) {
                list.add(asList(result));
                return;
            }
            reset(result, i + 1);
        }
    }

    private boolean removeLeft(int i) {
        for (int j = 0; j < left.length; j++) {
            if (i == left[j]) {
                //呃，这里有点奇怪，不应该这么写，不过为了快速通过每日一题，这样能过
                left[j] = -10000;
                return true;
            }
        }
        return false;
    }

    private boolean hasNum(int i) {
        for (int j = 0; j < left.length; j++) {
            if (i == left[j]) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> asList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        return list;
    }


}
