import java.util.Random;

public class UUniFast {

    public static double[] generateUtil(int n, double u){
        double[] utilization = new double[n];
        double sumU = u;
        double nextSumU;
        Random r = new Random();
        for(int i = 0; i < n-1; i++){
            nextSumU = sumU * Math.pow(RandomGenerator.generateRandomProperFraction(r),(1.0000/(n-i)));
            utilization[i] = Math.round((sumU - nextSumU)*10000) / 10000.0000;
            sumU = nextSumU;
        }
        utilization[n-1] = Math.round(sumU*10000) / 10000.0000;
        return utilization;
    }
}
