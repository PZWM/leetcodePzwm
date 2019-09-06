package cn.uuusee.pzwm.utils;

public class MathUtils {
    public static String stringNumberAutoInc(String str) {
        char[] chars = str.toCharArray();
        int index = chars.length - 1;
        boolean isNeedProcess = true;
        while (isNeedProcess) {
            int a = Character.getNumericValue(chars[index]) + 1;
            if (a > 9) {
                a = a - 10;
                chars[index] = (char) (a + 48);
            } else {
                chars[index] = (char) (a + 48);
                isNeedProcess = false;
            }
            index--;
            if (index < 0)
                return "1" + new String(chars);
        }
        return new String(chars);
    }
    public static String stringNumberAutoInc(String str,int index) {
        char[] chars = str.toCharArray();
        boolean isNeedProcess = true;
        while (isNeedProcess) {
            int a = Character.getNumericValue(chars[index]) + 1;
            if (a > 9) {
                a = a - 10;
                chars[index] = (char) (a + 48);
            } else {
                chars[index] = (char) (a + 48);
                isNeedProcess = false;
            }
            index--;
            if (index < 0)
                return "1" + new String(chars);
        }
        return new String(chars);
    }
}
