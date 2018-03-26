package AssignmentA;

import assignmentA.AssignmentA05;
import list.LinkedList;
import java.util.Arrays;

public class AssignmentA05Test
{
    public static void main(String[] args)
    {
        AssignmentA05Test.test01();
        AssignmentA05Test.test02();
        AssignmentA05Test.test03();
        AssignmentA05Test.test04();
        AssignmentA05Test.test05();
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

    private static void test02()
    {
        String name = "AssignmentA05Test.test02";
        int[] input = {25, 20, 15, 10, 5};
        int[] expectedOutput = {5, 10, 15, 20, 25};

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

    private static void test03()
    {
        String name = "AssignmentA05Test.test03";
        int[] input = {10, 9, 8, 7, 6};
        int[] expectedOutput = {6, 7, 8, 9, 10};

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

    private static void test04()
    {
        String name = "AssignmentA05Test.test04";
        int[] input = {3, 6, 9, 12, 15};
        int[] expectedOutput = {15, 12, 9, 6, 3};

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

    private static void test05()
    {
        String name = "AssignmentA05Test.test05";
        int[] input = {83, 87, 11, 12, 9};
        int[] expectedOutput = {9, 12, 11, 87, 83};

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
