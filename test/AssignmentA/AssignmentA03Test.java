package AssignmentA;

import assignmentA.AssignmentA03;
import matrix.Matrix;

public class AssignmentA03Test
{
    private static final String BASE_FILE_PATH = "/Users/creid/Desktop/NWR/school/spring-2018/TXSTRR/CS-3354/cs3354/test/AssignmentA/matrixInput/";

    public static void main(String[] args)
    {
        AssignmentA03Test.pretestSum01();
        AssignmentA03Test.pretestProduct01();
        AssignmentA03Test.pretestProduct02();
        AssignmentA03Test.test01();
    }

    /**
     * Validate logic by adding non-random matrices
     */
    private static void pretestSum01()
    {
        Matrix matrix1 = new Matrix(2,
                3,
                new int[][]{
                        {7, 10, 12},
                        {5, 1, 3}
                });
        Matrix matrix2 = new Matrix(2,
                3,
                new int[][]{
                        {3, -8, 0},
                        {-4, 6, -11}
                });
        Matrix expectedSumOfMatrices = new Matrix(2,
                3,
                new int[][]{
                        {10, 2, 12},
                        {1, 7, -8}
                });

        Matrix sum = Matrix.computeSum(matrix1, matrix2);

        try
        {
            validate("AssignmentA03Test.pretestSum01", matrix1, matrix2, sum, expectedSumOfMatrices);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    /**
     * Validate logic by multiplying non-random matrices
     */
    private static void pretestProduct01()
    {
        Matrix matrix1 = new Matrix(2,
                2,
                new int[][]{
                        {2, 3},
                        {4, 6}
                });
        Matrix matrix2 = new Matrix(2,
                1,
                new int[][]{
                        {8},
                        {9}
                });
        Matrix expectedProductOfMatrices = new Matrix(2,
                1,
                new int[][]{
                        {43},
                        {86}
                });

        Matrix product = Matrix.computeProduct(matrix1, matrix2);

        try
        {
            validate("AssignmentA03Test.pretestProduct01", matrix1, matrix2, product, expectedProductOfMatrices);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    /**
     * Validate logic by multiplying non-random matrices
     */
    private static void pretestProduct02()
    {
        Matrix matrix1 = new Matrix(2,
                3,
                new int[][]{
                        {1, 3, 5},
                        {2, 4, 6}
                });
        Matrix matrix2 = new Matrix(3,
                2,
                new int[][]{
                        {3, 6},
                        {1, 4},
                        {5, 2}
                });
        Matrix expectedProductOfMatrices = new Matrix(2,
                2,
                new int[][]{
                        {31, 28},
                        {40, 40}
                });

        Matrix product = Matrix.computeProduct(matrix1, matrix2);

        try
        {
            validate("AssignmentA03Test.pretestProduct02", matrix1, matrix2, product, expectedProductOfMatrices);
        }
        catch (Exception exc)
        {
            System.out.print("\n\n" + exc);
        }
    }

    private static void test01()
    {
        String fileName1 = BASE_FILE_PATH + "matrixInput01.txt";
        String fileName2 = BASE_FILE_PATH + "matrixInput02.txt";

        Matrix matrix1 = AssignmentA03.generateRandomMatrixFromFileInput(fileName1);
        Matrix matrix2 = AssignmentA03.generateRandomMatrixFromFileInput(fileName2);

        Matrix sum = Matrix.computeSum(matrix1, matrix2);
        Matrix product = Matrix.computeProduct(matrix1, matrix2);

        System.out.print("\nmatrix1:" + matrix1 + "\nmatrix2: " + matrix2 + "\nsum: " + sum.toString() + "\nproduct: " + product.toString());
    }

    public static void validate(String name, Matrix in1, Matrix in2, Matrix out, Matrix expectedOut) throws Exception
    {
        if (!Matrix.compare(expectedOut, out))
        {
            throw new Exception(name + " FAILED - expected: " + expectedOut + " actual: " + out + "\n");
        }
        System.out.print(name + "\n");
        System.out.print("---------------------\n");
        System.out.print("Matrix 1:  " + in1);
        System.out.print("\nMatrix 2:  " + in2);
        System.out.print("\nout:     " + out);
        System.out.print("\n---------------------\n");
    }
}
