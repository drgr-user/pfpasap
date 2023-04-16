//This Part is from https://www.geeksforgeeks.org/lcm-of-given-array-elements/

public class LCM {
    public static long lcmCalculator(int[] inputArray) {
        long lcmOfArrayElements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < inputArray.length; i++) {

                // lcmOfArrayElements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcmOfArrayElements.

                if (inputArray[i] == 0) {
                    return 0;
                } else if (inputArray[i] < 0) {
                    inputArray[i] = inputArray[i] * (-1);
                }
                if (inputArray[i] == 1) {
                    counter++;
                }

                // Divide inputArray by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (inputArray[i] % divisor == 0) {
                    divisible = true;
                    inputArray[i] = inputArray[i] / divisor;
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcmOfArrayElements
            // and store into lcmOfArrayElements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcmOfArrayElements = lcmOfArrayElements * divisor;
            } else {
                divisor++;
            }

            // Check if all inputArray is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == inputArray.length) {
                return lcmOfArrayElements;
            }
        }
    }
}

