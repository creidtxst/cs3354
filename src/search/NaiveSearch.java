package search;

public class NaiveSearch
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

    public int search(String text, String pattern)
    {
        int[] occurrence = new int[ALPHABET_SIZE];

        for (int c = 0; c < ALPHABET_SIZE; c++)
        {
            occurrence[c] = -1;
        }

        for (int j = 0; j < pattern.length(); j++)
        {
            occurrence[pattern.charAt(j)] = j;
        }

        int n = text.length();
        int m = pattern.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip)
        {
            skip = 0;
            for (int j = m - 1; j >= 0; j--)
            {
                if (pattern.charAt(j) != text.charAt(i + j))
                {
                    skip = Math.max(1, j - occurrence[text.charAt(i + j)]);
                    break;
                }
            }

            if (skip == 0)
            {
                return i;
            }
        }
        return -1;
    }
}
