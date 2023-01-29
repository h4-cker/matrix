import java.util.ArrayList;
import java.util.Arrays;

public class MainDouble {
    public static void main(String[] args) {
        ArrayList<Double> matrix = new ArrayList<>(Arrays.asList
                (1.42, 4.22, 3.235, 3.11, 1.01, 6.44,
                13.21, 3.11, 4.0, 1.111, 2.087, 2.42,
                8.345, 1.42, 2.645, 11.345, 3.34, 18.66,
                9.644, 5.666, 12.83, 7.88, 4.123, 4.77,
                9.643, 8.854, 7.99, 6.08, 5.24, 7.31,
                7.22, 33.012, 11.423, 2.75, 4.44, 87.18)
        );

        ArrayList<Double> matrix1 = new ArrayList<>(Arrays.asList
                (1.1, 4.4, 3.3,
                13.13, 3.3, 4.4,
                8.8, 2.2, 3.3)
        );

        ArrayList<Double> matrix2 = new ArrayList<>(Arrays.asList
                (11.11, 7.7, 0.0,
                3.3, 4.4, 22.22,
                6.6, 5.5, 2.2)
        );

        MatrixDouble m1 = new MatrixDouble(3, 3, matrix1);
        MatrixDouble m2 = new MatrixDouble(3, 3, matrix2);
        MatrixDouble m3;

        m3 = m2.addMatrix(m1);
        m3.printMatrix();

        m3 = m2.addConstant2Matrix(13.1);
        m3.printMatrix();

        m3 = m2.addConstant2Element(1000.1, 3);
        m3.printMatrix();

        m3 = m2.multiplyConstant(100.1);
        m3.printMatrix();

        m3 = m2.multiplyMatrix(m1);
        m3.printMatrix();

        m3 = m1.transpose();
        m3.printMatrix();

        System.out.println(m1.getDet());
        System.out.println();

        MatrixDouble m = new MatrixDouble(6, 6, matrix);
        System.out.println(m.getRow() + " " + m.getCol());
        System.out.println(m.getMatrix());
        System.out.println();
        m.printMatrix();
        System.out.println(m.getDet());
    }
}
