package warmup;

import util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class WarmUp02
{
    public int run(String in)
    {
        // Generate list of substrings, INCLUDING DUPLICATES
        List<String> substringList = WarmUp02.generateSubstringList(in);

        int out = 0;
        for (String s : substringList)
        {
            int decimalValue = WarmUp02.convertBinaryStringToDecimal(s);
            boolean isEven = decimalValue % 2 == 0 || decimalValue == 0;
            out += isEven ? 1 : 0;
        }
        return out;
    }

    /**
     * Generate a list of substrings from a given string, INCLUDING DUPLICATES
     * @param s string to generate substrings from
     * @return List (including duplicates) of substrings
     */
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

    /**
     * Traverse a binary string in reverse order and compute the value in decimal
     * @param s the binary string to convert
     * @return the decimal value of the binary string
     */
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
