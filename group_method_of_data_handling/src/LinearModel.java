import Jama.Matrix;

/**
 * Created by bulat on 4/26/17.
 */
public class LinearModel {
    private Matrix X;
    private Matrix Y;
    private Matrix b;

    public LinearModel(double[][] _X, double[] _Y) {
        int n = _X.length, m = _X[0].length;
        double[][] new_X = new double[n][m + 1];
        for (int i = 0; i < n; i++) {
            new_X[i][0] = 1;
            for (int j = 0; j < m; j++)
                new_X[i][j + 1] = _X[i][j];
        }
        X = new Matrix(new_X);
        Y = new Matrix(_Y, _Y.length);

        Matrix X_t = X.transpose();
        b = X_t.times(X).inverse().times(X_t).times(Y);
    }

    public double[] getB() {
        return b.getColumnPackedCopy();
    }
}
