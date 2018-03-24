package matrix;

import java.util.concurrent.ThreadLocalRandom;

public class Matrix
{
    private static int LOWER_BOUND = 0;
    private static int UPPER_BOUND = 99;

    private int numRows;
    private int numColumns;
    private int[][] data;

    public Matrix()
    {
        numRows = 0;
        numColumns = 0;
        data = generateRandomData(numRows, numRows);
    }

    /**
     * Note: Constructor assumes valid input.
     *
     * @param inputArray a list of strings exactly size 2 containing a string representing the number of columns as the 0th element and a string representing the number of rows as the 1st element
     */
    public Matrix(int[] inputArray)
    {
        numRows = inputArray[1];
        numColumns = inputArray[0];
        data = generateRandomData(numRows, numRows);
    }

    /**
     * Constructor
     * @param numRows the number of rows
     * @param numColumns the number of columns
     */
    public Matrix(int numRows, int numColumns)
    {
        this.numRows = numRows;
        this.numColumns = numColumns;
        data = generateRandomData(numRows, numColumns);
    }

    /**
     * Constructor
     * @param numRows the number of rows
     * @param numColumns the number of columns
     * @param generateRandom whether or not to generate random values
     */
    public Matrix(int numRows, int numColumns, boolean generateRandom)
    {
        this.numRows = numRows;
        this.numColumns = numColumns;
        if (generateRandom)
        {
            data = generateRandomData(numRows, numColumns);
        }
        else
        {
            data = new int[numRows][numColumns];
        }
    }

    /**
     * Constructor
     * @param numRows the number of rows
     * @param numColumns the number of columns
     * @param data the data within the matrix
     */
    public Matrix(int numRows, int numColumns, int[][] data)
    {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.data = data;
    }

    public int getNumRows()
    {
        return numRows;
    }

    public void setNumRows(int numRows)
    {
        this.numRows = numRows;
    }

    public int getNumColumns()
    {
        return numColumns;
    }

    public void setNumColumns(int numColumns)
    {
        this.numColumns = numColumns;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("\n");

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numColumns; j++)
            {
                s.append(String.format("%d ", data[i][j]));
            }
            s.append("\n");
        }

        return s.toString();
    }

    /**
     * Compare two matrices
     * @param a the first matrix
     * @param b the second matrix
     * @return whether or not the two matrices are equal
     */
    public static boolean compare(Matrix a, Matrix b)
    {
        for (int i = 0; i < a.numRows; i++)
        {
            for (int j = 0; j < a.numColumns; j++)
            {
                if (a.data[i][j] != b.data[i][j])
                {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Generate random data
     * @param numRows the number of rows
     * @param numColumns the number of columns
     * @return a two-dimensional array of random values
     */
    private static int[][] generateRandomData(int numRows, int numColumns)
    {
        int[][] data = new int[numRows][numColumns];

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numColumns; j++)
            {
                data[i][j] = ThreadLocalRandom.current().nextInt(LOWER_BOUND, UPPER_BOUND + 1);
            }
        }

        return data;
    }

    /**
     * Compute the sum of two matrices
     * @param a the first matrix
     * @param b the second matrix
     * @return a matrix which is the sum of the two matrices
     */
    public static Matrix computeSum(Matrix a, Matrix b)
    {
        // todo validate input
        int numRows = a.numRows;
        int numColumns = a.numColumns;
        // todo init sum with appropriate data size
        Matrix sum = new Matrix(numRows, numColumns, false);

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numColumns; j++)
            {
                sum.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }

        return sum;
    }

    /**
     * Compute the product of two matrices
     * @param a the first matrix
     * @param b the second matrix
     * @return the matrix which is the product of the two matrices
     */
    public static Matrix computeProduct(Matrix a, Matrix b)
    {
        // todo validate input
        // todo init product with appropriate data size
        // todo product should have numRows of a and numColumns of b
        Matrix product = new Matrix(a.numRows, b.numColumns, false);

        for (int i = 0; i < a.numRows; i++)
        {
            for (int j = 0; j < b.numColumns; j++)
            {
                for (int k = 0; k < a.numColumns; k++)
                {
                    product.data[i][j] += (a.data[i][k] * b.data[k][j]);
                }
            }
        }

        return product;
    }
}
