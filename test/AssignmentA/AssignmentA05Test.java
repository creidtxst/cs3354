package AssignmentA;

import assignmentA.AssignmentA05;
import list.LinkedList;
import java.util.Arrays;

public class AssignmentA05Test
{
    public static void main(String[] args)
    {
        AssignmentA05Test.test01();
    }

    private static void test01()
    {
        String name = "AssignmentA05Test.test01";
        int[] input = {10, 30, 2, 3, 63};
        int[] expectedOutput = {63, 3, 2, 30, 10};

        LinkedList reversedList = AssignmentA05.run(input);

        try
        {
            validate(name, input, reversedList.toArray(), expectedOutput);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void validate(String name, int[] in, int[] out, int[] expectedOut) throws Exception
    {
        if (!Arrays.equals(out, expectedOut))
        {
            throw new Exception(name + " FAILED - expected: " + expectedOut + " actual: " + out + "\n");
        }

        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("in:  " + Arrays.toString(in));
        System.out.print("\nout: " + Arrays.toString(out));
        System.out.print("\n---------------------\n");
    }
}
