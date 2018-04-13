package midterm;

public class ScopeTest
{
    int x, y, z;
    ScopeTest(int a, int b, int c)
    {
        x = a; y = b; z = c;
        {
            int z1 = z++;
            {
                ++(z1);
            }
            System.out.println(z1);
        }
    }

    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;
        int c = 30;
        ScopeTest scopeTest = new ScopeTest(a,b,c);
    }

}
