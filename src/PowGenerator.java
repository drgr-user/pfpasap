import java.util.concurrent.ThreadLocalRandom;

public class PowGenerator {
    public static int generatePow(int mode, int rate){
        int pow = 1;
        switch (mode){
            case (1):
                pow = ThreadLocalRandom.current().nextInt(0,rate); // All gaining
                break;
            case (2):
                pow = ThreadLocalRandom.current().nextInt(rate, 2 * rate); // All consuming
                break;
            case (3):
                pow = ThreadLocalRandom.current().nextInt(0, 2 * rate);
                break;
        }
        return pow;
    }
}
