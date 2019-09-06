package cn.uuusee.pzwm;

import cn.uuusee.pzwm.utils.MathUtils;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class No37 extends JFrame {
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


    public void solveSudoku(char[][] board) throws Exception {
        boolean isLeaveDot = true, isModify = false;
        List<Character> choose1;
        List<Character> choose2;
        List<Character> choose3;
        while (isLeaveDot && !isModify) {
            isLeaveDot = false;
            isModify = false;
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

                        if (choose3.size() == 1) {
                            board[i][j] = choose3.get(0);
                            isModify = true;
                        } else {
                            cache.put(i + "" + j, choose3.toArray(new Character[0]));
                        }
                    }

                }
            }
        }
        print(board);
        //已经没有办法处理
        if (isLeaveDot) {
            board = mySolve(board);
        }
    }

    List<Integer[]> noRepeat = new ArrayList<>();

    HashMap<String, Integer> local = new HashMap<>();

    HashMap<String, Character[]> cache = new HashMap<>();

    HashMap<Integer, Integer[]> canChoose = new HashMap<>();


    //暴力法。
    private char[][] mySolve(char[][] board) throws Exception {

        //检查还剩下多少个.同时列出所有的位置
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int strIndex = sb.length();
                    local.put(i + "" + j, strIndex);
                    sb.append("1");
                    Character[] ca = cache.get(i + "" + j);
                    Integer[] integers = new Integer[ca.length];
                    for (int k = 0; k < integers.length; k++) {
                        integers[k] = Character.getNumericValue(ca[k]);
                    }
                    canChoose.put(strIndex, integers);
                }
            }
        }
        cache = null;
        for (int i = 0; i < 9; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    list.add(local.get(i + "" + j));
                }
            }
            if (list.size() > 1)
                noRepeat.add(list.toArray(new Integer[0]));
        }
        for (int j = 0; j < 9; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    list.add(local.get(i + "" + j));
                }
            }
            if (list.size() > 1)
                noRepeat.add(list.toArray(new Integer[list.size()]));
        }

        String re = sb.toString();
        num = re;
        char[][] c = board.clone();
        while (!checkArray(c)) {
            //填充值
            int n = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        c[i][j] = re.charAt(n++);
                    }
                }
            }
            //更新值
            re = getNoRepeatAI(-1);
            int repeatRe = checkRepeat(re);
            while (repeatRe != -1) {
                re = getNoRepeatAI(repeatRe);
                repeatRe = checkRepeat(re);
            }
            System.out.println("已经检查" + re);
        }
        return c;
    }

    String num;
    List<String> results = new ArrayList<>();

    private String getNoRepeatAI(int index) throws Exception {
        String r = getTrans();
        num = diyNumberAutoInc(index);
        System.out.println("num" + num);
        return r;
    }

    private String getTrans() {
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int a = Character.getNumericValue(chars[i]);
            Integer[] tCan = canChoose.get(i);
            chars[i] = (char) (tCan[a - 1] + 48);
        }
        return new String(chars);
    }

    private String diyNumberAutoInc(int index) throws Exception {
        char[] chars = num.toCharArray();
        if (index == -1)
            index = chars.length - 1;
        boolean isNeedProcess = false, first = true;
        while (first || isNeedProcess) {
            if (index == -1)
                break;
            first = false;
            int a = Character.getNumericValue(chars[index]) + 1;
            if (isNeedProcess)
                a++;
            Integer[] tCan = canChoose.get(index);
            if (a > tCan.length) {
                a = a - tCan.length;
                chars[index] = (char) (a + 48);
                isNeedProcess = true;
            } else {
                chars[index] = (char) (a + 48);
                isNeedProcess = false;
            }
            index--;
        }
//        if(isNeedProcess)
//            throw new Exception("重复校验");
        return new String(chars);
    }

    private void recordResults() {
        for (Integer a : canChoose.get(1)) {
            results.add(a + "");
        }
        for (int i = 1; i < canChoose.size(); i++) {
            results = dikaer(canChoose.get(i));
            System.out.println("数据准备" + i);
        }
    }

    private List<String> dikaer(Integer[] aa) {
        List<String> r = new ArrayList<>();
        for (Integer a : aa) {
            for (String s : results) {
                r.add(s + a);
            }
        }
        return r;

    }


    private int checkRepeat(String re) {
        List<Character> cs = new ArrayList<>();
        for (Integer[] ii : noRepeat) {
            for (Integer i : ii) {
                Character c = re.charAt(i);
                int repeatIndex = -1;
                if (cs.contains(c)) {
                    repeatIndex = i;
                }

                cs.add(c);
                if (repeatIndex > 0)
                    return repeatIndex;
            }
        }
        return -1;
    }

    private boolean checkArray(char[][] a) {
        //检查行
        for (int i = 0; i < 9; i++) {
            List<Character> standard = createStandard();
            for (int j = 0; j < 9; j++) {
                standard.remove((Character) a[i][j]);
            }
            if (standard.size() != 0)
                return false;
        }

        //检查列
        for (int i = 0; i < 9; i++) {
            List<Character> standard = createStandard();
            for (int j = 0; j < 9; j++) {
                standard.remove((Character) a[j][i]);
            }
            if (standard.size() != 0)
                return false;
        }
        //九宫格检查
        for (int i = 0; i < 3; i++) {
            int xmin = i * 3, xmax = 3 + i * 3;
            for (int o = 0; o < 3; o++) {
                int ymin = o * 3, ymax = 3 + o * 3;
                List<Character> standard = createStandard();
                for (int k = xmin; k < xmax; k++) {
                    for (int j = ymin; j < ymax; j++) {
                        standard.remove((Character) a[j][k]);
                    }
                }
                if (standard.size() != 0)
                    return false;
            }

        }


        return true;
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

    public static void main(String[] args) throws Exception {
        String input = "[[\".\",\".\",\"9\",\"7\",\"4\",\"8\",\".\",\".\",\".\"],[\"7\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"2\",\".\",\"1\",\".\",\"9\",\".\",\".\",\".\"],[\".\",\".\",\"7\",\".\",\".\",\".\",\"2\",\"4\",\".\"],[\".\",\"6\",\"4\",\".\",\"1\",\".\",\"5\",\"9\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\"3\",\".\",\".\"],[\".\",\".\",\".\",\"8\",\".\",\"3\",\".\",\"2\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\"6\"],[\".\",\".\",\".\",\"2\",\"7\",\"5\",\"9\",\".\",\".\"]]";
        List<char[]> l = JSON.parseArray(input, char[].class);
        char[][] board = new char[9][9];
        l.toArray(board);
        No37 no37 = new No37();
        no37.print(board);
        Date date = new Date();
        no37.solveSudoku(board);
        System.out.println("----------------------------------------------------");
        no37.print(board);
        System.out.println((new Date().getTime() - date.getTime()) / 1000 + "秒");
    }

    private void print(char[][] board) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><table>");
        for (char[] c : board
        ) {
            sb.append("<tr>");
            System.out.print("|");
            for (char a : c
            ) {
                System.out.print(a + "|");
                sb.append("<td>" + a + "</td>");
            }
            System.out.println("");
            sb.append("</tr>");
        }
        sb.append("</table></html>");
        displayArea.setText(sb.toString());
    }

    private JLabel displayArea = new JLabel();

    public No37() {
        this.add(displayArea);

        this.setLayout(new GridLayout(4, 1)); //选择GridLayout布局管理器
        this.setTitle("学生成绩管理系统");
        this.setSize(500, 500);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置当关闭窗口时，保证JVM也退出
        this.setVisible(true);
        this.setResizable(true);

    }
}
