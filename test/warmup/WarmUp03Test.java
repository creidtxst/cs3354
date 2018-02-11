/**
 * Connor Reid
 * CS 3354
 * Section 260
 * Spring 2018
 * Roychowdhury
 */
package warmup;

import util.TestUtil;

public class WarmUp03Test
{
    /**
     * To verify tests: http://www.wolframalpha.com/widget/widgetPopup.jsp?p=v&id=dfaf1b7d15e572ae5a1b2fa172ce8657&title=Math%20Help%20Boards:%20Sum%20Calculator&theme=blue
     *
     * @param args args
     */
    public static void main(String[] args)
    {
        WarmUp03Test.test01();
        WarmUp03Test.test02();
        WarmUp03Test.test03();
        WarmUp03Test.test04();
        WarmUp03Test.test05();
        WarmUp03Test.test06();
        WarmUp03Test.test07();
        WarmUp03Test.test08();
        WarmUp03Test.test09();
    }

    private static void test01()
    {
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "WarmUp03Test.test01";
        int in = 1;
        int expectedOut = 3;
        long out = warmUp03.run(in);

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
        String name = "WarmUp03Test.test02";
        int in = 2;
        int expectedOut = 18;
        long out = warmUp03.run(in);

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
        String name = "WarmUp03Test.test03";
        int in = 3;
        int expectedOut = 57;
        long out = warmUp03.run(in);

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
        String name = "WarmUp03Test.test04";
        int in = 4;
        int expectedOut = 132;
        long out = warmUp03.run(in);

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
        String name = "WarmUp03Test.test05";
        int in = 5;
        int expectedOut = 255;
        long out = warmUp03.run(in);

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
        String name = "WarmUp03Test.test06";
        int in = 16;
        int expectedOut = 8208;
        long out = warmUp03.run(in);

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
        String name = "WarmUp03Test.test07";
        int in = 256;
        int expectedOut = 33554688;
        long out = warmUp03.run(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test08()
    {
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "WarmUp03Test.test08";
        long in = (long) Math.pow(2, 15);
        long expectedOut = 70368744210432L;
        long out = warmUp03.run(in);

        try
        {
            TestUtil.runTest(name, String.valueOf(in), String.valueOf(out), String.valueOf(expectedOut));
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test09()
    {
        WarmUp03 warmUp03 = new WarmUp03();
        String name = "WarmUp03Test.test09";
        long in = (long) Math.pow(2, 16);
        long expectedOut = 562949953486848L;
        long out = warmUp03.run(in);

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
