import java.util.Arrays;

public class Calculator {

    private Matrix matrix;
    private double[] solution;

    public Calculator(Matrix matrix) {
        this.matrix = matrix;
        this.solution = new double[matrix.numberOfRows()];
    }

    private void prepareRowForReduction(int rowNumber) {
        Row row = matrix.getRow(rowNumber);
        double[] coefficients = row.getCoefficients();
        if (coefficients[rowNumber] != 1) {
            double factor = coefficients[rowNumber];
            for (int i = 0; i < row.getSize(); i++) {
                coefficients[i] = coefficients[i] / factor;
            }
            System.out.printf("%.2f * R%d -> R%d\n", factor, rowNumber, rowNumber);
        }
    }

    private void reduceRow (int rowNumber, int column) {
        Row row = matrix.getRow(rowNumber);
        Row factorRow = matrix.getRow(column);
        double factor = row.getCoefficients()[column];
        for (int i = 0; i < row.getSize(); i++) {
            row.getCoefficients()[i] = (factor * factorRow.getCoefficients()[i] * (-1)) + row.getCoefficients()[i];
        }
        System.out.printf("%.2f * R%d + R%d -> R%d\n", factor*(-1), column, rowNumber, rowNumber);
    }

    private void reduceAllRowsInAColumn(int column) {
        prepareRowForReduction(column);
        for (int i = column+1; i < matrix.numberOfRows(); i++) {
            reduceRow(i, column);
        }
    }

    public void reduceMatrix() {
        System.out.println("Calculating...");
        prepareRowForReduction(0);
        for (int i = 0; i < matrix.numberOfRows(); i++) {
            reduceAllRowsInAColumn(i);
        }
    }

    private void jordanReversalInColumn(int column) {
        for (int i = column-1; i >= 0; i--) {
            reduceRow(i, column);
        }
    }

    public void jordanGaussReversal() {
        for (int i = matrix.numberOfRows()-1; i > 0; i--) {
            jordanReversalInColumn(i);
        }
    }

    public void solution() {
        for (int i = 0; i < matrix.numberOfRows(); i++) {
            solution[i] = matrix.getRow(i).getCoefficients()[matrix.numberOfRows()];
        }
        System.out.println("Solution is: " + Arrays.toString(solution));
    }

    public double[] getSolution() {
        return solution;
    }
}
