import java.util.ArrayList;

public class MainComplex {
    public static void main(String[] args) {
        ArrayList<ComplexNums> matrix = new ArrayList<>(36);
        for (int i = 0; i < 36; i++) {
            ComplexNums cn = new ComplexNums(1.1 * (double) i, 1.05 * (double) i);
            matrix.add(i, cn);
        }

        ArrayList<ComplexNums> matrix1 = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            ComplexNums cn = new ComplexNums(1.1 * (double) i, 1.05 * (double) i);
            matrix1.add(i, cn);
        }

        ArrayList<ComplexNums> matrix2 = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            ComplexNums cn = new ComplexNums(1.1 * (double) i, 1.05 * (double) i);
            matrix2.add(i, cn);
        }

        MatrixComplex m1 = new MatrixComplex(3, 3, matrix1);
        m1.printMatrix();
        MatrixComplex m2 = new MatrixComplex(3, 3, matrix2);
        m2.printMatrix();
        MatrixComplex m3;

//        m3 = m2.addMatrix(m1);
//        m3.printMatrix();
//
//        ComplexNums cn = new ComplexNums(1.23, 2.34);
//        m3 = m2.addConstant2Matrix(cn);
//        m3.printMatrix();
//
//        ComplexNums cn1 = new ComplexNums(1000.23, 1000.34);
//        m3 = m2.addConstant2Element(cn1, 3);
//        m3.printMatrix();

        ComplexNums cn2 = new ComplexNums(100.1, 100.1);
        m3 = m2.multiplyConstant(cn2);
        m3.printMatrix();

        m3 = m2.multiplyMatrix(m1);
        m3.printMatrix();

        m3 = m1.transpose();
        m3.printMatrix();

        System.out.printf("%.3f + %.3f*i\n", m1.getDet().getReal(), m1.getDet().getImaginary());

        MatrixComplex m = new MatrixComplex(6, 6, matrix);
        System.out.println(m.getRow() + " " + m.getCol());
        System.out.println(m.getMatrix());
        System.out.println();
        m.printMatrix();
        System.out.println(m.getDet());
    }
}
