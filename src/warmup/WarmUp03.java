/**
 * Connor Reid
 * CS 3354
 * Section 260
 * Spring 2018
 * Roychowdhury
 */
package warmup;

import java.util.ArrayList;
import java.util.List;

public class WarmUp03
{
    public long run(long row_num)
    {
        return computeSum(row_num);
    }

    /**
     * Helper method to generate the entire tree
     *
     * @param row_num row to generate up to
     * @return the entire tree
     */
    private static List<List<Long>> generateRowList(long row_num)
    {
        List<List<Long>> rowList = new ArrayList<>();
        for (long i = 1; i <= row_num; i++)
        {
            rowList.add(WarmUp03.generateRow(row_num));
        }

        return rowList;
    }

    /**
     * Helper method to generate a single row given a row num
     *
     * @param row_num the row to generate
     * @return the row
     */
    private static List<Long> generateRow(long row_num)
    {
        List<Long> row = new ArrayList<>();

        long start = WarmUp03.computeStart(row_num);
        long end = WarmUp03.computeEnd(row_num);

        for (long i = 0; i <= end - start; i++)
        {
            row.add(start + i);
        }

        return row;
    }

    /**
     * Compute the sum of a row, given a row number
     *
     * @param row_num the row to compute
     * @return the sum of the row
     */
    private static long computeSum(long row_num)
    {
        long start = WarmUp03.computeStart(row_num);
        long end = WarmUp03.computeEnd(row_num);

        long sum = 0;
        for (long i = 0; i <= end - start; i++)
        {
            sum += start + i;
        }

        return sum;
    }

    /**
     * The value of the 0th index in the row, given a row number
     *
     * @param row_num the row to compute the start index of
     * @return the value of the 0th index of the row
     */
    private static long computeStart(long row_num)
    {
        return (row_num * (row_num - 1)) + 1;
    }

    /**
     * The value of the end index in the row, given a row number
     *
     * @param row_num the row to compute the end index of
     * @return the value of the end index of the row
     */
    private static long computeEnd(long row_num)
    {
        return row_num * (row_num + 1);
    }
}
