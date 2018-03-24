package assignmentA;

import array.ArrayIndex;
import java.util.ArrayList;
import java.util.List;

public class AssignmentA04
{
    /**
     * Sort the given array
     * @param unsortedArray the array to sort
     * @return the object list containing the sorted values and corresponding original indexes
     */
    public static List<ArrayIndex> run(int[] unsortedArray)
    {
        List<ArrayIndex> arrayIndexList = generateArrayIndexList(unsortedArray);
        return bubbleSort(arrayIndexList);
    }

    /**
     * Generate an object list from the given array primitive
     * @param array the array
     * @return the object list
     */
    public static List<ArrayIndex> generateArrayIndexList(int[] array)
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

    /**
     * Bubble sort implementation
     * @param originalArrayIndexList the original list
     * @return the sorted list
     */
    public static List<ArrayIndex> bubbleSort(List<ArrayIndex> originalArrayIndexList)
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

    /**
     * Transform the object list to an array containing the original indexes
     * @param arrayIndexList the object list
     * @return the array of original indexes
     */
    public static int[] arrayIndexListToOriginalIndexArray(List<ArrayIndex> arrayIndexList)
    {
        int[] originalIndexArray = new int[arrayIndexList.size()];

        for (int i = 0; i < arrayIndexList.size(); i++)
        {
            originalIndexArray[i] = arrayIndexList.get(i).getOriginalIndex();
        }

        return originalIndexArray;
    }

    /**
     * Transform the object list to an array containing the sorted values
     * @param arrayIndexList the object list
     * @return the array of sorted values
     */
    public static int[] arrayIndexListToSortedArray(List<ArrayIndex> arrayIndexList)
    {
        int[] sortedArrayIndex = new int[arrayIndexList.size()];

        for (int i = 0; i < arrayIndexList.size(); i++)
        {
            sortedArrayIndex[i] = arrayIndexList.get(i).getValue();
        }

        return sortedArrayIndex;
    }

}
