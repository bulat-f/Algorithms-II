import java.util.List;

/**
 * Created by bulat on 5/4/17.
 */
public class QuadraticModel extends LinearModel  {
    public QuadraticModel(double[][] _X, double[] _Y) {
        super(QuadraticModel.transform(_X), _Y);
    }

    public QuadraticModel(double[][] _X, double[] _Y, List<Integer> vars) {
        super(QuadraticModel.transform(_X), _Y, vars);
    }

    protected static double[][] transform(double[][] X) {
        int n = X.length, m = X[0].length;
        double[][] transformedX = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transformedX[i][j] = X[i][j] * X[i][j];
            }
        }

        return transformedX;
    }
}
