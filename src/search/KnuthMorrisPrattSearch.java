package search;

public class KnuthMorrisPrattSearch
{
    /**
     * Find the number of occurrences of a given pattern within a string
     * @param text the string to search
     * @param pattern the pattern to find
     * @return the number of occurences of the pattern within the string
     */
    public static int findNumOccurrencesOfPattern(String text, String pattern)
    {
        text = text.toLowerCase();
        pattern = pattern.toLowerCase();
        int count = 0;
        int index = 0;
        int tempIndex;

        do
        {
            tempIndex = index;
            index = search(text, pattern);
            text = text.substring(index + pattern.length(), text.length());

            if (index > 0 && index != tempIndex)
            {
                count++;
            }
        } while (index != tempIndex);

        return count;
    }

    /**
     * Search for the pattern within the string
     * @param text the string to search
     * @param pattern the pattern to find
     * @return the index at which the pattern is found within the string
     */
    private static int search(String text, String pattern)
    {
        int[] longestProperSuffixArray = computeLongestProperSuffixArray(pattern);
        int j = 0;  // Number of characters matched

        for (int i = 0; i < text.length(); i++)
        {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
            {
                // Go back in the pattern
                j = longestProperSuffixArray[j - 1];  // Strictly decreasing
            }
            if (text.charAt(i) == pattern.charAt(j))
            {
                // Increment position, next character has been matched
                j++;
                if (j == pattern.length())
                {
                    return i - (j - 1);
                }
            }
        }

        return -1;  // Pattern was NOT found
    }

    /**
     * Compute the longest proper suffix. This is also known as the longest proper prefix. This prefix is a prefix where
     * the entire pattern is NOT allowed.
     * @param pattern the pattern to compute
     * @return the array of longest proper suffixes
     */
    private static int[] computeLongestProperSuffixArray(String pattern)
    {
        int[] longestProperSuffixArray = new int[pattern.length()];
        longestProperSuffixArray[0] = 0;  // Base case

        for (int i = 1; i < pattern.length(); i++)
        {
            // Assumed previous Longest Proper Suffix is extended
            int j = longestProperSuffixArray[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
            {
                j = longestProperSuffixArray[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j))
            {
                j++;
            }
            longestProperSuffixArray[i] = j;
        }

        return longestProperSuffixArray;
    }
}
