package assignmentA;

import matrix.Matrix;
import util.FileUtil;
import java.util.List;

public class AssignmentA03
{
    /**
     * Generate a random matrix from file input
     * @param fileName the file which specifies the number of columns and rows defining the matrix
     * @return the matrix
     */
    public static Matrix generateRandomMatrixFromFileInput(String fileName)
    {
        List<String> stringList = FileUtil.readFile(fileName);

        int[] inputArray = AssignmentA03.validateAndTransformInputList(stringList);

        if (inputArray == null)
        {
            System.out.print("\nError: Invalid matrix input, exiting...");
            return null;
        }

        return new Matrix(inputArray);
    }

    /**
     * Validate input list and then transform from List of Object types to array of int primitive types.
     * @param matrixInputList a matrix input list
     * @return an array of size 2 containing the number of rows and number of columns of the matrix
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

    /**
     * Whether or not the input is valid.
     * @param input the input to validate
     * @return whether or not the input is valid
     */
    private static boolean inputIsValid(int input)
    {
        return input != -1;
    }

    /**
     * Extracts input from the given line
     * @param line the line to extract input from
     * @return the value extracted from the line
     */
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
