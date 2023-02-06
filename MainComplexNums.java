import java.util.ArrayList;
import java.util.Scanner;

public class MainComplexNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while (i != 0) {
            System.out.print("""
                    \nChoose:
                    \t0 - end
                    \t1 - create 2 numbers and add
                    \t2 - create 2 numbers and subtract
                    \t3 - create 2 numbers and multiply
                    \t4 - create 2 numbers and divide
                    \t5 - create 1 number and take a sqrt of N-degree
                    \t6 - create 1 number and raise to a degree
                    \t7 - create 1 number and print in trigonometric form
                    \t8 - create 1 number and print in exponential form
                    ? -\s""");
            i = scanner.nextInt();
            switch (i) {
                case 1 -> {
                    System.out.print("\nFirst number (real imaginary): ");
                    ComplexNums first = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first.printAlgebraic();
                    System.out.print("\nSecond number (real imaginary): ");
                    ComplexNums second = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    second.printAlgebraic();
                    System.out.print("\nresult = ");
                    first.add(second).printAlgebraic();
                }
                case 2 -> {
                    System.out.print("\nFirst number (real imaginary): ");
                    ComplexNums first1 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first1.printAlgebraic();
                    System.out.print("\nSecond number (real imaginary): ");
                    ComplexNums second1 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    second1.printAlgebraic();
                    System.out.print("\nresult = ");
                    first1.subtract(second1).printAlgebraic();
                }
                case 3 -> {
                    System.out.print("\nFirst number (real imaginary): ");
                    ComplexNums first2 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first2.printAlgebraic();
                    System.out.print("\nSecond number (real imaginary): ");
                    ComplexNums second2 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    second2.printAlgebraic();
                    System.out.print("\nresult = ");
                    first2.multiply(second2).printAlgebraic();
                }
                case 4 -> {
                    System.out.print("\nFirst number (real imaginary): ");
                    ComplexNums first3 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first3.printAlgebraic();
                    System.out.print("\nSecond number (real imaginary): ");
                    ComplexNums second3 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first3.printAlgebraic();
                    System.out.print("\nresult = ");
                    first3.divide(second3).printAlgebraic();
                }
                case 5 -> {
                    System.out.print("\nNumber (real imaginary): ");
                    ComplexNums first4 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first4.printAlgebraic();
                    System.out.print("\nSqrt degree: ");
                    int degree = scanner.nextInt();
                    ArrayList<ComplexNums> roots = first4.complexSqrt(degree);
                    System.out.print("\nRoots:");
                    for (ComplexNums root : roots) {
                        System.out.print("\n\t");
                        root.printAlgebraic();
                    }
                }
                case 6 -> {
                    System.out.print("\nNumber (real imaginary): ");
                    ComplexNums first5 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first5.printAlgebraic();
                    System.out.print("\nPower: ");
                    int pow = scanner.nextInt();
                    System.out.print("\nresult - ");
                    first5.complexPow(pow).printAlgebraic();
                }
                case 7 -> {
                    System.out.print("\nNumber (real imaginary): ");
                    ComplexNums first5 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first5.printTrigonometric();
                }
                case 8 -> {
                    System.out.print("\nNumber (real imaginary): ");
                    ComplexNums first5 = new ComplexNums(scanner.nextDouble(), scanner.nextDouble());
                    first5.printExponential();
                }
            }
        }
    }
}
