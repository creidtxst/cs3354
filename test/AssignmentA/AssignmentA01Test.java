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
    }

    private static void test01()
    {
        double a = 1;
        double b = 6;
        double c = -14;

        double expectedReal = -3 + Double.valueOf(decimalFormatter.format(4.7958315233));

        /*
            Solution:
            -3 +- sqrt(23)
            -3 +- 4.7958315233
         */

        ComplexNumberPair complexNumberPair = AssignmentA01.run(a, b, c);
        System.out.print(complexNumberPair.toString() + "\n");

        try
        {
            validate("AssignmentA01Test.test01", a, b, c, 1, 2);

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
        System.out.print(complexNumberPair.toString() + "\n");

        try
        {
            validate("AssignmentA01Test.test02", a, b, c, 1, 2);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test03()
    {
        String name = "AssignmentA01Test.test03";
        double a = -5;
        double b = 3;
        double c = -11;

        /*
            Solution:
            (-3/-10) +- (sqrt(-211)/-10)
         */

        ComplexNumberPair complexNumberPair = AssignmentA01.run(a, b, c);
        System.out.print(complexNumberPair.toString() + "\n");

        try
        {
            validate("AssignmentA01Test.test03", a, b, c, 1, 2);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void validate(String name, double a, double b, double c, double p, double q) throws Exception
    {
        if (false)
        {
            throw new Exception(name + " FAILED - expected: " + 1 + " actual: " + 2 + "\n");
        }
        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("a:   " + a);
        System.out.print("\nb: " + b);
        System.out.print("\nc: " + c);
        System.out.print("\np: " + p);
        System.out.print("\nq: " + q);
        System.out.print("\n---------------------\n");
    }
}
