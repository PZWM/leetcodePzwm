package cn.uuusee.pzwm;

public class Contest5181 {

    /*
    环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。



示例 1：



输入：distance = [1,2,3,4], start = 0, destination = 1
输出：1
解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total = distance.length;
        start = start % total;
        destination = destination % total;
        int s = 0;

        int n = 0;
        if (destination == start) {
            return 0;
        }
        if (destination < start) {
            for (int i = start; i > destination; i--) {
                n += distance[i - 1];
            }

            for (int i = start; i < total; i++) {
                s += distance[i];
            }
            for (int i = 0; i < destination; i++) {
                s += distance[i];
            }

        } else {
            for (int i = start; i < destination; i++) {
                s += distance[i];
            }
            for (int i = start; i > 0; i--) {
                n += distance[i - 1];
            }
            for (int i = total; i > destination; i--) {
                n += distance[i - 1];
            }
        }
        return Math.min(n, s);
    }

    public static void main(String[] args) {
        Contest5181 contest5181 = new Contest5181();
        System.out.println(contest5181.distanceBetweenBusStops(new int[]{7, 6, 3, 0, 3}, 0, 4));
    }
}
