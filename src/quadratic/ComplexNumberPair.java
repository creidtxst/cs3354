package quadratic;

public class ComplexNumberPair
{
    private ComplexNumber complexNumber1;
    private ComplexNumber complexNumber2;

    /**
     * Default constructor
     */
    public ComplexNumberPair()
    {
        complexNumber1 = new ComplexNumber();
        complexNumber2 = new ComplexNumber();
    }

    /**
     * Constructor
     * @param complexNumber1 the first complex number
     * @param complexNumber2 the second complex number
     */
    public ComplexNumberPair(ComplexNumber complexNumber1, ComplexNumber complexNumber2)
    {
        this.complexNumber1 = complexNumber1;
        this.complexNumber2 = complexNumber2;
    }

    public ComplexNumber getComplexNumber1()
    {
        return complexNumber1;
    }

    public void setComplexNumber1(ComplexNumber complexNumber1)
    {
        this.complexNumber1 = complexNumber1;
    }

    public ComplexNumber getComplexNumber2()
    {
        return complexNumber2;
    }

    public void setComplexNumber2(ComplexNumber complexNumber2)
    {
        this.complexNumber2 = complexNumber2;
    }

    @Override
    public String toString()
    {
        return "ComplexNumberPair{" +
                "complexNumber1=" + complexNumber1 +
                ", complexNumber2=" + complexNumber2 +
                '}';
    }
}
