import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private List<Row> rows;

    public Matrix () {
        rows = new ArrayList<>();
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public Row getRow(int index) {
        return rows.get(index);
    }

    public void printMatrix() {
        for (Row row : rows) {
            for (int i = 0; i < row.getCoefficients().length ; i++) {
                System.out.print(row.getCoefficients()[i] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    public int numberOfRows() {
        return rows.size();
    }
}
