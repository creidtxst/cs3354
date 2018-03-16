package search;

public class BoyerMooreSearch
{
    private static final int ALPHABET_SIZE = 256;

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

    /**
     * Find pattern in text
     *
     * @param text
     * @param pattern
     */
    public int search(String text, String pattern)
    {
        char[] textCharArray = text.toCharArray();
        char[] patternCharArray = pattern.toCharArray();
        int position = indexOf(textCharArray, patternCharArray);

        if (position == -1)
        {
//            System.out.println("\nNo Match\n");
        }

        else
        {
//            System.out.println("Pattern found at position : " + position);
        }

        return position;
    }

    /**
     * Calculate index of pattern substring
     *
     * @param textCharArray
     * @param patternCharArray
     * @return
     */
    public int indexOf(char[] textCharArray, char[] patternCharArray)
    {
        if (patternCharArray.length == 0)
        {
            return 0;
        }

        int charTable[] = makeCharTable(patternCharArray);
        int offsetTable[] = makeOffsetTable(patternCharArray);

        for (int i = patternCharArray.length - 1, j; i < textCharArray.length; )
        {
            for (j = patternCharArray.length - 1; patternCharArray[j] == textCharArray[i]; --i, --j)
            {
                if (j == 0)
                {
                    return i;
                }
            }

            // i += pattern.length - j; // For naive method
            i += Math.max(offsetTable[patternCharArray.length - 1 - j], charTable[textCharArray[i]]);
        }

        return -1;
    }

    /**
     * Makes the jump table based on the mismatched character information
     *
     * @param pattern
     * @return
     */
    private int[] makeCharTable(char[] pattern)
    {
        int[] charTable = new int[ALPHABET_SIZE];

        for (int i = 0; i < charTable.length; ++i)
        {
            charTable[i] = pattern.length;
        }

        for (int i = 0; i < pattern.length - 1; ++i)
        {
            charTable[pattern[i]] = pattern.length - 1 - i;
        }

        return charTable;
    }

    /**
     * Makes the jump table based on the scan offset which mismatch occurs.
     *
     * @param pattern
     * @return
     */
    private static int[] makeOffsetTable(char[] pattern)
    {
        int[] offsetTable = new int[pattern.length];
        int lastPrefixPosition = pattern.length;

        for (int i = pattern.length - 1; i >= 0; --i)
        {
            if (isPrefix(pattern, i + 1))
            {
                lastPrefixPosition = i + 1;
            }

            offsetTable[pattern.length - 1 - i] = lastPrefixPosition - i + pattern.length - 1;
        }

        for (int i = 0; i < pattern.length - 1; ++i)
        {
            int suffixLength = suffixLength(pattern, i);
            offsetTable[suffixLength] = pattern.length - 1 - i + suffixLength;
        }

        return offsetTable;
    }

    /**
     * Check if needle[p:end] a prefix of pattern
     *
     * @param pattern
     * @param p
     * @return
     */
    private static boolean isPrefix(char[] pattern, int p)
    {
        for (int i = p, j = 0; i < pattern.length; ++i, ++j)
        {
            if (pattern[i] != pattern[j])
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the maximum length of the substring ends at p and is a suffix
     *
     * @param pattern
     * @param p
     * @return
     */
    private static int suffixLength(char[] pattern, int p)
    {
        int suffixLength = 0;

        for (int i = p, j = pattern.length - 1; i >= 0 && pattern[i] == pattern[j]; --i, --j)
        {
            suffixLength += 1;
        }

        return suffixLength;
    }
}
