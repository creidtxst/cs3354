package midterm;

public class LinkedList
{
    Node head = null;

    public void addNode(int value)
    {
        Node nodeToAdd = new Node(value);
        nodeToAdd.next = head;
        head = nodeToAdd;
    }

    public void printList()
    {
        Node cur = head;
        while (cur != null)
        {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.addNode(2);
        ll.addNode(4);
        ll.addNode(6);
        ll.printList();
    }
}
