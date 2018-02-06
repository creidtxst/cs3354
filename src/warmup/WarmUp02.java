package warmup;

import util.StringUtil;
import java.util.List;

public class WarmUp02
{
    public int run(String in)
    {
        // Generate list of substrings, INCLUDING DUPLICATES
        List<String> substringList = StringUtil.generateSubstringList(in);

        int out = 0;

        for (String s : substringList)
        {
            int decimalValue = StringUtil.convertBinaryStringToDecimal(s);

            // Check if decimalValue is even
            if (decimalValue % 2 == 0 || decimalValue == 0)
            {
                out++;
            } // Else decimalValue is odd, skip
        }

        return out;
    }
}
