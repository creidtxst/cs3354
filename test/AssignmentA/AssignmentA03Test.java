package AssignmentA;

import assignmentA.AssignmentA03;

public class AssignmentA03Test
{
    public static void main(String[] args)
    {
        AssignmentA03Test.test01();
    }

    private static void test01()
    {
        AssignmentA03 assignment03 = new AssignmentA03();
        String name = "AssignmentA03Test.test01";
        String fileName = "/Users/creid/Desktop/NWR/school/spring-2018/TXSTRR/CS-3354/cs3354/test/AssignmentA/matrixInput/matrixInput01.txt";

        assignment03.run(fileName);

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
