package assignmentA;

import matrix.Matrix;
import util.FileUtil;
import java.util.List;

/**
 * References:
 * <p>
 * matrix addition: http://www.purplemath.com/modules/mtrxadd.htm
 * matrix multiplication: https://www.mathsisfun.com/algebra/matrix-multiplying.html
 */

public class AssignmentA03
{
    public void run(String fileName)
    {
        generateRandomMatrixFromFileInput(fileName);
    }

    public Matrix generateRandomMatrixFromFileInput(String fileName)
    {
        List<String> stringList = FileUtil.readFile(fileName);

        int[] inputArray = AssignmentA03.validateAndTransformInputList(stringList);

        if (inputArray == null)
        {
            System.out.print("\nError: Invalid matrix input, exiting...");
            return null;
        }

        Matrix matrix = new Matrix(inputArray);
        System.out.print("\n" + matrix.toString());
        return matrix;
    }

    /**
     * Validate input list and then transform from List of Object types to array of int primitive types.
     *
     * @param matrixInputList
     * @return
     */
    private static int[] validateAndTransformInputList(List<String> matrixInputList)
    {
        int[] inputArray = null;

        if (matrixInputList.isEmpty())
        {
            // Validation FAILED
            System.out.print("\nMatrix input validation failed: input list is empty");
        }
        else if (matrixInputList.size() < 2)
        {
            // Validation FAILED
            System.out.print("\nMatrix input validation failed: input list size is too small");
        }
        else if (matrixInputList.size() > 2)
        {
            // Validation FAILED
            System.out.print("\nMatrix input validation failed: input list size is too large");
        }
        else
        {
            inputArray = new int[2];
            for (int i = 0; i < matrixInputList.size(); i++)
            {
                String line = matrixInputList.get(i);
                int input = extractInputFromLine(line);
                if (!inputIsValid(input))
                {
                    // Validation FAILED
                    return null;
                }
                else
                {
                    inputArray[i] = input;
                }
            }
        }

        return inputArray;
    }

    private static boolean inputIsValid(int input)
    {
        return input != -1;
    }

    private static int extractInputFromLine(String line)
    {
        int input;

        // Find index of '=' character
        int index = 0;
        for (char c : line.toCharArray())
        {
            index++;
            if (c == '=')
            {
                break;
            }
        }

        // Extract input
        int s = index;
        int e = line.length();
        String inputString = line.substring(s, e);

        // Ensure input is 'int' type
        try
        {
            input = Integer.parseInt(inputString);
        }
        catch (NumberFormatException exc)
        {
            input = -1;
        }

        return input;
    }
}
