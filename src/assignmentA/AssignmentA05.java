package assignmentA;

import list.LinkedList;

public class AssignmentA05
{
    /**
     * Reverse a linked list given an array of integers
     * @param inputArray the array of integers
     * @return the reversed linked list
     */
    public static LinkedList run(int[] inputArray)
    {
        LinkedList list = new LinkedList(inputArray);
        list.reverse();
        return list;
    }
}
