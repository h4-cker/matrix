import java.util.ArrayList;

/**
 * Helps to work with complex numbers and operations with them
 * @author Dmitry Antonov
 * @version 1.0
 */
public class ComplexNums {

    private final double real, imaginary, rParameter, fiParameter;

    /**
     * Default constructor
     * @param real Awaits to receive a real part of number
     * @param imaginary Awaits to receive an imaginary part of number
     */
    ComplexNums(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        this.rParameter = abs();
        this.fiParameter = Math.atan(imaginary / real);
    }

    /**
     * @return Real part of complex number
     */
    public double getReal() {
        return real;
    }

    /**
     * @return Imaginary part of complex number
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * @return R-parameter from trigonometric form of complex number
     */
    public double getRParameter() {
        return rParameter;
    }

    /**
     * @return Fi-parameter from trigonometric form of complex number
     */
    public double getFiParameter() {
        return fiParameter;
    }

    /**
     * Adds the value of the given complex number (result = this + second)
     * @param second Awaits to receive a complex number
     * @return New complex number
     */
    public ComplexNums add(ComplexNums second) {
        return new ComplexNums(
                this.real + second.real,
                this.imaginary + second.imaginary
        );
    }

    /**
     * Subtracts the value of the given complex number (result = this - second)
     * @param second Awaits to receive a complex number
     * @return New complex number
     */
    public ComplexNums subtract(ComplexNums second) {
        return new ComplexNums(
                this.real - second.real,
                this.imaginary - second.imaginary
        );
    }

    /**
     * Multiples the value of the given complex number (result = this * second)
     * @param second Awaits to receive a complex number
     * @return New complex number
     */
    public ComplexNums multiply(ComplexNums second) {
        return new ComplexNums(
                this.real * second.real - this.imaginary * second.imaginary,
                this.imaginary * second.real + this.real * second.imaginary
        );
    }

    /**
     * Divides the value of the given complex number (result = this / second)
     * @param second Awaits to receive a complex number
     * @return New complex number
     */
    public ComplexNums divide(ComplexNums second) {
        double part = second.real * second.real + second.imaginary * second.imaginary;
        return new ComplexNums(
                (this.real * second.real + this.imaginary * second.imaginary) / part,
                (this.imaginary * second.real + this.real * second.imaginary) / part
        );
    }

    /**
     * @return Absolute value of a complex number
     */
    public double abs() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    /**
     * @param degree Awaits to receive a root degree
     * @return ArrayList<ComplexNums> of complex roots
     */
    public ArrayList<ComplexNums> complexSqrt(int degree) {
        ArrayList<ComplexNums> roots = new ArrayList<>();
        double sqrtFromR = Math.pow(rParameter, 1.0 / degree);
        for (int k = 0; k < degree; k++) {
            roots.add(k, new ComplexNums(
                    sqrtFromR * Math.cos((fiParameter + 2 * Math.PI * k) / degree),
                    sqrtFromR * Math.sin((fiParameter + 2 * Math.PI * k) / degree)
                    )
            );
        }
        return roots;
    }

    /**
     * Raises a complex number to a given power
     * @param power Awaits to receive a power
     * @return New complex number
     */
    public ComplexNums complexPow(int power) {
        return new ComplexNums(
                Math.pow(rParameter, power) * Math.cos(power * fiParameter),
                Math.pow(rParameter, power) * Math.sin(power * fiParameter)
        );
    }

    /**
     * Prints an algebraic form of complex number
     */
    public void printAlgebraic() {
        System.out.printf("%10.3f + %.3f*i", this.real, this.imaginary);
    }

    /**
     * Prints a trigonometric form of complex number
     */
    public void printTrigonometric() {
        System.out.printf("%10.3f * (cos(%.3f) + i*sin(%.3f))", this.rParameter, this.fiParameter, this.fiParameter);
    }

    /**
     * Prints an exponential form of complex number
     */
    public void printExponential() {
        System.out.printf("%10.3f * e^(%.3f*i)", this.rParameter, this.fiParameter);
    }
}
