package AssignmentA;

import assignmentA.AssignmentA04;

public class AssignmentA04Test
{
    public static void main(String[] args)
    {
        AssignmentA04Test.test01();
    }

    private static void test01()
    {
        String name = "AssignmentA04Test.test01";
        int[] inputArray = {10, 30, 2, 3, 63};

        AssignmentA04.run(inputArray);

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
