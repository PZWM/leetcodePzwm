package cn.uuusee.pzwm;

import cn.uuusee.pzwm.structure.TreeNode;

/**
 * 翻转一棵二叉树。
 */
public class No226 {
    public TreeNode invertTree(TreeNode root) {
        invertNode(root);
        return root;
    }

    private void invertNode(TreeNode root) {
        if(root==null)
            return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
    }


}
