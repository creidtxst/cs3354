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

    public LinkedList(int[] dataArray)
    {
        for (int data : dataArray)
        {
            this.push(data);
        }
    }

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

    public void push(int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    /**
     * Prints linked list
     */
    public void printList()
    {
        Node cur = head;
        while (cur != null)
        {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

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
