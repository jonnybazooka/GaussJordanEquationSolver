public class Row {

    private int size;
    private double[] coefficients;

    public Row (int size) {
        this.size = size;
        coefficients = new double[size];
    }

    public void setCoefficients(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public double[] getCoefficients() {
        return coefficients;
    }
    public int getSize() {
        return size;
    }
}
