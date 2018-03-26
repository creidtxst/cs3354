package list;

public class LinkedList
{
    Node head;

    class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /**
     * Constructor
     * @param dataArray the data array
     */
    public LinkedList(int[] dataArray)
    {
        for (int i = dataArray.length; i > 0; i--)
        {
            this.push(dataArray[i - 1]);
        }
    }

    /**
     * Reverse the list
     */
    public void reverse()
    {
        Node prev = null;
        Node cur = head;
        Node next;

        while (cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;
    }

    /**
     * Push a value onto the list
     * @param data the data to push
     */
    public void push(int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    /**
     * Return the number of nodes in the list
     * @return the number of nodes in the list
     */
    private int getNumNodes()
    {
        int i = 0;
        Node cur = head;
        while (cur != null)
        {
            i++;
            cur = cur.next;
        }

        return i;
    }

    /**
     * Transform the linked list to an array of values
     * @return the array of values in teh linked list
     */
    public int[] toArray()
    {
        int c = getNumNodes();
        int[] a = new int[c];

        int i = 0;
        Node cur = head;
        while (cur != null)
        {
            a[i++] = cur.data;
            cur = cur.next;
        }

        return a;
    }
}
