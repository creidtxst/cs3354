package test1;

import util.TestUtil;
public class RecursionTest
{
    public static void main(String[] args)
    {
        RecursionTest.test01();
        RecursionTest.test02();
        RecursionTest.test03();
    }

    private static void test01()
    {
        Recursion warmUp01 = new Recursion();
        String name = "RecursionTest.test01";
        int in = 2;
        int expectedOut = 3;
        int out = warmUp01.addNums(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test02()
    {
        Recursion warmUp01 = new Recursion();
        String name = "RecursionTest.test02";
        int in = 5;
        int expectedOut = 15;
        int out = warmUp01.addNums(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test03()
    {
        Recursion warmUp01 = new Recursion();
        String name = "RecursionTest.test03";
        int in = 256;
        int expectedOut = 32896;
        int out = warmUp01.addNums(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }
}
