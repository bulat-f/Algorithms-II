/**
 * Created by bulat on 5/4/17.
 */
public class LogarithmicModel extends LinearModel  {
    public LogarithmicModel(double[][] _X, double[] _Y) {
        super(LogarithmicModel.transform(_X), _Y);
    }

    public LogarithmicModel(double[][] _X, double[] _Y, int[] vars) {
        super(LogarithmicModel.transform(_X), _Y, vars);
    }

    protected static double[][] transform(double[][] X) {
        int n = X.length, m = X[0].length;
        double[][] transformedX = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transformedX[i][j] = Math.log(X[i][j]);
            }
        }

        return transformedX;
    }
}

