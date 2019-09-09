package cn.uuusee.pzwm;

public class No592 {
    public String fractionAddition(String expression) {
        char[] chars = expression.toCharArray();
        String newNum = "";
        boolean isAdd = true;
        for (char c : chars) {

            if (c == '-') {
                if (!newNum.isEmpty()) {
                    if (isAdd) {
                        addNum(newNum);
                    } else {
                        subNum(newNum);
                    }
                }
                isAdd = false;
                newNum = "";
            } else if (c == '+') {
                if (!newNum.isEmpty()) {
                    if (isAdd) {
                        addNum(newNum);
                    } else {
                        subNum(newNum);
                    }
                }
                isAdd = true;
                newNum = "";
            } else {
                newNum = newNum + c;
            }
        }
        if (isAdd) {
            addNum(newNum);
        } else {
            subNum(newNum);
        }
        tongfen();
        return result;
    }

    private void tongfen() {
        String[] frac = result.split("/");
        int a = Integer.parseInt(frac[0]);
        int b = Integer.parseInt(frac[1]);
        if (a == 0 )
            result = "0/1";
        int min = a;
        if (a > b) {
            min = b;
        }
        if(min<0)
            min=-min;
        for (int i = min; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                result = (a / i) + "/" + (b / i);
                break;
            }
        }
    }

    private String result = "0/0";

    private void subNum(String newNum) {
        String ori = result;
        String[] frac = result.split("/");
        String[] frac1 = newNum.split("/");
        if (frac[1].equals("0"))
            frac[1] = "1";
        if (frac1[1].equals("0"))
            frac1[1] = "1";
        result = (Integer.parseInt(frac[0]) * Integer.parseInt(frac1[1]) - Integer.parseInt(frac1[0]) * Integer.parseInt(frac[1])) + "/" + (Integer.parseInt(frac[1]) * Integer.parseInt(frac1[1]));
        tongfen();
        System.out.println(ori + "-" + newNum + "=" + result);
    }

    private void addNum(String newNum) {
        String ori = result;
        String[] frac = result.split("/");

        String[] frac1 = newNum.split("/");

        if (frac[1].equals("0"))
            frac[1] = "1";
        if (frac1[1].equals("0"))
            frac1[1] = "1";

        result = (Integer.parseInt(frac[0]) * Integer.parseInt(frac1[1]) + Integer.parseInt(frac1[0]) * Integer.parseInt(frac[1])) + "/" + (Integer.parseInt(frac[1]) * Integer.parseInt(frac1[1]));
        tongfen();
        System.out.println(ori + "+" + newNum + "=" + result);
    }

    public static void main(String[] args) {
        String expression = "-1/4-4/5-1/4";
        No592 no592 = new No592();
        System.out.println(expression + "=" + no592.fractionAddition(expression));
    }
}
