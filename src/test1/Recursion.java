package test1;

public class Recursion
{
    public int addNums(int n)
    {
        System.out.print("n: " + n + "\n");
        return n == 0 ? n : addNums(n - 1) + n;
    }

    public int addNumsTail(int n)
    {
        System.out.print("n: " + n + "\n");
        if (n == 1)
        {
            return n;
        }

        return n + addNumsTail(n - 1);
    }
}
