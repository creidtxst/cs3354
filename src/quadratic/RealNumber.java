package quadratic;

import java.util.Objects;

public class RealNumber {

    private double Root1;
    private double Root2;

    public RealNumber(double a, double b, double c, double det) {

        this.Root1 = (-b + Math.sqrt(det)) / (2 * a);
        this.Root2 = (-b - Math.sqrt(det)) / (2 * a);
    }

    public double getRoot1() {
        return this.Root1;
    }

    public double getRoot2() {
        return this.Root2;
    }
}