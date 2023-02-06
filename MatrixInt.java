import java.util.ArrayList;

/**
 * Helps to work with <a href="java.lang.Integer">Integer</a> matrices and operations with them
 * @author Dmitry Antonov
 * @version 1.0
 */
public class MatrixInt implements MatrixTemplate<MatrixInt, Integer> {

    private final int row, col;
    private final ArrayList<Integer> matrix;

    /**
     * Default constructor
     * @param row Awaits to receive the number of rows
     * @param col Awaits to receive the number of columns
     * @param matrix Awaits to receive the matrix consists of Integer numbers
     */
    MatrixInt(int row, int col, ArrayList<Integer> matrix) {
        this.row = row;
        this.col = col;
        if (matrix.size() != row * col) {
            for (int i = 0; i < matrix.size() - row * col - 1; i++) {
                matrix.add(0);
            }
        }
        this.matrix = matrix;
    }

    /**
     * @return Number of rows
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * @return Number of columns
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * @return Determinant if possible
     * @exception ArithmeticException if the number of rows is not equal to the number of columns
     */
    @Override
    public Integer getDet() {
        if (row == col) {
            return determinant(this.matrix, this.row);
        } else {
            throw new ArithmeticException("Can't find determinant, matrix is not square");
        }
    }

    /**
     * @return Matrix of complex numbers
     */
    @Override
    public ArrayList<Integer> getMatrix() {
        return matrix;
    }

    /**
     * Adds the second matrix to the first
     * @param secondMatrix Awaits to receive a matrix
     * @return New matrix
     */
    @Override
    public MatrixInt addMatrix(MatrixInt secondMatrix) {
        MatrixInt newMatrix = new MatrixInt(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.matrix.size(); i++) {
            newMatrix.matrix.add(i, this.matrix.get(i) + secondMatrix.matrix.get(i));
        }
        return newMatrix;
    }

    /**
     * Adds the constant number to the whole matrix
     * @param constant Awaits to receive an Integer number
     * @return New matrix
     */
    @Override
    public MatrixInt addConstant2Matrix(Integer constant) {
        MatrixInt newMatrix = new MatrixInt(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.matrix.size(); i++) {
            newMatrix.matrix.add(i, this.matrix.get(i) + constant);
        }
        return newMatrix;
    }

    /**
     * Adds a constant to the specified element
     * @param constant Awaits to receive an Integer number
     * @param index Awaits to receive an index of the element
     * @return New matrix
     */
    @Override
    public MatrixInt addConstant2Element(Integer constant, int index){
        MatrixInt newMatrix = new MatrixInt(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.matrix.size(); i++) {
            if (i == index) {
                newMatrix.matrix.add(index, this.matrix.get(index) + constant);
            } else {
                newMatrix.matrix.add(i, this.matrix.get(i));
            }
        }
        return newMatrix;
    }

    /**
     * Multiplies the second matrix by the first
     * @param secondMatrix Awaits to receive a matrix
     * @return New matrix
     */
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
                    newMatrix.matrix.add(i * secondMatrix.col + j, s);
                }
            }
            return newMatrix;
        } else {
            throw new ArithmeticException("Can't multiply matrices of the given size");
        }
    }

    /**
     * Multiplies the matrix by the constant
     * @param constant Awaits to receive an Integer number
     * @return New matrix
     */
    @Override
    public MatrixInt multiplyConstant(Integer constant) {
        MatrixInt newMatrix = new MatrixInt(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.matrix.size(); i++) {
            newMatrix.matrix.add(i, this.matrix.get(i) * constant);
        }
        return newMatrix;
    }

    /**
     * Transposes the matrix
     * @return New matrix
     */
    @Override
    public MatrixInt transpose() {
        MatrixInt newMatrix = new MatrixInt(this.col, this.row, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                newMatrix.matrix.add(i * this.row + j, this.matrix.get(j * this.row + i));
            }
        }
        return newMatrix;
    }

    /**
     * Calculates the determinant of matrix
     * @param matrix Awaits to receive a matrix
     * @param degree Awaits to receive a matrix degree
     * @return New matrix
     */
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

    /**
     * Helps the determinant method
     * @return New matrix of a lower degree
     * @see MatrixInt#determinant(ArrayList, int)
     */
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

    /**
     * Prints the matrix
     */
    @Override
    public void printMatrix() {
        System.out.println("{");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.printf("%6d" , matrix.get(this.row * i + j));
            }
            System.out.println();
        }
        System.out.println("}");
    }
}
