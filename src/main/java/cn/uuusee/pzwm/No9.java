package cn.uuusee.pzwm;

public class No9 {
    public boolean isPalindrome(int x) {
        String s = x + "";
        int sl = s.length();
        for (int i = 0; i < sl / 2; i++) {
            if (s.charAt(i) != s.charAt(sl -1- i)) {
                return false;
            }
        }
        return true;
    }
}
