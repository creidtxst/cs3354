public class TestUtil
{
    public static void runTest(String name, String in, String out, String expectedOut) throws Exception
    {
        if (!out.equals(expectedOut))
        {
            throw new Exception(name + " FAILED\n");
        }
        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("in:  " + in);
        System.out.print("\nout: " + out);
        System.out.print("\n---------------------\n");
    }

    public static void runTest(String name, String in, int out, int expectedOut) throws Exception
    {
        if (out != (expectedOut))
        {
            throw new Exception(name + " FAILED\n");
        }
        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("in:  " + in);
        System.out.print("\nout: " + out);
        System.out.print("\n---------------------\n");
    }

    public static void runTest(String name, int in, int out, int expectedOut) throws Exception
    {
        if (out != (expectedOut))
        {
            throw new Exception(name + " FAILED\n");
        }
        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("in:  " + in);
        System.out.print("\nout: " + out);
        System.out.print("\n---------------------\n");
    }
}
