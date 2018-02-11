/**
 * Connor Reid
 * CS 3354
 * Section 260
 * Spring 2018
 * Roychowdhury
 */
package warmup;

import util.StringUtil;

public class WarmUp01
{
    public String run(String in)
    {
        StringBuilder evenSubstring = new StringBuilder();
        StringBuilder oddSubstring = new StringBuilder();

        // Build even and odd substrings
        for (int i = 0; i < in.length(); i++)
        {
            // Check if index is even
            if (i % 2 == 0)
            {
                evenSubstring.append(in.charAt(i));
            }
            else    // Else index is odd
            {
                oddSubstring.append(in.charAt(i));
            }
        }

        return StringUtil.reverseString(evenSubstring.toString()) + StringUtil.reverseString(oddSubstring.toString());
    }
}
