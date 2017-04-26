import Jama.Matrix;

/**
 * Created by bulat on 4/26/17.
 */
public class Modeling {
    public static double[] perform(double[][] _X, double[] _Y) {
        Matrix X = new Matrix(_X);
        Matrix X_t = X.transpose();
        Matrix Y = new Matrix(_Y, _Y.length);
        Matrix B = X_t.times(X).inverse().times(X_t).times(Y);
        return B.getColumnPackedCopy();
    }
}
