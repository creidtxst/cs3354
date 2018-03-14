package assignmentA;

import list.LinkedList;
/**
 * reading material:
 * https://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
 *
 * * https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
 */
public class AssignmentA05
{
    public LinkedList run(int[] inputArray)
    {
        LinkedList list = new LinkedList(inputArray);
        list.reverse();
        return list;
    }
}
