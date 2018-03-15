package assignmentA;

import quadratic.ComplexNumberPair;
import quadratic.Quadratic;
/**
 * Abstract:
 *
 * 3 cases:
 *
 * recall that the discriminant is equal to sqrt(b^2 - 4*a*c)
 *
 * 1) discriminant is equal to zero
 * b^2 = 4ac
 * sqrt(b^2 - 4ac) is 0
 *
 * 1) discriminant is negative
 * b^2 > 4ac
 *  is positive
 *
 * 3) discriminant is positive
 * b^2 < 4ac
 * sqrt(b^2 - 4ac) is negative
 * note: in this case, the result is an imaginary number
 *
 * Workings of the code:
 *
 * todo uml diagram of classes
 *
 * Challenges encountered during development:
 *
 * Review quadratic formula
 *
 * References:
 *
 * https://mathbitsnotebook.com/Algebra1/Quadratics/QDcomplex.html
 * http://www.purplemath.com/modules/quadform3.htm
 * http://www.purplemath.com/modules/quadform.htm
 * http://www.purplemath.com/modules/sqrquad2.htm#formula
 * http://www.math.com/students/calculators/source/quadratic.htm
 * http://www.mesacc.edu/~scotz47781/mat120/notes/quad_formula/quad_formula_practice.html
 *
 */
public class AssignmentA01
{
    public ComplexNumberPair run(double a, double b, double c)
    {
        Quadratic quadratic = new Quadratic(a, b, c);
        return quadratic.solve();
    }
}
