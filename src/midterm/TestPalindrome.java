package midterm;

public class TestPalindrome
{
    public boolean isPalindrome(String str)
    {
        if (str.length() == 0 || str.length() == 1)
        {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1))
        {
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        return false;
    }

    public static void main(String[] args)
    {
        TestPalindrome testPalindrome = new TestPalindrome();
        boolean b1 = testPalindrome.isPalindrome("NOON");
        System.out.println("NOON" + " => " + b1);
        boolean b2 = testPalindrome.isPalindrome("NOWIWON");
        System.out.println("NOWIWON" + " => " + b2);

        boolean b3 = testPalindrome.isPalindrome("MOON");
        System.out.println("MOON" + " => " + b3);

        boolean b4 = testPalindrome.isPalindrome("ASANTAATNASA");
        System.out.println("ASANTAATNASA" + " => " + b4);
    }
}