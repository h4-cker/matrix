import java.util.ArrayList;

public interface MatrixTemplate<T1, T2> {
    int getRow();
    int getCol();
    T2 getDet();
    ArrayList<T2> getMatrix();
    T1 addMatrix(T1 secondMatrix);
    T1 addConstant2Matrix(T2 constant);
    T1 addConstant2Element(T2 constant, int index);
    T1 multiplyMatrix(T1 secondMatrix);
    T1 multiplyConstant(T2 constant);
    T1 transpose();
    T2 determinant(ArrayList<T2> matrix, int degree);
    void printMatrix();
}
