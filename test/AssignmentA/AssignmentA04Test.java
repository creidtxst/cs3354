package AssignmentA;

import array.ArrayIndex;
import assignmentA.AssignmentA04;
import java.util.Arrays;
import java.util.List;

public class AssignmentA04Test
{
    public static void main(String[] args)
    {
        AssignmentA04Test.test01();
        AssignmentA04Test.test02();
        AssignmentA04Test.test03();
        AssignmentA04Test.test04();
        AssignmentA04Test.test05();
    }

    private static void test01()
    {
        int[] inputArray = {10, 30, 2, 3, 63};
        int[] expectedOriginalIndexOut = {2, 3, 0, 1, 4};
        int[] expectedOut = {2, 3, 10, 30, 63};

        List<ArrayIndex> in = AssignmentA04.generateArrayIndexList(inputArray);
        List<ArrayIndex> out = AssignmentA04.bubbleSort(in);

        try
        {
            validate("AssignmentA04Test.test01", inputArray, out, expectedOriginalIndexOut, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test02()
    {
        int[] inputArray = {5, 4, 3, 2, 1};
        int[] expectedOriginalIndexOut = {4, 3, 2, 1, 0};
        int[] expectedOut = {1, 2, 3, 4, 5};

        List<ArrayIndex> in = AssignmentA04.generateArrayIndexList(inputArray);
        List<ArrayIndex> out = AssignmentA04.bubbleSort(in);

        try
        {
            validate("AssignmentA04Test.test02", inputArray, out, expectedOriginalIndexOut, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test03()
    {
        int[] inputArray = {99, 88, 77, 66, 55};
        int[] expectedOriginalIndexOut = {4, 3, 2, 1, 0};
        int[] expectedOut = {55, 66, 77, 88, 99};

        List<ArrayIndex> in = AssignmentA04.generateArrayIndexList(inputArray);
        List<ArrayIndex> out = AssignmentA04.bubbleSort(in);

        try
        {
            validate("AssignmentA04Test.test03", inputArray, out, expectedOriginalIndexOut, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test04()
    {
        int[] inputArray = {3, 1, 7, 5, 11};
        int[] expectedOriginalIndexOut = {1, 0, 3, 2, 4};
        int[] expectedOut = {1, 3, 5, 7, 11};

        List<ArrayIndex> in = AssignmentA04.generateArrayIndexList(inputArray);
        List<ArrayIndex> out = AssignmentA04.bubbleSort(in);

        try
        {
            validate("AssignmentA04Test.test04", inputArray, out, expectedOriginalIndexOut, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test05()
    {
        int[] inputArray = {9, 3, 27, 243, 81};
        int[] expectedOriginalIndexOut = {1, 0, 2, 4, 3};
        int[] expectedOut = {3, 9, 27, 81, 243};

        List<ArrayIndex> in = AssignmentA04.generateArrayIndexList(inputArray);
        List<ArrayIndex> out = AssignmentA04.bubbleSort(in);

        try
        {
            validate("AssignmentA04Test.test05", inputArray, out, expectedOriginalIndexOut, expectedOut);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void validate(String name, int[] in, List<ArrayIndex> out, int[] expectedOriginalIndexOut, int[] expectedOut) throws Exception
    {
        int[] originalIndexArray = AssignmentA04.arrayIndexListToOriginalIndexArray(out);
        int[] sortedArray = AssignmentA04.arrayIndexListToSortedArray(out);

        if (!Arrays.equals(originalIndexArray, expectedOriginalIndexOut) || !Arrays.equals(sortedArray, expectedOut))
        {
            throw new Exception(name + " FAILED - expected: " + Arrays.toString(expectedOut) + " actual: " + Arrays.toString(sortedArray) + "\n");
        }
        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("input array:       " + Arrays.toString(in));
        System.out.print("\nsorted array:      " + Arrays.toString(sortedArray));
        System.out.print("\noriginal indexes:  " + Arrays.toString(originalIndexArray));
        System.out.print("\n---------------------\n");
    }
}
