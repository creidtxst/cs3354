package assignmentA;

import search.BoyerMooreSearch;
import search.KnuthMorrisPrattSearch;
import search.NaiveSearch;
import search.RabinKarpSearch;

public class AssignmentA02
{
    public static int runBoyerMoore(String needle, String haystack)
    {
        return BoyerMooreSearch.findNumOccurrencesOfPattern(haystack, needle);
    }

    public static int runKnuthMorrisPratt(String needle, String haystack)
    {
        return KnuthMorrisPrattSearch.findNumOccurrencesOfPattern(haystack, needle);
    }

    public static int runRabinKarp(String needle, String haystack)
    {
        return RabinKarpSearch.findNumOccurrencesOfPattern(haystack, needle);
    }

    public static int runNaiveSearch(String needle, String haystack)
    {
        return NaiveSearch.findNumOccurrencesOfPattern(haystack, needle);
    }
}
