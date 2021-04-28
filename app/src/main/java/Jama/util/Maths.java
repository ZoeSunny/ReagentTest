package Jama.util;

public class Maths
{
    public static double hypot(double abs, double abs2) {
        double n = 0.0;
        if (Math.abs(abs) > Math.abs(abs2)) {
            abs2 /= abs;
            abs = Math.abs(abs);
            n = Math.sqrt(abs2 * abs2 + 1.0) * abs;
        }
        else if (abs2 != 0.0) {
            abs /= abs2;
            abs2 = Math.abs(abs2);
            return Math.sqrt(abs * abs + 1.0) * abs2;
        }
        return n;
    }
}
