package matrix;

import java.util.Objects;

public class Matrix
{
    private int numColumns;
    private int numRows;

    public Matrix()
    {
        numColumns = 0;
        numRows = 0;
    }

    /**
     * Note: Constructor assumes valid input.
     *
     * @param inputArray a list of strings exactly size 2 containing a string representing the number of columns as the 0th element and a string representing the number of rows as the 1st element
     */
    public Matrix(int[] inputArray)
    {
        numColumns = inputArray[0];
        numRows = inputArray[1];
    }

    public Matrix(int numColumns, int numRows)
    {
        this.numColumns = numColumns;
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

    public int getNumRows()
    {
        return numRows;
    }

    public void setNumRows(int numRows)
    {
        this.numRows = numRows;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return numColumns == matrix.numColumns &&
                numRows == matrix.numRows;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(numColumns, numRows);
    }

    @Override
    public String toString()
    {
        return "Matrix{" +
                "numColumns=" + numColumns +
                ", numRows=" + numRows +
                '}';
    }
}
