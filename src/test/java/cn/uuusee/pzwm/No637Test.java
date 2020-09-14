package cn.uuusee.pzwm;

import cn.uuusee.pzwm.structure.TreeNode;

public class No637Test {
    public static void main(String[] args) {

       TreeNode root= new TreeNode(3);
       root.left=new TreeNode(9);
       TreeNode right=new TreeNode(20);
       right.left=new TreeNode(15);
       right.right=new TreeNode(7);
       root.right=right;
       new No637().averageOfLevels(root);

    }
}
