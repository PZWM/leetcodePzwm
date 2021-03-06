package cn.uuusee.pzwm;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class No338 {

    //思路1：我们直接转换成2进制的字符串，再通过字符串找出现1的次数
    public int[] countBits(int num) {
        int[] ints = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ints[i] = appearNumber(Integer.toBinaryString(i), "1");
        }
        return ints;
    }

    /**
     * public int indexOf(int ch, int fromIndex)
     * 返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
     *
     * @param srcText
     * @param findText
     * @return
     */
    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }

    //思路2，我直接从二进制开始入手，每次从0开始加，如果当前数字是2的n次方。那么清空后N位
    public int[] countBits1(int num) {
        int[] ints = new int[num + 1];
        int[] ii = new int[32];
        ii[0] = 1;
        int index = 0;
        for (int i = 0; i <= num; i++) {
            if (i > ii[index]) {
                while (i - ii[index] > ii[index]) {
                    index++;
                    if (ii[index] == 0) {
                        ii[index] = (int) Math.pow(2, index);
                    }
                }
                if (i - ii[index] == ii[index])
                    ints[i] = 1;
                else
                    ints[i] = 1 + ints[i - ii[index]];
            } else if (i == ii[index])
                ints[i] = 1;
            else ints[i] = 0;
        }
        return ints;
    }
    public int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = Integer.bitCount(i);
        }
        return bits;
    }

}
