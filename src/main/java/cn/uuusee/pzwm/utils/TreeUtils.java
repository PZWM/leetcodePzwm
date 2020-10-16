package cn.uuusee.pzwm.utils;

import cn.uuusee.pzwm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    public static TreeNode arrToTree(Object[] arr) {
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> lastList;
        TreeNode root = new TreeNode((int) arr[0]);
        list.add(root);
        lastList = list;
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            if (num == 0)
                list = new ArrayList<>();
            TreeNode t = null;
            if (arr[i] != null) {
                t = new TreeNode((int) arr[i]);
                list.add(t);
            }
            if (num < lastList.size() * 2) {
                TreeNode p = lastList.get(num / 2);
                if (num % 2 == 0) {
                    p.left = t;
                } else {
                    p.right = t;
                }
                num++;
                continue;
            }
            lastList = list;
            TreeNode p = lastList.get(0);
            p.left = t;
            num = 1;
        }
        return root;
    }
}
