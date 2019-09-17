package cn.uuusee.pzwm;

public class No190 {


    /*
    * 颠倒给定的 32 位无符号整数的二进制位。

 

示例 1：

输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
示例 2：

输入：11111111111111111111111111111101
输出：10111111111111111111111111111111
解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
      因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
 

提示：

请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 

进阶:
如果多次调用这个函数，你将如何优化你的算法？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-bits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return reverse(n);
    }

    public  int reverse(int i) {
        //将32位二进制位以8位为一个单元编号1-8

        //16进制5的二进制0101
        //前半段取2、4、6、8位，直接左移一位，用2468替换1357位
        //后半段直接右移一位，并取2468位。
        //以8位为一个单元，现在编号依据原位置变成21436587
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;


        //16进制3的二进制表现形式是0011
        //该计算后43218765
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;

        //16进制f的二进制表现形式为1111
        //计算得出87654321
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        return reverseBytes(i);
    }

    public  int reverseBytes(int i) {
       /* i>>>24右移24位，前8位变成后8位（1-8变成24-32）
        i右移8位 并& 0xff00取32位中16-24位（8-16变16-24）
        i左移8位，并取8-16位（16-24变8-16）
        i左移24位(24-32变1-8)*/
        return ((i >>> 24)           ) |
                ((i >>   8) &   0xFF00) |
                ((i <<   8) & 0xFF0000) |
                ((i << 24));
    }

    public static void main(String[] args) {
        System.out.println(change("0x55555555", 16, 2));
    }


    static StringBuffer buffer = new StringBuffer();

    static String change(String value, int f, int t) {

        int sum = 0;

        char[] cs = value.toCharArray();

        for (int i = 0; i < cs.length; i++) {

            int c = (int) cs[i];

            int b = cs.length - i - 1;

            if (64 < c && c < 91) {

                sum += (c - 65 + 10) * Math.pow(f, b);

            } else if (c > 91) {

                sum += (c - 97 + 37) * Math.pow(f, b);

            } else if (c == '+') {

                sum += 63 * Math.pow(f, b);

            } else if (c == '/') {

                sum += 64 * Math.pow(f, b);

            } else {

                sum += (c - 48) * Math.pow(f, b);

            }

        }

        while (sum >= t) {

            buffer.append(sum % t);

            sum /= t;

        }

        buffer.append(sum);
        String result = buffer.reverse().toString();
        destroyBuffer();
        return result;

    }

    /**
     * 释放内存
     */

    static void destroyBuffer() {

        buffer.delete(0, buffer.length());

    }


}
