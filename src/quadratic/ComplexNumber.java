package quadratic;

public class ComplexNumber
{
    private double real;
    private double imaginary;
    private boolean isSpecialCase;  // negative discriminant
    private double specialCaseDenominator;

    /**
     * Constructor
     */
    public ComplexNumber()
    {
        real = 0;
        real = 0;
    }

    /**
     * Constructor
     * @param real the real root
     * @param imaginary the imaginary root
     */
    public ComplexNumber(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
        this.isSpecialCase = false;
    }

    /**
     * Constructor
     * @param real the real root
     * @param imaginary the imaginary root
     * @param isSpecialCase whether or not the determinant is negative
     * @param specialCaseDenominator the denominator to use in the special case
     */
    public ComplexNumber(double real, double imaginary, boolean isSpecialCase, double specialCaseDenominator)
    {
        this.real = real;
        this.imaginary = imaginary;
        this.isSpecialCase = isSpecialCase;
        this.specialCaseDenominator = specialCaseDenominator;
    }

    public double getReal()
    {
        return real;
    }

    public void setReal(double real)
    {
        this.real = real;
    }

    public double getImaginary()
    {
        return imaginary;
    }

    public void setImaginary(double imaginary)
    {
        this.imaginary = imaginary;
    }

    public boolean isReal()
    {
        return imaginary == 0;
    }

    public boolean isSpecialCase()
    {
        return isSpecialCase;
    }

    public void setSpecialCase(boolean specialCase)
    {
        isSpecialCase = specialCase;
    }

    public double getSpecialCaseDenominator()
    {
        return specialCaseDenominator;
    }

    public void setSpecialCaseDenominator(double specialCaseDenominator)
    {
        this.specialCaseDenominator = specialCaseDenominator;
    }

    @Override
    public String toString()
    {
        if (imaginary == 0)
        {
            return real + " + " + "0.0";
        }

        if (real == 0)
        {
            if (imaginary < 0)
            {
                if (isSpecialCase)
                {
                    return "0.0" + " - i sqrt(" + (imaginary) + ") / " + specialCaseDenominator;
                }
                else
                {
                    return "0.0" + " - " + (-imaginary);
                }
            }
            else
            {
                if (isSpecialCase)
                {
                    return "0.0" + " + i sqrt(" + -imaginary + ") / " + specialCaseDenominator;
                }
                else
                {
                    return "0.0" + " + " + imaginary;
                }
            }
        }

        if (imaginary < 0)
        {
            if (isSpecialCase)
            {
                return real + " - i sqrt(" + (imaginary) + ") / " + specialCaseDenominator;
            }
            else
            {
                return real + " - " + (-imaginary);
            }
        }
        else
        {
            if (isSpecialCase)
            {
                return real + " + i sqrt(" + -imaginary + ") / " + specialCaseDenominator;
            }
            else
            {
                return real + " + " + imaginary;
            }
        }
    }
}
