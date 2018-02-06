package warmup;

import util.TestUtil;

public class WarmUp02Test
{
    public static void main(String[] args)
    {
        WarmUp02Test.test01();
        WarmUp02Test.test02();
    }

    private static void test01()
    {
        WarmUp02 warmUp02 = new WarmUp02();
        String name = "WarmUp02Test.test01";
        String in = "101";
        int expectedOut = 2;
        int out = warmUp02.run(in);

        try
        {
            TestUtil.runTest(name, in, String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test02()
    {
        WarmUp02 warmUp02 = new WarmUp02();
        String name = "WarmUp02Test.test02";
        String in = "10010";
        int expectedOut = 10;
        int out = warmUp02.run(in);

        try
        {
            TestUtil.runTest(name, in, String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }
}
