import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class PeriodGenerator {
    private static int getBase(int index){
        int base = 1;
        switch (index){
            case 0:
                base = 2;
                break;
            case 1:
                base = 3;
                break;
            case 2:
                base = 5;
                break;
            case 3:
                base = 7;
                break;
        }
        return base;
    }

    private static int[] primesPowerCalculator(int maxHyperPeriod){
        int[] powerOfPrimes;
        powerOfPrimes = new int[]{3, 2, 1, 1};

        double hyperPeriod = 0;
        int index = 0;
        while (true){
            powerOfPrimes[index]++;
            hyperPeriod = Math.pow(2,powerOfPrimes[0])*Math.pow(3,powerOfPrimes[1])*Math.pow(5,powerOfPrimes[2])*Math.pow(7,powerOfPrimes[3]);
            if(hyperPeriod>maxHyperPeriod){
                powerOfPrimes[index]--;
                break;
            }
            index++;
            if(index == 4)
                index = 0;
        }
        return powerOfPrimes;
    }

    private static int[][] createMatrix(int maxHyperPeriod){
        int[] powerOfPrimes = primesPowerCalculator(maxHyperPeriod);
        int matrix[][] = new int[4][];
        for (int i = 0; i < 4; i++){
            int[] powers = new int[powerOfPrimes[i]+1];
            int base = getBase(i);
            for (int j = 0; j <= powerOfPrimes[i]; j++){
                powers[j] = (int) Math.pow(base, j);
            }
            matrix[i] = powers;
        }
        return matrix;
    }

    private static int generatePeriod(int maxHyperPeriod){
        int[][] matrix = createMatrix(maxHyperPeriod);
        int period = 1;
        for (int i = 0; i<4; i++){
            period = period * matrix[i][ThreadLocalRandom.current().nextInt(0,matrix[i].length)];
        }
        return period;
    }

    public static int[] generatePeriods(final int n, final int maxHyperPeriod){
        int[] periods = new int[n];
        for (int i = 0; i<n; i++){
            periods[i] = generatePeriod(maxHyperPeriod);
        }
        return periods;
    }

}
