package assignmentA;

import search.BoyerMooreSearch;
import search.KnuthMorrisPrattSearch;
import search.NaiveSearch;
import search.RabinKarpSearch;

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
