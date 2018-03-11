package search;

public class RabinKarpSearch
{
    private static final int ALPHABET_SIZE = 256;

    static void search(String pattern, String text, int primeNumber)
    {
        int M = pattern.length();
        int N = text.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(ALPHABET_SIZE, M-1)%q"
        for (i = 0; i < M - 1; i++)
        {
            h = (h * ALPHABET_SIZE) % primeNumber;
        }

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++)
        {
            p = (ALPHABET_SIZE * p + pattern.charAt(i)) % primeNumber;
            t = (ALPHABET_SIZE * t + text.charAt(i)) % primeNumber;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++)
        {
            // Check the hash values of current window of text and pattern. If the hash values match then only check for characters on by one
            if (p == t)
            {
                // Check for characters one by one
                for (j = 0; j < M; j++)
                {
                    if (text.charAt(i + j) != pattern.charAt(j))
                    {
                        break;
                    }
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
            if (i < N - M)
            {
                t = (ALPHABET_SIZE * (t - text.charAt(i) * h) + text.charAt(i + M)) % primeNumber;

                // We might get negative value of t, converting it to positive
                if (t < 0)
                {
                    t = (t + primeNumber);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        int primeNumber = 101; // A prime number
        search(pat, txt, primeNumber);
    }
}
