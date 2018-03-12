package AssignmentA;

import assignmentA.AssignmentA05;

public class AssignmentA05Test
{
    public static void main(String[] args)
    {
        AssignmentA05Test.test01();
    }

    private static void test01()
    {
        AssignmentA05 assignmentA05 = new AssignmentA05();

        String name = "AssignmentA05Test.test01";
        int[] input = {85, 15, 4, 20};
        assignmentA05.run(input);

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
