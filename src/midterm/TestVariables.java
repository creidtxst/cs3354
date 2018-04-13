package midterm;

public class TestVariables
{
    private static int marks = 0;

    void printMarks()
    {
        System.out.print(" " +marks);
    }

    void addMarks(int marks)
    {
        marks = marks + marks;
    }

    public static void main(String[] args)
    {
        TestVariables test = new TestVariables();
        test.printMarks();
        test.addMarks(50);
        test.printMarks();
    }
}
