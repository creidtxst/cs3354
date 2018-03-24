package array;

import java.util.Objects;

public class ArrayIndex
{
    private int originalIndex;
    private int value;

    public ArrayIndex()
    {
        originalIndex = -1;
        value = -1;
    }

    public ArrayIndex(int originalIndex, int value)
    {
        this.originalIndex = originalIndex;
        this.value = value;
    }

    public int getOriginalIndex()
    {
        return originalIndex;
    }

    public void setOriginalIndex(int originalIndex)
    {
        this.originalIndex = originalIndex;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayIndex that = (ArrayIndex) o;
        return originalIndex == that.originalIndex &&
                value == that.value;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(originalIndex, value);
    }

    @Override
    public String toString()
    {
        return "ArrayIndex{" +
                "originalIndex=" + originalIndex +
                ", value=" + value +
                '}';
    }
}
