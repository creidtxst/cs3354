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
    public void run(int[] inputArray)
    {
        LinkedList list = new LinkedList(inputArray);
        System.out.println("Input");
        list.printList();
        list.reverse();
        System.out.println("\nOutput");
        list.printList();
    }
}
