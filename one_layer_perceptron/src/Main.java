public class Main {

    public static void main(String[] args) {
        double[][] x = {{10, 10}, {10, 20}, {20, 10}, {-10, -10}, {-10, -20}, {-20, -10}};
        double[] y = {0, 0, 0, 1, 1, 1};
        double[] test_x = {-20, -20};
        Perceptron perceptron = new Perceptron(x, y);
        System.out.println("Predicted class is " + perceptron.test(test_x));
    }
}
