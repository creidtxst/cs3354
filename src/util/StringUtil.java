package util;

public class StringUtil
{
    /**
     * Reverse a given string
     * @param s the string to reverse
     * @return the reversed string
     */
    public static String reverseString(String s)
    {
        StringBuilder rs = new StringBuilder();
        for (int i = s.length(); i > 0; i--)
        {
            rs.append(s.charAt(i - 1));
        }
        return rs.toString();
    }
}
