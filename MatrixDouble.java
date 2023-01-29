import java.util.ArrayList;

public class MatrixDouble implements MatrixTemplate<MatrixDouble, Double> {

    private final int row, col;
    private final ArrayList<Double> matrix;

    MatrixDouble(int row, int col, ArrayList<Double> matrix) {
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
    public Double getDet() {
        if (row == col) {
            return determinant(this.matrix, this.row);
        } else {
            throw new ArithmeticException("Can't find determinant, matrix is not square");
        }
    }

    @Override
    public ArrayList<Double> getMatrix() {
        return matrix;
    }

    @Override
    public MatrixDouble addMatrix(MatrixDouble secondMatrix) {
        MatrixDouble newMatrix = new MatrixDouble(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.row * this.col; i++) {
            newMatrix.matrix.set(i, this.matrix.get(i) + secondMatrix.matrix.get(i));
        }
        return newMatrix;
    }

    @Override
    public MatrixDouble addConstant2Matrix(Double constant) {
        MatrixDouble newMatrix = new MatrixDouble(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            newMatrix.matrix.set(i, this.matrix.get(i) + constant);
        }
        return newMatrix;
    }

    @Override
    public MatrixDouble addConstant2Element(Double constant, int index){
        MatrixDouble newMatrix = new MatrixDouble(this.row, this.col, new ArrayList<>(this.row * this.col));
        newMatrix.matrix.set(index, this.matrix.get(index) + constant);
        return newMatrix;
    }

    @Override
    public MatrixDouble multiplyMatrix(MatrixDouble secondMatrix) {
        if (this.col == secondMatrix.row) {
            MatrixDouble newMatrix = new MatrixDouble(this.row, secondMatrix.col, new ArrayList<>(this.row * secondMatrix.col));
            for (int i = 0; i < this.row; ++i) {
                for (int j = 0; j < secondMatrix.col; ++j) {
                    double s = 0;
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
    public MatrixDouble multiplyConstant(Double constant) {
        MatrixDouble newMatrix = new MatrixDouble(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.row * this.col; i++) {
            newMatrix.matrix.set(i, this.matrix.get(i) * constant);
        }
        return newMatrix;
    }

    @Override
    public MatrixDouble transpose() {
        MatrixDouble newMatrix = new MatrixDouble(this.col, this.row, new ArrayList<>(this.row * this.col));
        int j = newMatrix.matrix.size() - 1;
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            newMatrix.matrix.set(i, this.matrix.get(j));
            j++;
        }
        return newMatrix;
    }

    @Override
    public Double determinant(ArrayList<Double> matrix, int degree) {
        double determinant = 0;
        if (degree == 1) {
            return matrix.get(0);
        }
        if (degree == 2) {
            return matrix.get(0) * matrix.get(3) - matrix.get(1) * matrix.get(2);
        }
        for (int i = 0; i < degree; i++) {
            determinant += Math.pow(-1, i) * matrix.get(i) * determinant(makeMatrix(matrix, i, degree), degree - 1);
        }
        return determinant;
    }

    private ArrayList<Double> makeMatrix(ArrayList<Double> matrix, int col, int degree){
        ArrayList<Double> lowerDegreeMatrix = new ArrayList<>((degree - 1) * (degree - 1));
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
}
