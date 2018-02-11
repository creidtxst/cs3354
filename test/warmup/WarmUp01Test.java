/**
 * Connor Reid
 * CS 3354
 * Section 260
 * Spring 2018
 * Roychowdhury
 */
package warmup;

import util.TestUtil;

public class WarmUp01Test
{
    public static void main(String[] args)
    {
        WarmUp01Test.test01();
        WarmUp01Test.test02();
        WarmUp01Test.test03();
        WarmUp01Test.test04();
    }

    private static void test01()
    {
        WarmUp01 warmUp01 = new WarmUp01();
        String name = "WarmUp01Test.test01";
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

    private static void test02()
    {
        WarmUp01 warmUp01 = new WarmUp01();
        String name = "WarmUp01Test.test02";
        String in = "allyourbasearebelongtous";
        String expectedOut = "utnlbrearolasogoeeasbuyl";
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

    private static void test03()
    {
        WarmUp01 warmUp01 = new WarmUp01();
        String name = "WarmUp01Test.test03";
        String in = "Igetpaidforcodethatworksnotfortests";
        String expectedOut = "sstotnkotheorfipeIterfosrwatdcodatg";
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

    private static void test04()
    {
        WarmUp01 warmUp01 = new WarmUp01();
        String name = "WarmUp01Test.test04";
        String in = "thistestwillencryptthismessagebysplittingthemessageintotwosubsetsofevenandoddindicesandthenreversingbothstringsandfinallyconcatenating";
        String expectedOut = "ntntcoylnfnsnrstbnseenhdaeindonnvfsebswoneasmhgitlsbgseshtycelwstitgiaeanclaidagithogirvretnscdiddaeeotsuottigseetntipyeasmitprnlitesh";
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
