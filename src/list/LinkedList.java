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
        Node next = null;
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
}
