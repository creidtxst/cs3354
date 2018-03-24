package assignmentA;

import search.KnuthMorrisPrattSearch;

public class AssignmentA02
{
    /**
     * Run the Knuth-Morris-Pratt search.
     * @param needle the needle to find
     * @param haystack the haystack to search within
     * @return the number of times the needle is found within the haystack
     */
    public static int runKnuthMorrisPratt(String needle, String haystack)
    {
        return KnuthMorrisPrattSearch.findNumOccurrencesOfPattern(haystack, needle);
    }
}
