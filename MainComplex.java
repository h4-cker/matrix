import java.util.ArrayList;
import java.util.Scanner;

public class MainComplex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while (i != 0) {
            System.out.print("""
                    \nChoose:
                    \t0 - end
                    \t1 - create 2 matrices and add
                    \t2 - create 2 matrices and multiply
                    \t3 - create 1 matrix and transpose
                    \t4 - create 1 matrix and add constant number
                    \t5 - create 1 matrix and add constant number to the element
                    \t6 - create 1 matrix and get determinant
                    ? -\s""");
            i = scanner.nextInt();
            switch (i) {
                case 1 -> {
                    ArrayList<ComplexNums> mat1 = new ArrayList<>();
                    ArrayList<ComplexNums> mat2 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("2 matrix: input number of rows and cols: ");
                    int n1 = scanner.nextInt(), m1 = scanner.nextInt();
                    System.out.println("1 matrix (real imaginary): ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                        }
                    }
                    System.out.println("2 matrix (real imaginary): ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat2.add(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                        }
                    }

                    MatrixComplex matrix1 = new MatrixComplex(n, m, mat1);
                    MatrixComplex matrix2 = new MatrixComplex(n1, m1, mat2);
                    MatrixComplex matrix3 = matrix1.addMatrix(matrix2);
                    matrix3.printMatrix();
                }
                case 2 -> {
                    ArrayList<ComplexNums> mat1 = new ArrayList<>();
                    ArrayList<ComplexNums> mat2 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("2 matrix: input number of rows and cols: ");
                    int n1 = scanner.nextInt(), m1 = scanner.nextInt();
                    System.out.println("1 matrix (real imaginary): ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                        }
                    }
                    System.out.println("2 matrix (real imaginary): ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat2.add(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                        }
                    }

                    MatrixComplex matrix1 = new MatrixComplex(n, m, mat1);
                    MatrixComplex matrix2 = new MatrixComplex(n1, m1, mat2);
                    MatrixComplex matrix3 = matrix1.multiplyMatrix(matrix2);
                    matrix3.printMatrix();
                }
                case 3 -> {
                    ArrayList<ComplexNums> mat1 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("Matrix (real imaginary): ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                        }
                    }

                    MatrixComplex matrix1 = new MatrixComplex(n, m, mat1);
                    MatrixComplex matrix2 = matrix1.transpose();
                    matrix2.printMatrix();
                }
                case 4 -> {
                    ArrayList<ComplexNums> mat1 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("Matrix (real imaginary): ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                        }
                    }

                    MatrixComplex matrix1 = new MatrixComplex(n, m, mat1);
                    System.out.println("Number (real imaginary): ");
                    MatrixComplex matrix2 = matrix1.addConstant2Matrix(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                    matrix2.printMatrix();
                }
                case 5 -> {
                    ArrayList<ComplexNums> mat1 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("Matrix (real imaginary): ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                        }
                    }

                    MatrixComplex matrix1 = new MatrixComplex(n, m, mat1);
                    System.out.println("Number (real imaginary) and index: ");
                    MatrixComplex matrix2 = matrix1.addConstant2Element(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()), scanner.nextInt());
                    matrix2.printMatrix();
                }
                case 6 -> {
                    ArrayList<ComplexNums> mat1 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("Matrix (real imaginary): ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(new ComplexNums(scanner.nextDouble(), scanner.nextDouble()));
                        }
                    }

                    MatrixComplex matrix1 = new MatrixComplex(n, m, mat1);
                    System.out.printf("Determinant = %f + %f*i\n", matrix1.getDet().getReal(), matrix1.getDet().getImaginary());
                }
            }
        }
    }
}
