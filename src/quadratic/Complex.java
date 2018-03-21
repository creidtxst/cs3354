package quadratic;

import java.util.Objects;

public class Complex {

    private String iRoot1;
    private String iRoot2;

    public Complex(double real, double imaginary) {

        this.iRoot1 = String.format("iRoot1: %.2f + %.2fi", real, imaginary);
        this.iRoot1 = String.format("iRoot1: %.2f - %.2fi", real, imaginary);
    }

    public String getiRoot1() {
        return this.iRoot1;
    }

    public String getiRoot2() {
        return this.iRoot2;
    }
}