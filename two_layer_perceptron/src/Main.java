public class Main {

    public static void main(String[] args) {
        double[][] patterns = {{8,7}, {1,1}, {1,2}, {3,5}, {4, 6}, {-7, -6}, {-9, -8}, {-4, -9}, {-11, -2}, {-8, -5}, {-1, 4}, {-5, 4}, {-6, 5}, {-4, 4}, {-8, 4}};
        double[][] answers = {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0,1,0}, {0, 1, 0}, {0, 1, 0},{0, 1, 0} , {0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1}};
        Perceptron perceptron = new Perceptron(patterns, answers);
        System.out.println("Обучение:");
        perceptron.init();
        perceptron.study();
        perceptron.test();
    }
}
