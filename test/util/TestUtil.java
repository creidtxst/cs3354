/**
 * Connor Reid
 * CS 3354
 * Section 260
 * Spring 2018
 * Roychowdhury
 */
package util;

public class TestUtil
{
    public static void runTest(String name, String in, String out, String expectedOut) throws Exception
    {
        if (!out.equals(expectedOut))
        {
            throw new Exception(name + " FAILED - expected: " + expectedOut + " actual: " + out + "\n");
        }
        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("in:  " + in);
        System.out.print("\nout: " + out);
        System.out.print("\n---------------------\n");
    }
}
