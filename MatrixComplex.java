import java.util.ArrayList;

/**
 * Helps to work with <a href="ComplexNums">ComplexNums</a> matrices and operations with them
 * @author Dmitry Antonov
 * @version 1.0
 */
public class MatrixComplex implements MatrixTemplate<MatrixComplex, ComplexNums>{

    private final int row, col;
    private final ArrayList<ComplexNums> matrix;

    /**
     * Default constructor
     * @param row Awaits to receive the number of rows
     * @param col Awaits to receive the number of columns
     * @param matrix Awaits to receive the matrix consists of complex numbers
     */
    MatrixComplex(int row, int col, ArrayList<ComplexNums> matrix) {
        this.row = row;
        this.col = col;
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
    public ComplexNums getDet() {
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
    public ArrayList<ComplexNums> getMatrix() {
        return matrix;
    }

    /**
     * Adds the second matrix to the first
     * @param secondMatrix Awaits to receive a matrix
     * @return New matrix
     */
    @Override
    public MatrixComplex addMatrix(MatrixComplex secondMatrix) {
        MatrixComplex newMatrix = new MatrixComplex(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.matrix.size(); i++) {
            newMatrix.matrix.add(i, this.matrix.get(i).add(secondMatrix.matrix.get(i)));
        }
        return newMatrix;
    }

    /**
     * Adds the constant number to the whole matrix
     * @param constant Awaits to receive a complex number
     * @return New matrix
     */
    @Override
    public MatrixComplex addConstant2Matrix(ComplexNums constant) {
        MatrixComplex newMatrix = new MatrixComplex(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.matrix.size(); i++) {
            newMatrix.matrix.add(i, this.matrix.get(i).add(constant));
        }
        return newMatrix;
    }

    /**
     * Adds a constant to the specified element
     * @param constant Awaits to receive a complex number
     * @param index Awaits to receive an index of the element
     * @return New matrix
     */
    @Override
    public MatrixComplex addConstant2Element(ComplexNums constant, int index){
        MatrixComplex newMatrix = new MatrixComplex(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.matrix.size(); i++) {
            if (i == index) {
                newMatrix.matrix.add(index, this.matrix.get(index).add(constant));
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
    public MatrixComplex multiplyMatrix(MatrixComplex secondMatrix) {
        if (this.col == secondMatrix.row) {
            MatrixComplex newMatrix = new MatrixComplex(this.row, secondMatrix.col, new ArrayList<>(this.row * secondMatrix.col));
            for (int i = 0; i < this.row; ++i) {
                for (int j = 0; j < secondMatrix.col; ++j) {
                    ComplexNums s = new ComplexNums(0, 0);
                    for (int k = 0; k < this.col; ++k) {
                        s = s.add(this.matrix.get(i * this.col + k).multiply(secondMatrix.matrix.get(k * secondMatrix.col + j)));
                    }
                    newMatrix.matrix.add(i, s);
                }
            }
            return newMatrix;
        } else {
            throw new ArithmeticException("Can't multiply matrices of the given size");
        }
    }

    /**
     * Multiplies the matrix by the constant
     * @param constant Awaits to receive a complex number
     * @return New matrix
     */
    @Override
    public MatrixComplex multiplyConstant(ComplexNums constant) {
        MatrixComplex newMatrix = new MatrixComplex(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.matrix.size(); i++) {
            newMatrix.matrix.add(i, this.matrix.get(i).multiply(constant));
        }
        return newMatrix;
    }

    /**
     * Transposes the matrix
     * @return New matrix
     */
    @Override
    public MatrixComplex transpose() {
        MatrixComplex newMatrix = new MatrixComplex(this.col, this.row, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                newMatrix.matrix.add(i * row + j, this.matrix.get(j * row + i));
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
    private ComplexNums determinant(ArrayList<ComplexNums> matrix, int degree) {
        ComplexNums determinant = null;
        if (degree == 1) {
            return matrix.get(0);
        }
        if (degree == 2) {
            return (matrix.get(0).multiply(matrix.get(3))).subtract(matrix.get(1).multiply(matrix.get(2)));
        }
        for (int i = 0; i < degree; i++) {
            ComplexNums minus = new ComplexNums(Math.pow(-1, i), Math.pow(-1, i));
            determinant = minus.multiply((matrix.get(i)).multiply(determinant(makeMatrix(matrix, i, degree), degree - 1)));
        }
        return determinant;
    }

    /**
     * Helps the determinant method
     * @return New matrix of a lower degree
     * @see MatrixComplex#determinant(ArrayList, int)
     */
    private ArrayList<ComplexNums> makeMatrix(ArrayList<ComplexNums> matrix, int col, int degree){
        ArrayList<ComplexNums> lowerDegreeMatrix = new ArrayList<>((degree - 1) * (degree - 1));
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
                matrix.get(this.row * i + j).printAlgebraic();
            }
            System.out.println();
        }
        System.out.println("}");
    }
}
