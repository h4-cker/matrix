import java.util.ArrayList;

public class MainComplexNums {
    public static void main(String[] args) {
        ComplexNums c = new ComplexNums(0.1, 0.9);
        ComplexNums c1 = new ComplexNums(1.3, 0.8);
        ComplexNums c2 = new ComplexNums(2.5, 0.7);
        ComplexNums c3 = new ComplexNums(3.7, 0.6);
        ComplexNums c4 = new ComplexNums(4.9, 0.5);
        ComplexNums c5 = new ComplexNums(5.1, 0.4);
        ComplexNums n;

        System.out.println(c1.getReal() + " " + c1.getImaginary() + " " + c1.getRParameter() + " " + c1.getFiParameter());
        c1.printAlgebraic();
        System.out.println();
        c1.printTrigonometric();
        System.out.println();
        c1.printExponential();
        System.out.println();

        n = c.add(c1);
        n.printAlgebraic();
        System.out.println();

        n = c2.subtract(c3);
        n.printAlgebraic();
        System.out.println();

        n = c4.multiply(c5);
        n.printAlgebraic();
        System.out.println();

        n = c5.divide(c1);
        n.printAlgebraic();
        System.out.println();

        System.out.println(c5.abs());

        ArrayList<ComplexNums> roots = c5.complexSqrt(3);
        for (ComplexNums root : roots) {
            root.printAlgebraic();
            System.out.println();
        }

        n = c4.complexPow(3);
        n.printAlgebraic();
        System.out.println();
    }
}
