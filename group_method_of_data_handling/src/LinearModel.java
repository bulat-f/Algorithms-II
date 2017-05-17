import Jama.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulat on 4/26/17.
 */
public class LinearModel implements Model {
    private Matrix X;
    private Matrix Y;
    private Matrix b;

    public LinearModel(double[][] _X, double[] _Y, List<Integer> vars) {
        int n = _X.length, m = vars.size();
        double[][] new_X = new double[n][m + 1];
        for (int i = 0; i < n; i++) {
            new_X[i][0] = 1;
            for (int j = 0; j < m; j++)
                new_X[i][j + 1] = _X[i][vars.get(j)];
        }
        X = new Matrix(new_X);
        Y = new Matrix(_Y, _Y.length);

        Matrix X_t = X.transpose();
        b = X_t.times(X).inverse().times(X_t).times(Y);
    }

    public LinearModel(double[][] _X, double[] _Y) {
        this(_X, _Y, genVars(_X));
    }

    public double[] getB() {
        return b.getColumnPackedCopy();
    }

    public Matrix Y_approx() {
        return X.times(b);
    }

    public double R() {
        return 1 - S1() / S2();
    }

    public double DW() {
        return S3()/ Math.pow(S1(), 2);
    }

    private double S1() {
        return Y.minus(Y_approx()).norm2();
    }

    private double S2() {
        Matrix Y_ = Y_approx();
        double mean = Y_.norm1();
        Matrix Y_mean = new Matrix(Y_.getRowDimension(), Y_.getColumnDimension(), mean);
        return Y.minus(Y_mean).norm2();
    }

    private double S3(){
        Matrix Eps = Y.minus(Y_approx());
        double[] eps = Eps.getRowPackedCopy();
        int a = eps.length;
        double sum = 0;
        for(int i=1; i<a; i++){
            sum += (eps[i]-eps[i-1])*(eps[i]-eps[i-1]);
        }
        return sum;
    }

    private static List<Integer> genVars(double[][] _X) {
        List<Integer> vars = new ArrayList<Integer>();
        for (int i = 0; i < _X[0].length; i++)
            vars.add(i);
        return vars;
    }
}
