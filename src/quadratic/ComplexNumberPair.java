package quadratic;

import java.util.Objects;

public class ComplexNumberPair
{
    private ComplexNumber complexNumber1;
    private ComplexNumber complexNumber2;

    public ComplexNumberPair()
    {
        complexNumber1 = new ComplexNumber();
        complexNumber2 = new ComplexNumber();
    }

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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumberPair that = (ComplexNumberPair) o;
        return Objects.equals(complexNumber1, that.complexNumber1) &&
                Objects.equals(complexNumber2, that.complexNumber2);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(complexNumber1, complexNumber2);
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
