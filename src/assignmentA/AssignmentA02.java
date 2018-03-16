package assignmentA;

import search.BoyerMooreSearch;
import search.KnuthMorrisPrattSearch;
import search.NaiveSearch;
import search.RabinKarpSearch;

/**
 * Requirements:
 * <p>
 * 1) Find the number of occurrences of a needle in the haystack.
 * 2) If there is no needle you return 0.
 * 3) Make your search case insensitive.
 * 4) You cannot use string library method called contains()
 * 5) Show the computation time (use System.currentTimeMillis()) for different needles and different haystacks.
 * <p>
 * Substring search problem
 * <p>
 * References:
 * https://www.nayuki.io/page/knuth-morris-pratt-string-matching
 * https://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * https://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
 * https://www.sanfoundry.com/java-program-boyer-moore-algorithm/
 * https://www.geeksforgeeks.org/searching-for-character-and-substring-in-a-string/
 * https://www.sanfoundry.com/java-program-perform-naive-string-matching/
 * <p>
 * Info about Prime Numbers (applicable to Rabin-Karp algorithm):
 * <p>
 * https://en.wikipedia.org/wiki/Prime_number
 * https://en.wikipedia.org/wiki/Largest_known_prime_number
 * https://www.mersenne.org/primes/press/M77232917.html
 * http://primes.utm.edu/notes/faq/why.html
 * https://en.wikipedia.org/wiki/Euclid%27s_theorem
 */
public class AssignmentA02
{
    public int runBoyerMoore(String needle, String haystack)
    {
        BoyerMooreSearch boyerMooreSearch = new BoyerMooreSearch();
        int c = boyerMooreSearch.findNumOccurrencesOfPattern(haystack, needle);
        return c;
    }

    public int runKnuthMorrisPratt(String needle, String haystack)
    {
        KnuthMorrisPrattSearch knuthMorrisPrattSearch = new KnuthMorrisPrattSearch();
        int c = knuthMorrisPrattSearch.findNumOccurrencesOfPattern(haystack, needle);
        return c;
    }

    public int runRabinKarp(String needle, String haystack)
    {
        RabinKarpSearch rabinKarpSearch = new RabinKarpSearch();
        int c = rabinKarpSearch.findNumOccurrencesOfPattern(haystack, needle);
        return c;
    }

    public int runNaiveSearch(String needle, String haystack)
    {
        NaiveSearch naiveSearch = new NaiveSearch();
        int c = naiveSearch.findNumOccurrencesOfPattern(haystack, needle);
        return c;
    }
}
