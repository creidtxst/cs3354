package AssignmentA;

import assignmentA.AssignmentA01;
import quadratic.ComplexNumberPair;

public class AssignmentA01Test
{
    public static void main(String[] args)
    {
        AssignmentA01Test.test01();
        AssignmentA01Test.test02();
        AssignmentA01Test.test03();
    }

    private static void test01()
    {
        String name = "AssignmentA01Test.test01";
        double a = 1;
        double b = 6;
        double c = -14;

        /*
            Solution:
            -3 +- sqrt(23)
            -3 +- 4.7958315233
         */

        ComplexNumberPair complexNumberPair = AssignmentA01.run(a, b, c);
        System.out.print(complexNumberPair.toString() + "\n");

        try
        {
//            TestUtil.runTest(name, in, out, expectedOut);

        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test02()
    {
        String name = "AssignmentA01Test.test02";
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
//            TestUtil.runTest(name, in, out, expectedOut);
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
//            TestUtil.runTest(name, in, out, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test04()
    {
        AssignmentA01 assignment01 = new AssignmentA01();
        String name = "AssignmentA01Test.test04";
        double a = 1;
        double b = 1;
        double c = 1;

        try
        {
//            TestUtil.runTest(name, in, out, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test05()
    {
        AssignmentA01 assignment01 = new AssignmentA01();
        String name = "AssignmentA01Test.test05";
        double a = 1;
        double b = 1;
        double c = 1;

        try
        {
//            TestUtil.runTest(name, in, out, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test06()
    {
        AssignmentA01 assignment01 = new AssignmentA01();
        String name = "AssignmentA01Test.test06";
        double a = 1;
        double b = 1;
        double c = 1;

        try
        {
//            TestUtil.runTest(name, in, out, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test07()
    {
        AssignmentA01 assignment01 = new AssignmentA01();
        String name = "AssignmentA01Test.test07";
        double a = 1;
        double b = 1;
        double c = 1;

        try
        {
//            TestUtil.runTest(name, in, out, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test08()
    {
        AssignmentA01 assignment01 = new AssignmentA01();
        String name = "AssignmentA01Test.test08";
        double a = 1;
        double b = 1;
        double c = 1;

        try
        {
//            TestUtil.runTest(name, in, out, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }
}
