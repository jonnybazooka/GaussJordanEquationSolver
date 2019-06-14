import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pathOut = args[3];
        int numberOfRows = 0;
        boolean isTableCreated = false;
        Matrix matrix = new Matrix();

        try (Scanner scanner = new Scanner(new File(args[1]))) {
            while (scanner.hasNext()) {
                if (!isTableCreated) {
                    numberOfRows = scanner.nextInt();
                    isTableCreated = true;
                } else {
                    Row row = new Row(numberOfRows + 1);
                    double[] coefficients = new double[numberOfRows + 1];
                    for (int i = 0; i < numberOfRows + 1; i++) {
                        coefficients[i] = scanner.nextDouble();
                    }
                    row.setCoefficients(coefficients);
                    matrix.addRow(row);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Calculator calculator = new Calculator(matrix);
        matrix.printMatrix();
        calculator.reduceMatrix();
        calculator.jordanGaussReversal();
        calculator.solution();

        File out = new File(pathOut);
        try (PrintWriter writer = new PrintWriter(out)){
            for (double x : calculator.getSolution()) {
                writer.println(x);
            }
            System.out.println("Solution written to: " + pathOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

