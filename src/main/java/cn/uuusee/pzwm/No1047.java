package cn.uuusee.pzwm;

public class No1047 {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int re = 0;
        for (int i = 0; i < chars.length; i++) {
            if (re == i)
                continue;
            if (chars[re] == chars[i]) {
                chars[re] = ' ';
                chars[i] = ' ';
            } else {
                re = i;
            }
            while (re > 0 && chars[re] == ' ') {
                re--;
            }
        }
        return new String(chars).replace(" ", "");
    }

    public static void main(String[] args) {
        System.out.println(new No1047().removeDuplicates("abbaca"));
    }
}
