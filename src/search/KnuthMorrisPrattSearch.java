package search;

public class KnuthMorrisPrattSearch
{
    public int findNumOccurrencesOfPattern(String text, String pattern)
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

    int search(String text, String pattern)
    {
        int[] longestProperSuffixArray = computeLongestProperSuffixArray(pattern);

        int j = 0;  // Number of chars matched in pattern
        for (int i = 0; i < text.length(); i++)
        {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
            {
                // Fall back in the pattern
                j = longestProperSuffixArray[j - 1];  // Strictly decreasing
            }
            if (text.charAt(i) == pattern.charAt(j))
            {
                // Next char matched, increment position
                j++;
                if (j == pattern.length())
                {
                    return i - (j - 1);
                }
            }
        }

        return -1;  // Not found
    }

    int[] computeLongestProperSuffixArray(String pattern)
    {
        int[] longestProperSuffixArray = new int[pattern.length()];
        longestProperSuffixArray[0] = 0;  // Base case
        for (int i = 1; i < pattern.length(); i++)
        {
            // Start by assuming we're extending the previous Longest Proper Suffix
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
