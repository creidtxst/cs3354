package warmup;

import java.util.ArrayList;
import java.util.List;

public class WarmUp03
{
    public int run(int row_num)
    {
        return computeSum(row_num);
    }

    private static List<List<Integer>> generateRowList(int row_num)
    {
        List<List<Integer>> rowList = new ArrayList<>();
        int k = 1;
        for (int i = 1; i <= row_num; i++)
        {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i * 2; j++)
            {
                row.add(k++);
            }
            rowList.add(row);
        }

        return rowList;
    }

    private static List<Integer> generateRow(int row_num)
    {
        List<Integer> row = new ArrayList<>();

        int start = row_num * (row_num - 1) + 1;
        int end = row_num * (row_num + 1);

        for (int i = 0; i <= end - start; i++)
        {
            row.add(start + i);
        }

        return row;
    }

    private static int computeSum(int row_num)
    {
        int sum = 0;
        int start = (row_num * (row_num - 1)) + 1;
        int end = row_num * (row_num + 1);

        for (int i = 0; i <= end - start; i++)
        {
            sum += start + i;
        }

        return sum;
    }
}
