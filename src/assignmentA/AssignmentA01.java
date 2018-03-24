package assignmentA;

import quadratic.ComplexNumberPair;
import quadratic.Quadratic;

public class AssignmentA01
{
    /**
     * Solve a quadratic given a, b, and c
     * @param a the first argument
     * @param b the second argument
     * @param c the third argument
     * @return the complex number pair representing the roots of the solution of the quadratic
     */
    public static ComplexNumberPair run(double a, double b, double c)
    {
        return new Quadratic(a, b, c).solve();
    }
}
