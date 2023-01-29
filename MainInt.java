import java.util.ArrayList;
import java.util.Arrays;

public class MainInt {
    public static void main(String[] args) {
        ArrayList<Integer> matrix = new ArrayList<>(Arrays.asList
                (1, 4, 3, 3, 1, 6,
                13, 3, 4, 1, 2, 2,
                8, 1, 2, 11, 3, 18,
                9, 5, 12, 7, 4, 4,
                9, 8, 7, 6, 5, 7,
                7, 33, 11, 2, 4, 87)
        );

        ArrayList<Integer> matrix1 = new ArrayList<>(Arrays.asList
                (1, 4, 3,
                13, 3, 4,
                8, 2, 3)
        );

        ArrayList<Integer> matrix2 = new ArrayList<>(Arrays.asList
                (11, 7, 0,
                3, 4, 22,
                6, 5, 2)
        );

        MatrixInt m1 = new MatrixInt(3, 3, matrix1);
        MatrixInt m2 = new MatrixInt(3, 3, matrix2);
        MatrixInt m3;

        m3 = m2.addMatrix(m1);
        m3.printMatrix();

        m3 = m2.addConstant2Matrix(13);
        m3.printMatrix();

        m3 = m2.addConstant2Element(1000, 3);
        m3.printMatrix();

        m3 = m2.multiplyConstant(100);
        m3.printMatrix();

        m3 = m2.multiplyMatrix(m1);
        m3.printMatrix();

        m3 = m1.transpose();
        m3.printMatrix();

        System.out.println(m1.getDet());

        MatrixInt m = new MatrixInt(6, 6, matrix);
        System.out.println(m.getRow() + " " + m.getCol());
        System.out.println(m.getMatrix());
        System.out.println();
        m.printMatrix();
        System.out.println(m.getDet());
    }
}
