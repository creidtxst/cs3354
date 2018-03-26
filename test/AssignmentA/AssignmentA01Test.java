package AssignmentA;

import assignmentA.AssignmentA01;
import quadratic.ComplexNumberPair;
import java.text.DecimalFormat;

public class AssignmentA01Test
{
    private static DecimalFormat decimalFormatter = new DecimalFormat("0.0");

    public static void main(String[] args)
    {
        AssignmentA01Test.test01();
        AssignmentA01Test.test02();
        AssignmentA01Test.test03();
        AssignmentA01Test.test04();
        AssignmentA01Test.test05();
    }

    private static void test01()
    {
        double a = 1;
        double b = 6;
        double c = -14;
        
        /*
            Solution:
            -3 +- sqrt(23)
            -3 +- 4.7958315233
         */

        ComplexNumberPair complexNumberPair = AssignmentA01.run(a, b, c);

        try
        {
            validate("AssignmentA01Test.test01", a, b, c, complexNumberPair);

        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test02()
    {
        double a = 8;
        double b = 14;
        double c = -15;

        /*
            Solution:
            (-14/16) +- (26/16)
            -0.875 +- 1.625
         */

        ComplexNumberPair complexNumberPair = AssignmentA01.run(a, b, c);

        try
        {
            validate("AssignmentA01Test.test02", a, b, c, complexNumberPair);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test03()
    {
        double a = 4;
        double b = 6;
        double c = 5;

        /*
            Solution (imaginary):
            (-3/4) +- (sqrt(11)/4 i)
         */

        ComplexNumberPair complexNumberPair = AssignmentA01.run(a, b, c);

        try
        {
            validate("AssignmentA01Test.test03", a, b, c, complexNumberPair);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test04()
    {
        double a = 2;
        double b = -7;
        double c = -5;

        /*
            Solution:
            7 +- sqrt(89)
            7 +- 9.4339811321
         */

        ComplexNumberPair complexNumberPair = AssignmentA01.run(a, b, c);

        try
        {
            validate("AssignmentA01Test.test04", a, b, c, complexNumberPair);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test05()
    {
        double a = 3;
        double b = -10;
        double c = -4;

        /*
            Solution:
            5 +- sqrt(37)
            5 +- 5.1961524227
         */

        ComplexNumberPair complexNumberPair = AssignmentA01.run(a, b, c);

        try
        {
            validate("AssignmentA01Test.test05", a, b, c, complexNumberPair);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void validate(String name, double a, double b, double c, ComplexNumberPair complexNumberPair) throws Exception
    {
        boolean isImaginary = complexNumberPair.getComplexNumber1().isImaginary() || complexNumberPair.getComplexNumber2().isImaginary();

        double p = complexNumberPair.getComplexNumber1().getReal() + complexNumberPair.getComplexNumber1().getImaginary();
        double q = complexNumberPair.getComplexNumber2().getReal() + complexNumberPair.getComplexNumber2().getImaginary();
        
        double rootSum = p + q;
        double argSum = -b / a;
        boolean isValidSum = Double.compare(Double.valueOf(decimalFormatter.format(rootSum)), Double.valueOf(decimalFormatter.format(argSum))) == 0;

        double rootProduct = p * q;
        double argProduct = c / a;
        boolean isValidProduct = Double.compare(Double.valueOf(decimalFormatter.format(rootProduct)), Double.valueOf(decimalFormatter.format(argProduct))) == 0;

        if (!isImaginary && (!isValidSum || !isValidProduct))
        {
            throw new Exception(name + " FAILED - expected: " + 1 + " actual: " + 2 + "\n");
        }
        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("a: " + a);
        System.out.print("\nb: " + b);
        System.out.print("\nc: " + c);
        System.out.print("\np: " + p);
        System.out.print("\nq: " + q);
        System.out.print("\n---------------------\n");
    }
}
