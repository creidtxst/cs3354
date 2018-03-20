package assignmentA;

import quadratic.ComplexNumberPair;
import quadratic.Quadratic;

public class AssignmentA01
{
    public ComplexNumberPair run(double a, double b, double c)
    {
        Quadratic quadratic = new Quadratic(a, b, c);
        return quadratic.solve();
    }
}

