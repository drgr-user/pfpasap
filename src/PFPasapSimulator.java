import java.io.*;

public class PFPasapSimulator {

    public static void createTaskSets(int maxHyperPeriod, int rate){
        int[] modes = {1, 2, 3};
        int[] n = {5, 10, 20};
        double[] utils = {0.2, 0.4, 0.6, 0.8, 1};
        int numberOfTaskSets = 50;
        for (int mode = 1; mode < 4; mode++){
            for(int i = 0; i < n.length; i++){
                for(int j = 0; j<utils.length; j++){
                    for(int k = 0; k<numberOfTaskSets; k++){
                        TaskSet newTaskSet = TaskSetManager.generateTaskSet(n[i], utils[j], maxHyperPeriod, rate, mode);
                        String taskSetName = (Integer.toString(mode)+"-"+Integer.toString(n[i])+"-"+Integer.toString((int)(utils[j]*100))+"-"+Integer.toString(k));
                        if(TaskSetManager.exportTaskSet(newTaskSet, taskSetName))
                            System.out.println("Created " + taskSetName);
                        else
                            System.out.println("Fatal");
                    }
                }
            }
        }
    }

    public static boolean runAlgo(int rate){
        File[] listOfFiles = TaskSetManager.importTaskSets();
        for (File objFile : listOfFiles){
            /*File logFile = new File(System.getProperty("user.dir")+"\\tasksets\\");
            if(logFile.exists()){
                logFile.delete();
            }*/
            try{
                /*logFile.createNewFile();
                FileWriter fw = new FileWriter(logFile);
                BufferedWriter bw = new BufferedWriter(fw);*/

                String pathToFile = objFile.getAbsolutePath();
                FileInputStream fileStream = new FileInputStream(pathToFile);
                ObjectInputStream objStream = new ObjectInputStream(fileStream);
                TaskSet newTaskSet = (TaskSet) objStream.readObject();

                boolean result = PFPasapAlgorithm.runAlgo(newTaskSet, rate);
                if(result){
                    System.out.println(objFile.getName()+" : Ok.");
                    /*bw.write(objFile.getName()+" : Ok.\n");
                    bw.flush();*/
                } else {
                    System.out.println(objFile.getName()+" : Deadline miss.");
                    /*bw.write(objFile.getName()+" : Deadline miss.\n");
                    bw.flush();*/
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }

        }
        return true;
    }
}
