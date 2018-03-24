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
