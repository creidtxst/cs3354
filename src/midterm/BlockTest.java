package midterm;

public class BlockTest
{
    static
    {
        System.out.print(" [in static block .... 1]");
    }

    {
        System.out.print(" [in a block ... 2]");
    }

    public static void main(String... args)
    {
        System.out.print(" [in main...]");
    }
}
