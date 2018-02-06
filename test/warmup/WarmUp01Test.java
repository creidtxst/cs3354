package warmup;

public class WarmUp01Test
{
    public static void main(String[] args)
    {
        WarmUp01Test.test01();
    }

    private static void test01()
    {
        WarmUp01 warmUp01 = new WarmUp01();
        String name = "warmup.WarmUp01Test.test01";
        String in = "abscacd";
        String expectedOut = "dasaccb";
        String out = warmUp01.run(in);

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
