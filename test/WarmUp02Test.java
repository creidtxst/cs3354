import warmup.WarmUp02;

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

        runTest(name, in, out, expectedOut);
    }

    private static void test02()
    {
        WarmUp02 warmUp02 = new WarmUp02();
        String name = "WarmUp02Test.test02";
        String in = "10010";
        int expectedOut = 10;
        int out = warmUp02.run(in);

        runTest(name, in, out, expectedOut);
    }

    private static void runTest(String name, String in, int expectedOut, int out)
    {
        try
        {
            TestUtil.runTest(name, in, out, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }
}
