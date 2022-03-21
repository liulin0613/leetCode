package free.t0314.angle_between_hands_of_a_clock;

/**
 * https://leetcode-cn.com/problems/angle-between-hands-of-a-clock/
 *
 * 1344. 时钟指针的夹角
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int hour = 1;
        int minutes = 50;

        System.out.println(angleClock(hour, minutes));
    }

    public static double angleClock(int hour, int minutes) {
        double angle1 = (hour % 12) * 30. + (minutes / 60.) * 30;
        double angle2 = ((minutes % 60) / 60.) * 360;

        double res = Math.abs(angle2 - angle1);
        return res > 180 ? 360 - res : res;
    }
}
