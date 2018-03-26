package quadratic;

public class ComplexNumber
{
    private double real;
    private double imaginary;
    private boolean isImaginary;

    /**
     * Constructor
     */
    public ComplexNumber()
    {
        real = 0;
        imaginary = 0;
    }

    /**
     * Constructor
     * @param real the real root
     * @param imaginary the imaginary root
     */
    public ComplexNumber(double real, double imaginary, boolean isImaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
        this.isImaginary = isImaginary;
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

    public boolean isImaginary()
    {
        return isImaginary;
    }

    public void setImaginary(boolean imaginary)
    {
        isImaginary = imaginary;
    }
}
