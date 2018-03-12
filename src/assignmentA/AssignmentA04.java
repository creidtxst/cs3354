package assignmentA;

import array.ArrayIndex;
import java.util.ArrayList;
import java.util.List;

/**
 * Requirements:
 * <p>
 * 1) Implement a Java method that sorts your list/array
 * 2) return the sorted array
 * 3) Return the original positions of the unsorted array
 * <p>
 * References:
 * <p>
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
 */

public class AssignmentA04
{
    public void run(int[] unsortedArray)
    {
        List<ArrayIndex> arrayIndexList = generateArrayIndexList(unsortedArray);
        List<ArrayIndex> sortedArrayIndexList = bubbleSort(arrayIndexList);

        System.out.print("\n" + arrayIndexList.toString());
        System.out.print("\n" + sortedArrayIndexList.toString());
    }

    private static List<ArrayIndex> generateArrayIndexList(int[] array)
    {
        List<ArrayIndex> arrayIndexList = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
        {
            int originalIndex = i;
            int value = array[i];
            ArrayIndex arrayIndex = new ArrayIndex(originalIndex, value);
            arrayIndexList.add(arrayIndex);
        }

        return arrayIndexList;
    }

    private static List<ArrayIndex> bubbleSort(List<ArrayIndex> originalArrayIndexList)
    {
        List<ArrayIndex> sortedArrayIndexList = new ArrayList<>(originalArrayIndexList);

        for (int i = (sortedArrayIndexList.size() - 1); i >= 0; i--)
        {
            for (int j = 1; j <= i; j++)
            {
                if (sortedArrayIndexList.get(j - 1).getValue() > sortedArrayIndexList.get(j).getValue())
                {
                    ArrayIndex temp = sortedArrayIndexList.get(j - 1);
                    sortedArrayIndexList.set(j - 1, sortedArrayIndexList.get(j));
                    sortedArrayIndexList.set(j, temp);
                }
            }
        }

        return sortedArrayIndexList;
    }
}
