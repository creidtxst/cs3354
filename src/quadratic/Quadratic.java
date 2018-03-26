package quadratic;

public class Quadratic
{
    private double a;
    private double b;
    private double c;

    /**
     * Default constructor
     */
    public Quadratic()
    {
        a = 0;
        b = 0;
        c = 0;
    }

    /**
     * Constructor
     *
     * @param a
     * @param b
     * @param c
     */
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

    /**
     * Solves the quadratic equation for a, b, c
     *
     * @return the roots of the solution
     */
    public ComplexNumberPair solve()
    {
        double realRoot;
        double imaginaryRoot;
        boolean isImaginary = false;

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
            realRoot = -b / (2 * a);
            // Flip the sign of the negative discriminant
            imaginaryRoot = Math.sqrt(-discriminant) / (2 * a);
            isImaginary = true;
        }

        ComplexNumberPair complexNumberPair = new ComplexNumberPair(new ComplexNumber(realRoot, imaginaryRoot, isImaginary), new ComplexNumber(realRoot, -imaginaryRoot, isImaginary));

        return complexNumberPair;
    }
}
