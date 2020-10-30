package cn.uuusee.pzwm;

import cn.uuusee.pzwm.structure.TreeNode;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 * <p>
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No129 {
    int[] re = new int[21];

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        return review(root, 0);
    }

    public int review(TreeNode root, int index) {
        int result = 0;
        re[index]=root.val;
        if (root.left == null && root.right == null) {
            re[index] = root.val;
            return toNumber(index);
        }
        if(root.left!=null)
            result+=review(root.left,index+1);
        if(root.right!=null)
            result+=review(root.right,index+1);
        return result;
    }

    private int toNumber(int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            sb.append(re[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
