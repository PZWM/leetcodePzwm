package cn.uuusee.pzwm;

import java.util.*;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No503 {

    //找到最大的数字，除了最大数字，其他的肯定都有值
    public int[] nextGreaterElements1(int[] nums) {
        int[] result = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (t == max) {
                result[i] = -1;
            }
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer ii = iterator.next();
                if (t > nums[ii]) {
                    result[ii] = t;
                    iterator.remove();
                }
            }
            list.add(i);

        }

        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (t == max) {
                result[i] = -1;
            }
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer ii = iterator.next();
                if (t > nums[ii]) {
                    result[ii] = t;
                    iterator.remove();
                }
            }
            if (list.size() == 0)
                break;
        }
        return result;
    }

    /**
     * 官方解法，使用单调栈,这样的解法不需要判断最大值，在执行过程中也减少了while判断次数。
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

}
