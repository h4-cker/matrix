import java.util.ArrayList;
import java.util.Scanner;

public class MainDouble {
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
                    ArrayList<Double> mat1 = new ArrayList<>();
                    ArrayList<Double> mat2 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("2 matrix: input number of rows and cols: ");
                    int n1 = scanner.nextInt(), m1 = scanner.nextInt();
                    System.out.println("1 matrix: ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(scanner.nextDouble());
                        }
                    }
                    System.out.println("2 matrix: ");
                    for (int j = 0; j < n1; j++) {
                        for (int k = 0; k < m1; k++) {
                            mat2.add(scanner.nextDouble());
                        }
                    }

                    MatrixDouble matrix1 = new MatrixDouble(n, m, mat1);
                    MatrixDouble matrix2 = new MatrixDouble(n1, m1, mat2);
                    MatrixDouble matrix3 = matrix1.addMatrix(matrix2);
                    matrix3.printMatrix();
                }
                case 2 -> {
                    ArrayList<Double> mat1 = new ArrayList<>();
                    ArrayList<Double> mat2 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("2 matrix: input number of rows and cols: ");
                    int n1 = scanner.nextInt(), m1 = scanner.nextInt();
                    System.out.println("1 matrix: ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(scanner.nextDouble());
                        }
                    }
                    System.out.println("2 matrix: ");
                    for (int j = 0; j < n1; j++) {
                        for (int k = 0; k < m1; k++) {
                            mat2.add(scanner.nextDouble());
                        }
                    }

                    MatrixDouble matrix1 = new MatrixDouble(n, m, mat1);
                    MatrixDouble matrix2 = new MatrixDouble(n1, m1, mat2);
                    MatrixDouble matrix3 = matrix1.multiplyMatrix(matrix2);
                    matrix3.printMatrix();
                }
                case 3 -> {
                    ArrayList<Double> mat1 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("Matrix: ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(scanner.nextDouble());
                        }
                    }

                    MatrixDouble matrix1 = new MatrixDouble(n, m, mat1);
                    MatrixDouble matrix2 = matrix1.transpose();
                    matrix2.printMatrix();
                }
                case 4 -> {
                    ArrayList<Double> mat1 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("Matrix: ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(scanner.nextDouble());
                        }
                    }

                    MatrixDouble matrix1 = new MatrixDouble(n, m, mat1);
                    System.out.println("Number: ");
                    MatrixDouble matrix2 = matrix1.addConstant2Matrix(scanner.nextDouble());
                    matrix2.printMatrix();
                }
                case 5 -> {
                    ArrayList<Double> mat1 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("Matrix: ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(scanner.nextDouble());
                        }
                    }

                    MatrixDouble matrix1 = new MatrixDouble(n, m, mat1);
                    System.out.println("Number and index: ");
                    MatrixDouble matrix2 = matrix1.addConstant2Element(scanner.nextDouble(), scanner.nextInt());
                    matrix2.printMatrix();
                }
                case 6 -> {
                    ArrayList<Double> mat1 = new ArrayList<>();
                    System.out.println("1 matrix: input number of rows and cols: ");
                    int n = scanner.nextInt(), m = scanner.nextInt();
                    System.out.println("Matrix: ");
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            mat1.add(scanner.nextDouble());
                        }
                    }

                    MatrixDouble matrix1 = new MatrixDouble(n, m, mat1);
                    System.out.printf("Determinant = %f\n", matrix1.getDet());
                }
            }
        }
    }
}
