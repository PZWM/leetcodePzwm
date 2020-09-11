package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[][] arr = new int[k][9];
        int[] nums = new int[k];
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        int[] r = back(index, arr);
        while (r[1] != 0) {
            PrintUtils.printMatrixArray(arr);
            nums[r[0]] = r[1];
            if (sumArr(nums, r[0]) > n) {
                r = back(0, arr);
                index = r[0];
                continue;
            }
            if (r[0] == k - 2) {
                int total = 0;
                for (int i = 0; i < k - 1; i++) {
                    total += nums[i];
                }
                int l = n - total;
                if (l < 10 && l > 0 && arr[k - 1][l - 1] == 0) {
                    nums[k - 1] = l;
                    result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                }
                r = back(index, arr);
                index = r[0];
                continue;
            }
            index++;
            r = back(index, arr);
            index = r[0];
        }
        return result;
    }

    private int sumArr(int[] nums, int i) {
        int total = 0;
        for (int j = 0; j <= i; j++) {
            total += nums[j];
        }
        return total;
    }

    public int[] back(int index, int[][] arr) {
        if (index < 0) {
            return new int[]{0, 0};
        }
        int[] a = arr[index];
        int f = 0;
        for (int i = 0; i < 9; i++) {
            if (a[i] == 0) {
                a[i] = 1;
                f = i + 1;
                break;
            }
        }
        if (f == 0) {
            return back(index - 1, arr);
//            return new int[]{index, f};
        }
        next(index, arr, f);
        return new int[]{index, f};
    }

    public void next(int index, int[][] arr, int f) {
        int[] a = arr[index + 1];
        for (int i = 0; i < 9; i++) {
            if (i < f)
                a[i] = 1;
            else
                a[i] = 0;
        }
    }
}
