import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskSetManager {
    public static TaskSet generateTaskSet(int n, double maxUtil, int maxHyperPeriod, int rate, int mode){
        int[] periods = PeriodGenerator.generatePeriods(n, maxHyperPeriod);
        double[] utilization = UUniFast.generateUtil(n, maxUtil);
        TaskSet taskSet = new TaskSet(n);
        for(int i = 0; i < n; i++){
            taskSet.taskArray[i].setWcet(periods[i]*utilization[i]);
            taskSet.taskArray[i].setPeriod(periods[i]);
            taskSet.taskArray[i].setDeadline(periods[i]);
            taskSet.taskArray[i].setPow(PowGenerator.generatePow(mode, rate));
        }
        return taskSet;
    }

    public static boolean exportTaskSet(TaskSet taskSet, String fileName){
        String currentPath = System.getProperty("user.dir");
        String filePath = currentPath + "\\tasksets\\" + fileName;
        try {
            Files.createDirectories(Paths.get(currentPath + "\\tasksets\\"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(taskSet);
            objectOut.flush();
            objectOut.close();
            fileOut.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static File[] importTaskSets(){
        File folder = new File(System.getProperty("user.dir")+"\\tasksets\\");
        File[] listOfFiles = folder.listFiles();
        return listOfFiles;
    }

}
