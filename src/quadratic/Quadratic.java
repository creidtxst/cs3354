package quadratic;

import java.util.Objects;

public class Quadratic
{
    private double a;
    private double b;
    private double c;

    public Quadratic()
    {
        a = 0;
        b = 0;
        c = 0;
    }

    public Quadratic(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA()
    {
        return a;
    }

    public void setA(double a)
    {
        this.a = a;
    }

    public double getB()
    {
        return b;
    }

    public void setB(double b)
    {
        this.b = b;
    }

    public double getC()
    {
        return c;
    }

    public void setC(double c)
    {
        this.c = c;
    }

    public ComplexNumberPair solve()
    {
        double realRoot;
        double imaginaryRoot;
        boolean isSpecialCase = false;

        // Value underneath the square root
        double discriminant = Math.pow(b, 2) - (4 * a * c);

        // Case 1: discriminant is equal to zero
        if (discriminant == 0)
        {
            realRoot = -b / (2 * a);
            imaginaryRoot = 0;
        }
        // Case 2: discriminant is positive
        else if (discriminant > 0)
        {
            realRoot = -b / (2 * a);
            imaginaryRoot = Math.sqrt(discriminant) / (2 * a);
        }
        // Case 3: discriminant is negative
        else
        {
            isSpecialCase = true;
            realRoot = -b / (2 * a);
            imaginaryRoot = -discriminant;
        }

        ComplexNumber complexNumber1;
        ComplexNumber complexNumber2;

        if (isSpecialCase)
        {
            complexNumber1 = new ComplexNumber(realRoot, imaginaryRoot, isSpecialCase, (2 * a));
            complexNumber2 = new ComplexNumber(realRoot, -imaginaryRoot, isSpecialCase, (2 * a));
        }
        else
        {
            complexNumber1 = new ComplexNumber(realRoot, imaginaryRoot);
            complexNumber2 = new ComplexNumber(realRoot, -imaginaryRoot);
        }

        ComplexNumberPair complexNumberPair = new ComplexNumberPair(complexNumber1, complexNumber2);

        return complexNumberPair;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadratic quadratic = (Quadratic) o;
        return Double.compare(quadratic.a, a) == 0 &&
                Double.compare(quadratic.b, b) == 0 &&
                Double.compare(quadratic.c, c) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString()
    {
        String equation = a + "x^2 ";

        if (b < 0)
        {
            equation += (" - " + (-b) + "x ");
        }
        else
        {
            equation += (" + " + b + "x ");
        }

        if (c < 0)
        {
            equation += (" - " + (-c));
        }
        else
        {
            equation += (" + " + c);
        }

        equation += " = 0.0";

        return equation;
    }
}
