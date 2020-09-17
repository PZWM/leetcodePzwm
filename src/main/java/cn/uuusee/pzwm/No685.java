package cn.uuusee.pzwm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 * 1
 * / \
 * v   v
 * 2-->3
 * 示例 2:
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * 注意:
 * <p>
 * 二维数组大小的在3到1000范围内。
 * 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//TODO 确实很难
public class No685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        //遍历全部数组形成🌲
        Map<Integer, Node> map = new HashMap<>();
        for (int[] ii : edges) {
            Node node = map.get(ii[0]);
            if (node == null) {
                node = new Node(ii[0]);
                map.put(ii[0], node);
            }
            Node son = map.get(ii[1]);
            if (son == null) {
                son = new Node(ii[1]);
                map.put(ii[1], son);
            }
            son.father.add(node);
            node.son.add(son);
        }
        //找到打到父节点导致有根树出错的情况
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if (entry.getValue().father.size() > 1) {
                //如果存在，那么结果必定在该节点的两个父级中

                //向上走路过了自己，直接能够确定是当前父级是该被删除的
                Node my = entry.getValue();
                Node root1 = my.father.get(0);
                int i1 = 0, i2 = 0;
                while (true) {
                    i1++;
                    if (root1.equals(my))
                        return new int[]{my.father.get(0).val, my.val};
                    if (root1.father.size() > 0)
                        root1 = root1.father.get(0);
                    else
                        break;
                }
                Node root2 = my.father.get(1);
                while (true) {
                    i2++;
                    if (root2.equals(my))
                        return new int[]{my.father.get(1).val, my.val};
                    if (root2.father.size() > 0)
                        root2 = root2.father.get(0);
                    else
                        break;
                }

                //如果向上走根节点为同一个，删除路径短的，因为存在跳过了某些节点。
                //也可能存在某一个父级指向另一个父级，这种情况是删除任意都可以
                if(i1==i2|| (my.father.get(0).father.size()>0&& my.father.get(0).father.get(0)==my.father.get(1))|| (my.father.get(1).father.size()>0&& my.father.get(1).father.get(0)==my.father.get(0))){

                    //TODO 还需要考虑是不是没有跳过而是重复了某些节点
                    List<String> list = new ArrayList<>();
                    list.add(my.val+","+my.father.get(0).val);
                    list.add(my.val+","+my.father.get(1).val);

                    for (int i = edges.length - 1; i > -1; i--) {
                        if (list.contains(edges[i][1]+","+edges[i][0])) {
                            return edges[i];
                        }
                    }

                }
                if (i1 > i2) {
                    return new int[]{my.father.get(1).val, my.val};
                }
                return new int[]{my.father.get(0).val, my.val};
            }
        }

        //没有根节点说明出现闭环
        List<Node> root = new ArrayList<>();
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if (entry.getValue().father.size() == 0) {
                //如果存在，那么这个节点必定为根节点。
                root.add(entry.getValue());
            }
        }
        //两个根节点，说明有一个是可以删除的
        //该情况只在上面的两个父类下存在。

        if (root.size() == 0) {
            //闭环，那么断掉环上最后一个出现的node即可。
            Node tn = map.entrySet().iterator().next().getValue();
            List<Node> list = new ArrayList<>();
            while (!list.contains(tn)) {
                list.add(tn);
                tn = tn.father.get(0);
            }
            list = new ArrayList<>();
            while (!list.contains(tn)) {
                list.add(tn);
                tn = tn.father.get(0);
            }
            for (int i = edges.length - 1; i > -1; i--) {
                if (list.contains(map.get(edges[i][1]))) {
                    return edges[i];
                }
            }
        }

        //非闭环情况，也不存在多个，只能拿叶子节点去删除，就是没有子级的


        return null;
    }

}

class Node {

    public List<Node> father = new ArrayList<>();

    public List<Node> son = new ArrayList<>();

    public Integer val;


    public Node(Integer i) {
        val = i;
    }
}