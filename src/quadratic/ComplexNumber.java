package quadratic;

import java.util.Objects;

public class ComplexNumber
{
    private double real;
    private double imaginary;

    public ComplexNumber()
    {
        real = 0;
        real = 0;
    }

    public ComplexNumber(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
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
            return real + " + " + "0.0i";
        }

        if (real == 0)
        {
            if (imaginary < 0)
            {
                return "0.0" + " - " + (-imaginary) + "i";
            }
            else
            {
                return "0.0" + " + " + imaginary + "i";
            }
        }

        if (imaginary < 0)
        {
            return real + " - " + (-imaginary) + "i";
        }
        else
        {
            return real + " + " + imaginary + "i";
        }
    }
}
