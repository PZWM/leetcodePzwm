package cn.uuusee.pzwm;

/**
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 * <p>
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 * <p>
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 * <p>
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No995 {
    //思路1：肯定是从前到后去翻转，如果翻转到最后K位不能够成为目标数组直接返回-1
    public int minKBitFlips1(int[] A, int K) {
        int index = 0;
        int time = 0;
        while (index + K <= A.length) {
            if (A[index] == 1) {
                index++;
                continue;
            }
            flip(A, K, index);
            time++;
        }
        if (index < A.length) {
            for (int i = index; i < A.length; i++) {
                if (A[i] == 0)
                    return -1;
            }
        }
        return time;
    }

    private void flip(int[] A, int K, int index) {
        for (int i = 0; i < K; i++) {
            if (A[index + i] == 0) {
                A[index + i] = 1;
            } else
                A[index + i] = 0;
        }

    }
    //结论：估计是可行的，但是时间超时了。

    //思路2：翻转时将1翻转成0肯定是要经过2次翻转的，直接记录坐标并跳过中间
    public int minKBitFlips2(int[] A, int K) {
        for (int i = 0; i < A.length; i++) {
            System.out.println("A["+i+"]="+A[i]);
        }
        int index = 0;
        int time = 0;
        while (index + K <= A.length) {
            if (A[index] == 1) {
                index++;
                continue;
            }
            int re = flip2(A, K, index);
            if (re != 0)
                index = re;
            time++;
        }
        if (index < A.length) {
            for (int i = index; i < A.length; i++) {
                if (A[i] == 0)
                    return -1;
            }
        }
        return time;
    }

    private int flip2(int[] A, int K, int index) {
        int re = 0;
        for (int i = 0; i < K; i++) {
            if (A[index + i] == 0) {
                A[index + i] = 1;
            } else {
                A[index + i] = 0;
                if (re == 0)
                    re = index + i;
            }
        }
        return re;

    }


    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }

}
