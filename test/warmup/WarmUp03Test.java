package warmup;

public class WarmUp03Test
{
    public static void main(String[] args)
    {
        WarmUp03Test.test01();
        WarmUp03Test.test02();
        WarmUp03Test.test03();
        WarmUp03Test.test04();
        WarmUp03Test.test05();
        WarmUp03Test.test06();
        WarmUp03Test.test07();
    }

    private static void test01()
    {
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "warmup.WarmUp03Test.test01";
        int in = 1;
        int expectedOut = 3;
        int out = warmUp03.run(in);

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
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "warmup.WarmUp03Test.test02";
        int in = 2;
        int expectedOut = 18;
        int out = warmUp03.run(in);

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
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "warmup.WarmUp03Test.test03";
        int in = 3;
        int expectedOut = 57;
        int out = warmUp03.run(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test04()
    {
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "warmup.WarmUp03Test.test04";
        int in = 4;
        int expectedOut = 132;
        int out = warmUp03.run(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test05()
    {
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "warmup.WarmUp03Test.test05";
        int in = 5;
        int expectedOut = 255;
        int out = warmUp03.run(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test06()
    {
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "warmup.WarmUp03Test.test06";
        int in = 16;
        int expectedOut = 8208;
        int out = warmUp03.run(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test07()
    {
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "warmup.WarmUp03Test.test07";
        int in = 256;
        int expectedOut = 33554688;
        int out = warmUp03.run(in);

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
