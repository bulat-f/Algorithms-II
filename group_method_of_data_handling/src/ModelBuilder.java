import java.util.List;

/**
 * Created by bulat on 5/17/17.
 */
public class ModelBuilder extends Thread {
    private Model model;
    private double C;

    public ModelBuilder(Model model) {
        this.model = model;
    }

    public double getC() {
        return C;
    }

    @Override
    public void run() {
        model.perform();
        C = model.C();
    }
}
