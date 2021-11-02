package CSc139.hw04;

public class Job implements Comparable<Job>{
    private int id;
    private int time;
    private int priority;
    private int delay = 0;
    private Job nextSlice = new Job(-1, 0, 0);

    public Job(int id, int time, int priority) {
        this.id = id;
        this.time = time;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setDelay(int delay) {
        this.delay += delay;
    }

    public int getDelay(){
        return delay;
    }

    public String toString(){
        return(String.format("Id: %3d Process Time: %3d Priority: %3d", id, time, priority));
    }

    @Override
    public int compareTo(Job arg) {
        if(this.priority > arg.priority){
            return 1;
        }
        else if(this.priority < arg.priority){
            return -1;
        }
        else{
            return 0;
        }
    }

    public void setNextSlice(Job job){
        this.nextSlice = job;
    }

    public Job getNextSlice(){
        return nextSlice;
    }
}
