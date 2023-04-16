public class PFPasapAlgorithm {
    public static boolean runAlgo(TaskSet taskSet, int rate){
        int t = 0;
        int currentE = 0;
        double[] wcetTable = new double[taskSet.getNumberOfTasks()];
        long hyperPeriod = taskSet.getHyperPeriod();
        int[] periods = taskSet.getAllPeriods();
        while(t != hyperPeriod){
            for(int i = 0; i < taskSet.getNumberOfTasks(); i++){
                if(t%periods[i] == 0) {
                    if(wcetTable[i] != 0){
                        return false;
                    } else {
                        wcetTable[i] += taskSet.taskArray[i].getWcet();
                    }
                }
            }
            currentE += rate;
            for(int i = 0; i< wcetTable.length; i++){
                if(wcetTable[i]>0 && currentE >= taskSet.taskArray[i].getPow()){
                    if(wcetTable[i] >= 1){
                        wcetTable[i]--;
                        currentE -= taskSet.taskArray[i].getPow();
                    } else if (wcetTable[i] > 0){
                        wcetTable[i] = 0;
                        currentE -= taskSet.taskArray[i].getPow()*wcetTable[i];
                    }

                }
            }
            t++;
        }
        return true;
    }
}
