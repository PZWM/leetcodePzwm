package cn.uuusee.pzwm;

import cn.uuusee.pzwm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 *  
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No538 {
    List<Integer> all = new ArrayList<>();

    public TreeNode convertBST(TreeNode root) {
        //首先遍历二叉树
        record(root);
        //然后修改二叉树
        modify(root);
        return root;
    }

    private void record(TreeNode root) {
        if (root == null)
            return;
        all.add(root.val);
        record(root.left);
        record(root.right);
    }

    private void modify(TreeNode root) {
        if (root == null)
            return;
        int a = root.val;
        for (Integer i : all) {
            if (i > root.val)
                a += i;
        }
        root.val = a;

        modify(root.left);
        modify(root.right);
    }

}
