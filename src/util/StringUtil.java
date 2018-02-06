package util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil
{
    public static String reverseString(String s)
    {
        StringBuilder rs = new StringBuilder();
        for (int i = s.length(); i > 0; i--)
        {
            rs.append(s.charAt(i - 1));
        }
        return rs.toString();
    }

    public static List<String> generateSubstringList(String s)
    {
        List<String> substringList = new ArrayList<>();
        int inputStringLength = s.length();
        for (int i = 0; i < inputStringLength; i++)
        {
            for (int j = 0; j < (inputStringLength - i); j++)
            {
                substringList.add(s.substring(j, i + j + 1));
            }
        }
        return substringList;
    }

    public static int convertBinaryStringToDecimal(String s)
    {
        int decimalValue = 0;
        String rs = StringUtil.reverseString(s);
        for (int i = 0; i < rs.length(); i++)
        {
            decimalValue += rs.charAt(i) == '0' ? 0 : Math.pow(2, i);
        }
        return decimalValue;
    }
}
