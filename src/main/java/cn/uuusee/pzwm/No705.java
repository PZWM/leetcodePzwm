package cn.uuusee.pzwm;

import java.util.HashSet;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No705 {


    static class No705A {
        /*
        思路1：
        直接使用HashSet。开个玩笑，试试而已
        执行用时：19 ms, 在所有 Java 提交中击败了68.62%的用户
        内存消耗：46.7 MB, 在所有 Java 提交中击败了31.29%的用户
        结果我发现HashSet底层是使用hashmap实现的。那还不如直接用hashmap喽
         */
        static class MyHashSet {

            HashSet<Integer> hashset;

            /**
             * Initialize your data structure here.
             */
            public MyHashSet() {
                hashset = new HashSet<>();
            }

            public void add(int key) {
                hashset.add(key);
            }

            public void remove(int key) {
                hashset.remove(key);
            }

            /**
             * Returns true if this set contains the specified element
             */
            public boolean contains(int key) {
                return hashset.contains(key);
            }
        }
    }
    static class No705B {
        /*
        思路2：
        我干嘛要hash，我直接用二维数组试试
        执行用时：16 ms, 在所有 Java 提交中击败了97.37%的用户
        内存消耗：46 MB, 在所有 Java 提交中击败了49.53%的用户
         */
        static class MyHashSet {

            private int[][] ints=new int[1024][0];

            /**
             * Initialize your data structure here.
             */
            public MyHashSet() {

            }

            public void add(int key) {
                int[] a=ints[key/1024];
                if(a.length==0){
                    a=new int[1024];
                }
                a[key%1024]=1;
                ints[key/1024]=a;
            }

            public void remove(int key) {
                int[] a=ints[key/1024];
                if(a.length==0){
                    return;
                }
                a[key%1024]=0;
            }

            /**
             * Returns true if this set contains the specified element
             */
            public boolean contains(int key) {
                int[] a=ints[key/1024];
                if(a.length==0){
                    return false;
                }
                return a[key%1024]!=0;
            }
        }
    }
}
