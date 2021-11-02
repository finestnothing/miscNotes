package CSc139.hw04;

public class FCFSScheduler {
    private Job[] jobs = new Job[0];
    private int timePassed = 0;
    private int totalWaitTime = 0;
    
    public FCFSScheduler() {
    }
    
    public void addJob(Job job) {
        Job[] newJobs = new Job[jobs.length + 1];
        for (int i = 0; i < jobs.length; i++) {
            newJobs[i] = jobs[i];
        }
        newJobs[jobs.length] = job;
        jobs = newJobs;
    }

    public void run(){
        for(Job i : jobs){
            // Set job delay to timePassed
            i.setDelay(timePassed);
            // Add time for job to timePassed
            timePassed += i.getTime();
        }
    }

    public void print(){
        System.out.println("HPF Process Execution Order:");
        // Print out the jobs
        for(Job i:jobs){
            System.out.println(i.toString());
        }
        for(Job i:jobs){
            System.out.printf("fcfs delay for p%d = %d ms%n", i.getId(), i.getDelay());
            this.totalWaitTime += i.getDelay();
        }
        System.out.printf("Average wait for %d processes = %9.3f ms%n", jobs.length, (float)totalWaitTime/(float)jobs.length);
        System.out.printf("average time for %d processes = %9.3f ms%n", jobs.length, (float)timePassed/(float)jobs.length);
        System.out.printf("fcfs throughput for %d processes = %3.6f processes/ms%n", jobs.length, (float)jobs.length/(float)timePassed);
        System.out.println("<><> end FCFS <><>");
    }
}
