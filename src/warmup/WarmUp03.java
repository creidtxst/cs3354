package warmup;

import java.util.ArrayList;
import java.util.List;

public class WarmUp03
{
    public int run(int in)
    {
        List<List<Integer>> rowList = WarmUp03.generateRowList(in);

        int sum = 0;
        List<Integer> selectedRow = rowList.get(in - 1);
        for (Integer num : selectedRow)
        {
            sum += num;
        }

        return sum;
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
}
