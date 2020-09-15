package cn.uuusee.pzwm;

import cn.uuusee.pzwm.structure.TreeNode;
import cn.uuusee.pzwm.utils.PrintUtils;

import java.util.*;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 这个题太简单了，又是周末，只求做对ba
 */
//TODO
public class No637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Map<Integer, List<Integer>> integers = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        integers.put(0, temp);
        if (root.left != null||root.right!=null)
            recordV(root, 1, integers);
        int index = 0;
        while (integers.get(index) != null) {
            Double total = 0.0;
            for (int i : integers.get(index)
            ) {
                total += i;
            }
            list.add(total / integers.get(index).size());
            index++;
        }
        PrintUtils.printList(list);
        return list;
    }

    void recordV(TreeNode treeNode, int index, Map<Integer, List<Integer>> integers) {
        if (treeNode.left != null) {
            List<Integer> temp = integers.getOrDefault(index, new ArrayList<>());
            temp.add(treeNode.left.val);
            integers.put(index, temp);
        }
        if (treeNode.right != null) {
            List<Integer> temp = integers.getOrDefault(index, new ArrayList<>());
            temp.add(treeNode.right.val);
            integers.put(index, temp);
        }
        if (treeNode.left != null)
            if (treeNode.left.left != null || treeNode.left.right != null) {
                recordV(treeNode.left, index + 1, integers);
            }

        if (treeNode.right != null)
            if (treeNode.right.left != null || treeNode.right.right != null) {
                recordV(treeNode.right, index + 1, integers);
            }
    }
}


