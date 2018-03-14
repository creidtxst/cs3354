package quadratic;

import java.util.Objects;

public class ComplexNumber
{
    private double real;
    private double imaginary;
    private boolean isSpecialCase;  // negative discriminant
    private double specialCaseDenominator;

    public ComplexNumber()
    {
        real = 0;
        real = 0;
    }

    public ComplexNumber(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
        this.isSpecialCase = false;
    }

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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.real, real) == 0 &&
                Double.compare(that.imaginary, imaginary) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(real, imaginary);
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
