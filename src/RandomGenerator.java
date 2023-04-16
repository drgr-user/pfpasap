import java.util.Random;

public class RandomGenerator {
    public static double generateRandomProperFraction(Random r){
        double num = r.nextDouble();
        while(num == 0){
            num = r.nextDouble();
        }
        return num;
    }
}
