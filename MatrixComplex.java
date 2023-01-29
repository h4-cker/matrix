import java.util.ArrayList;

public class MatrixComplex implements MatrixTemplate<MatrixComplex, ComplexNums>{

    private final int row, col;
    private final ArrayList<ComplexNums> matrix;

    MatrixComplex(int row, int col, ArrayList<ComplexNums> matrix) {
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
    public ComplexNums getDet() {
        if (row == col) {
            return determinant(this.matrix, this.row);
        } else {
            throw new ArithmeticException("Can't find determinant, matrix is not square");
        }
    }

    @Override
    public ArrayList<ComplexNums> getMatrix() {
        return matrix;
    }

    @Override
    public MatrixComplex addMatrix(MatrixComplex secondMatrix) {
        MatrixComplex newMatrix = new MatrixComplex(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            newMatrix.matrix.set(i, this.matrix.get(i).add(secondMatrix.matrix.get(i)));
        }
        return newMatrix;
    }

    @Override
    public MatrixComplex addConstant2Matrix(ComplexNums constant) {
        MatrixComplex newMatrix = new MatrixComplex(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            newMatrix.matrix.set(i, this.matrix.get(i).add(constant));
        }
        return newMatrix;
    }

    @Override
    public MatrixComplex addConstant2Element(ComplexNums constant, int index){
        MatrixComplex newMatrix = new MatrixComplex(this.row, this.col, new ArrayList<>(this.row * this.col));
        newMatrix.matrix.set(index, this.matrix.get(index).add(constant));
        return newMatrix;
    }

    @Override
    public MatrixComplex multiplyMatrix(MatrixComplex secondMatrix) {
        if (this.col == secondMatrix.row) {
            MatrixComplex newMatrix = new MatrixComplex(this.row, secondMatrix.col, new ArrayList<>(this.row * secondMatrix.col));
            for (int i = 0; i < this.row; ++i) {
                for (int j = 0; j < secondMatrix.col; ++j) {
                    ComplexNums s = new ComplexNums(0, 0);
                    for (int k = 0; k < this.col; ++k) {
                        s.add(this.matrix.get(i * this.col + k).multiply(secondMatrix.matrix.get(k * secondMatrix.col + j)));
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
    public MatrixComplex multiplyConstant(ComplexNums constant) {
        MatrixComplex newMatrix = new MatrixComplex(this.row, this.col, new ArrayList<>(this.row * this.col));
        for (int i = 0; i < this.row * this.col; i++) {
            newMatrix.matrix.set(i, this.matrix.get(i).multiply(constant));
        }
        return newMatrix;
    }

    @Override
    public MatrixComplex transpose() {
        MatrixComplex newMatrix = new MatrixComplex(this.col, this.row, new ArrayList<>(this.row * this.col));
        int j = newMatrix.matrix.size() - 1;
        for (int i = 0; i < newMatrix.matrix.size(); i++) {
            newMatrix.matrix.set(i, this.matrix.get(j));
            j++;
        }
        return newMatrix;
    }

    @Override
    public ComplexNums determinant(ArrayList<ComplexNums> matrix, int degree) {
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
