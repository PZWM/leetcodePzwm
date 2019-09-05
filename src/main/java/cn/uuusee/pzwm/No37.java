package cn.uuusee.pzwm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class No37 {
    /*编写一个程序，通过已填充的空格来解决数独问题。

    一个数独的解法需遵循如下规则：

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    空白格用 '.' 表示。
    Note:

    给定的数独序列只包含数字 1-9 和字符 '.' 。
    你可以假设给定的数独只有唯一解。
    给定数独永远是 9x9 形式的。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/sudoku-solver
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public void solveSudoku(char[][] board) {
        boolean isLeaveDot = true;
        List<Character> choose1;
        List<Character> choose2;
        List<Character> choose3;
        int max = 80, curr = 0;
        while (isLeaveDot) {
            if (max < curr)
                return;
            curr++;
            isLeaveDot = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        isLeaveDot = true;
                        choose1 = createStandard();
                        choose2 = createStandard();
                        for (int k = 0; k < 9; k++) {
                            choose1.remove((Character) board[i][k]);
                            choose1.remove((Character) board[k][j]);
                        }
                        int a1 = i % 3, a2 = j % 3;
                        a1 = i - a1;
                        a2 = j - a2;
                        for (int k = 0; k < 3; k++) {
                            for (int l = 0; l < 3; l++) {
                                choose2.remove((Character) board[a1 + k][a2 + l]);
                            }
                        }
                        choose3 = new ArrayList<>();
                        for (Character c : choose1) {
                            if (choose2.contains(c))
                                choose3.add(c);
                        }

                        if (choose3.size() == 1)
                            board[i][j] = choose3.get(0);
                        else if (curr > 1&&choose3.size()>0)
                            board[i][j] = choose3.get(0);
                    }

                }
            }
        }
    }

    private List<Character> createStandard() {
        List<Character> l = new ArrayList<>();
        l.add('1');
        l.add('2');
        l.add('3');
        l.add('4');
        l.add('5');
        l.add('6');
        l.add('7');
        l.add('8');
        l.add('9');
        return l;
    }

    public static void main(String[] args) {
        String input = "[[\".\",\".\",\"9\",\"7\",\"4\",\"8\",\".\",\".\",\".\"],[\"7\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"2\",\".\",\"1\",\".\",\"9\",\".\",\".\",\".\"],[\".\",\".\",\"7\",\".\",\".\",\".\",\"2\",\"4\",\".\"],[\".\",\"6\",\"4\",\".\",\"1\",\".\",\"5\",\"9\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\"3\",\".\",\".\"],[\".\",\".\",\".\",\"8\",\".\",\"3\",\".\",\"2\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\"6\"],[\".\",\".\",\".\",\"2\",\"7\",\"5\",\"9\",\".\",\".\"]]";
        List<char[]> l = JSON.parseArray(input, char[].class);
        char[][] board = new char[9][9];
        l.toArray(board);
        print(board);
        No37 no37 = new No37();
        no37.solveSudoku(board);
        print(board);
    }

    private static void print(char[][] board) {
        for (char[] c : board
        ) {

            System.out.print("|");
            for (char a : c
            ) {
                System.out.print(a + "|");
            }
            System.out.println("");
        }
    }
}
