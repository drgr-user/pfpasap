import java.io.Serializable;

public class TaskSet implements Serializable {
    private int numberOfTasks;
    Task[] taskArray;
    long hyperPeriod;

    TaskSet(){

    }
    TaskSet(int n){
        this.numberOfTasks = n;
        this.taskArray = new Task[this.numberOfTasks];
        for(int i = 0; i < this.numberOfTasks; i++){
            this.taskArray[i] = new Task();
        }

    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public long getHyperPeriod(){
        calculateHyperPeriod();
        return this.hyperPeriod;
    }

    public void calculateHyperPeriod(){
        int[] periods = new int[this.numberOfTasks];
        for(int i = 0; i < this.numberOfTasks; i++){
            periods[i] = taskArray[i].getPeriod();
        }
        this.hyperPeriod = LCM.lcmCalculator(periods);
    }

    public int[] getAllPeriods(){
        int[] periods = new int[this.numberOfTasks];
        for (int i = 0; i < this.numberOfTasks; i++){
            periods[i] = this.taskArray[i].getPeriod();
        }
        return periods;
    }

}
