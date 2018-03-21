package assignmentA;

import list.LinkedList;

public class AssignmentA05
{
    public static LinkedList run(int[] inputArray)
    {
        LinkedList list = new LinkedList(inputArray);
        list.reverse();
        return list;
    }
}
