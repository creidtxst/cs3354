package midterm;

public class Divide
{
    private static int mod(int n, int m)
    {
        if (n > m)
        {
            return mod(n - m, m);
        }
        else
        {
            return n;
        }
    }

    private static int quotient(int n, int m)
    {
        if (n > m)
        {
            return 1 + quotient(n - m, m);
        }
        else
        {
            return 0;
        }
    }

    public static void main(String[] args)
    {
        int mvalue = Divide.mod(10, 3);
        System.out.println(mvalue);
        int qvalue = Divide.quotient(10, 3);
        System.out.println(qvalue);
    }
}
