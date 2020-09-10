package cn.uuusee.pzwm;

public class No636Test {
    public static void main(String[] args) {
        int[] rec1 = new int[]{0, 0, 2, 2}, rec2 = new int[]{1, 1, 3, 3};
        System.out.println(new No836().isRectangleOverlap(rec1, rec2));
        rec1 = new int[]{0, 0, 1, 1};
        rec2 = new int[]{1, 0, 2, 1};
        System.out.println(new No836().isRectangleOverlap(rec1, rec2));
    }
}
