package cn.uuusee.pzwm;

import cn.uuusee.pzwm.structure.TreeNode;

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//TODO
public class No968 {
    int num = 0;

    public int minCameraCover(TreeNode root) {
        if (root.left != null && root.right != null) {
            if (root.left.left == null && root.left.right == null || root.right.left == null && root.right.right == null) {
                root.val = 1;
            }
        }
        if (root.left == null && root.right == null) {
            root.val = 1;
        }
        //单边等于null需要根据另一边情况判断
        if (root.left == null) {
            if (!haveTwoLayer(root.right)) {
                root.val = 1;
            }
        }
        if (root.right == null) {
            if (!haveTwoLayer(root.left)) {
                root.val = 1;
            }
        }
        if (root.val == 1) {
            putCamera(root.left, false);
            putCamera(root.right, false);
        } else {
            putCamera(root.left, true);
            putCamera(root.right, true);
        }

        record(root);
        return num;
    }

    private void record(TreeNode root) {
        if (root == null)
            return;
        if (root.val == 1)
            num++;
        record(root.left);
        record(root.right);
    }

    /**
     *
     * @param root 传入的就是第一层
     * @return
     */
    private boolean haveTwoLayer(TreeNode root){
        if(root==null)
            return false;
        return root.left!=null||root.right!=null;
    }

    private void putCamera(TreeNode root, boolean need) {
        if (root == null)
            return;
        if (need) {
            root.val = 1;
        }
        putCamera(root.left, !need);
        putCamera(root.right, !need);
    }
}
