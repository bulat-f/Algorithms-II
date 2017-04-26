/**
 * Created by bulat on 4/26/17.
 */
public class Generator {
    private double[][] X;
    private double[] Y;
    public Generator(double[] b, int n) { // x = (x_1, ... , x_n); A = {x1; ...; xm}
        int m = b.length;
        X = new double[n][m];
        Y = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                X[i][j] = Math.random() * 100;
                Y[i] += X[i][j] * b[j] + Math.random() * 2;
            }
        }
    }

    public double[][] getX() {
        return X;
    }

    public double[] getY() {
        return Y;
    }
}
