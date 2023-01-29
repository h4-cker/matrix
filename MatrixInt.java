import java.util.ArrayList;

public class MatrixInt implements MatrixTemplate<MatrixInt, Integer> {

    private final int row, col;
    private final ArrayList<Integer> matrix;

    MatrixInt(int row, int col, ArrayList<Integer> matrix) {
        this.row = row;
        this.col = col;
        this.matrix = matrix;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public Integer getDet() {
        if (row == col) {
            return determinant(this.matrix, this.row);
        } else {
            throw new ArithmeticException("Can't find determinant, matrix is not square");
        }
    }

    @Override
    public ArrayList<Integer> getMatrix() {
        return matrix;
    }

    @Override
    public MatrixInt addMatrix(MatrixInt secondMatrix) {
        MatrixInt newMatrix = new MatrixInt(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            newMatrix.matrix.set(i, this.matrix.get(i) + secondMatrix.matrix.get(i));
        }
        return newMatrix;
    }

    @Override
    public MatrixInt addConstant2Matrix(Integer constant) {
        MatrixInt newMatrix = new MatrixInt(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            newMatrix.matrix.set(i, this.matrix.get(i) + constant);
        }
        return newMatrix;
    }

    @Override
    public MatrixInt addConstant2Element(Integer constant, int index){
        MatrixInt newMatrix = new MatrixInt(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            if (i == index) {
                newMatrix.matrix.set(index, this.matrix.get(index) + constant);
            } else {
                newMatrix.matrix.set(i, this.matrix.get(i));
            }
        }
        return newMatrix;
    }

    @Override
    public MatrixInt multiplyMatrix(MatrixInt secondMatrix) {
        if (this.col == secondMatrix.row) {
            MatrixInt newMatrix = new MatrixInt(this.row, secondMatrix.col, new ArrayList<>(this.row * secondMatrix.col));
            for (int i = 0; i < this.row; ++i) {
                for (int j = 0; j < secondMatrix.col; ++j) {
                    int s = 0;
                    for (int k = 0; k < this.col; ++k) {
                        s += this.matrix.get(i * this.col + k) * secondMatrix.matrix.get(k * secondMatrix.col + j);
                    }
                    newMatrix.matrix.set(i * secondMatrix.col + j, s);
                }
            }
            return newMatrix;
        } else {
            throw new ArithmeticException("Can't multiply matrices");
        }
    }

    @Override
    public MatrixInt multiplyConstant(Integer constant) {
        MatrixInt newMatrix = new MatrixInt(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.row * this.col; i++) {
            newMatrix.matrix.set(i, this.matrix.get(i) * constant);
        }
        return newMatrix;
    }

    @Override
    public MatrixInt transpose() {
        MatrixInt newMatrix = new MatrixInt(this.col, this.row, new ArrayList<>(this.row * this.col));
        int j = newMatrix.matrix.size() - 1;
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            newMatrix.matrix.set(i, this.matrix.get(j));
            j++;
        }
        return newMatrix;
    }

    private Integer determinant(ArrayList<Integer> matrix, int degree) {
        int determinant = 0;
        if (degree == 1) {
            return matrix.get(0);
        }
        if (degree == 2) {
            return matrix.get(0) * matrix.get(3) - matrix.get(1) * matrix.get(2);
        }
        for (int i = 0; i < degree; i++) {
            determinant += (int)Math.pow(-1, i) * matrix.get(i) * determinant(makeMatrix(matrix, i, degree), degree - 1);
        }
        return determinant;
    }

    private ArrayList<Integer> makeMatrix(ArrayList<Integer> matrix, int col, int degree){
        ArrayList<Integer> lowerDegreeMatrix = new ArrayList<>((degree - 1) * (degree - 1));
        int k = 0;
        for (int i = 1; i < degree; i++) {
            for (int j = 0; j < degree; j++) {
                if (j != col) {
                    lowerDegreeMatrix.add(k, matrix.get(i * degree + j));
                    k++;
                }
            }
        }
        return lowerDegreeMatrix;
    }

    @Override
    public void printMatrix() {
        System.out.println("{");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.printf("%4s" , matrix.get(this.row * i + j));
            }
            System.out.println();
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        ArrayList<Integer> matrix = new ArrayList<>( 25);

        matrix.add(1);
        matrix.add(4);
        matrix.add(7);
        matrix.add(3);
        matrix.add(1);

        matrix.add(13);
        matrix.add(3);
        matrix.add(4);
        matrix.add(1);
        matrix.add(2);

        matrix.add(8);
        matrix.add(1);
        matrix.add(2);
        matrix.add(11);
        matrix.add(3);

        matrix.add(9);
        matrix.add(5);
        matrix.add(12);
        matrix.add(7);
        matrix.add(4);

        matrix.add(9);
        matrix.add(8);
        matrix.add(7);
        matrix.add(6);
        matrix.add(5);

        MatrixInt m = new MatrixInt(5, 5, matrix);
        m.printMatrix();
        System.out.println(m.getDet());
    }
}
