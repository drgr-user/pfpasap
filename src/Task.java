import java.io.Serializable;

public class Task implements Serializable {
    double wcet;
    int period;
    double deadline;
    int pow;

    Task(){
        this.wcet = 1;
        this.period = 1;
        this.deadline = 1;
        this.pow = 1;
    }

    Task(double wcet, int period, double deadline, int pow){
        this.wcet = wcet;
        this.period = period;
        this.deadline = deadline;
        this.pow = pow;
    }

    public double getWcet() {
        return wcet;
    }

    public void setWcet(double wcet) {
        this.wcet = wcet;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getDeadline() {
        return deadline;
    }

    public void setDeadline(double deadline) {
        this.deadline = deadline;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }
}
