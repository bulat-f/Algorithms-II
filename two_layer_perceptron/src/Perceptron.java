/**
 * Created by bulat on 5/3/17.
 */
import java.util.Scanner;

public class Perceptron {
    protected double[] enters;//массив входов;
    protected double[] hidden;//массив нейроннов на скрытом слое;
    protected double[] outer;//выход;

    protected double[] z_in;
    protected double[] y_in;
    protected double epsilon = 0.000000001;

    protected double[][] wEH; //веса от входного(enters) слоя к скрытому(hidden);

    protected double[][] wHO; //веса от скрытого слоя к выходному;

    protected double[][] patterns;
    protected double[][] answers;


    public Perceptron(double[][] _patterns, double[][] _answers){
        patterns = _patterns;
        answers = _answers;

        enters = new double[patterns[0].length];
        hidden = new double[10];

        outer = new double[3];

        z_in = new double[hidden.length];
        y_in = new double[outer.length];

        wEH = new double[enters.length][hidden.length];
        wHO = new double[hidden.length][outer.length];
    }

    public void test(){
        for(int p = 0; p < patterns.length; p++) {
            for (int i = 0; i < enters.length; i++) {
                enters[i] = patterns[p][i];
            }
            countOuter();

            for (int i = 0; i < outer.length; i++)
                System.out.println(outer[i]);

            int index = maxIndex(outer);
            System.out.println("Эта точка принадлежит классу " + index + " !");
        }

        System.out.println("Введите тестовую выборку");
        while(true){
            System.out.println("Введите x_1:");
            Scanner sc = new Scanner(System.in);
            double x_1 = sc.nextDouble();
            System.out.println("Введите x_2:");
            double x_2 = sc.nextDouble();
            enters[0] = x_1; enters[1] = x_2;
            countOuter();

            //for (int k = 0; k < outer.length; k++)
            //    System.out.println(outer[k]);

            int index = maxIndex(outer);
            System.out.println("Эта точка принадлежит классу  " + index + " !");
        }
    }

    public static int maxIndex(double[]mas){
        double max = 0; int k =0;
        for(int i = 0; i < mas.length; i++)
            if(mas[i] > max)
            {
                max = mas[i];
                k = i;
            }
        k++;
        return k;
    }
    public double sigmoid(double x){
        double result = 1/(1+Math.exp(-x));
        return result;
    }

    public double derivSigmoid(double x){
        double result = sigmoid(x)*(1 - sigmoid(x));
        return result;
    }

    public void init() {
        for (int i = 0; i < enters.length; i++)
            for (int j = 0; j < hidden.length; j++) {
                wEH[i][j] = Math.random() * 0.3 + 0.1;
            }

        for (int i = 0; i < hidden.length; i++)
            for (int j = 0; j < outer.length; j++) {
                wHO[i][j] = Math.random() * 0.3 + 0.1;
            }
    }

    public void countOuter(){

        //считаем для скрытого слоя;
        for(int i = 0; i < hidden.length; i++){
            hidden[i] = 0;
            for(int j = 0; j < enters.length; j++){
                hidden[i] += enters[j]*wEH[j][i];
            }

            z_in[i] = hidden[i];
            //применяем функцию активации;
            hidden[i] = sigmoid(hidden[i]);
        }

        //считаем для выхода;
        for(int i = 0; i < outer.length; i++) {
            outer[i] = 0;
            for (int j = 0; j < hidden.length; j++)
                outer[i] += hidden[j] * wHO[j][i];

            y_in[i] = outer[i];
            //применяем функцию активации;
            outer[i] = sigmoid(outer[i]);
        }
    }


    public void study(){
        //величина ошибки для каждого нейрона на скрытом слое;
        double[] err = new double[hidden.length];
        //на выходном слое;
        double[] lErr = new double[outer.length];

        //величина глобальной ошибки;
        double gError = 0;
        double newError = 0;

        int iter = 0;

        do{
            newError = gError;
            gError = 0;
            for(int p = 0; p < patterns.length; p++){
                for(int i = 0; i < enters.length; i++){
                    enters[i] = patterns[p][i];
                }

                //считаем выход нейрона;
                countOuter();

                //вычисляем ошибку = правильный ответ - ответ, который мы получили на выходе от нейрона;
                for(int i = 0; i < outer.length; i++)
                    lErr[i] = answers[p][i] - outer[i];

                for(int i = 0; i < outer.length; i++)
                    gError+=(lErr[i]*lErr[i]);

                //вычисляем массив ошибок на скрытом слое;
                //ошибку , которую получили на выходе умножаем на вес между выходои и нейроном и получаем ошибку;

                for(int i = 0; i < hidden.length; i++)
                    for(int j = 0; j < outer.length; j++){
                        err[i] += lErr[j]*wHO[i][j]*derivSigmoid(y_in[j]);
                    }

                //корректируем веса на скрытом слое;

                for(int i = 0; i < enters.length; i++){
                    for(int j = 0; j < hidden.length; j++){
                        wEH[i][j] += 0.1*err[j]*enters[i]*derivSigmoid(z_in[j]);
                    }
                }

                //корректируем веса на выходном слое;
                for(int i = 0; i < hidden.length; i++)
                    for(int j = 0; j < outer.length; j++)
                        wHO[i][j] += 0.1*lErr[j]*hidden[i]*derivSigmoid(y_in[j]);
            }
            iter++;
        } while(Math.abs(newError - gError) > epsilon);
        System.out.println("Count(iter) = " + iter);
    }
}
