package CSc139.hw04;

public class RRScheduler {
    private Job[] jobs = new Job[0];
    private int timePassed = 0;
    private int totalWaitTime = 0;
    private int quantum;
    private int overhead;
/*

Need to handle RR overhead

*/
    public RRScheduler(int quantum, int overhead){
        this.quantum = quantum;
        this.overhead = overhead;
    }

    public int getOverhead(){
        return this.overhead;
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
        boolean updated = false;
        do{
            updated = false;
            for (Job i : jobs){
                if(i.getTime() > quantum){
                    Job newSlice = new Job(i.getId(), i.getTime() - quantum, i.getPriority());
                    addJob(newSlice);
                    i.setTime(quantum);
                    i.setNextSlice(newSlice);
                    updated = true;
                }
            }
        }while(updated);

        for(Job i : jobs){
            // Set job delay to timePassed
            i.setDelay(timePassed);
            // Add time for job to timePassed
            timePassed += i.getTime() + overhead;
        }
    }

    public void print(){
        System.out.printf("RR Process Execution, quantum = %d, overhead = %d%n", quantum, overhead);
        // Print out the jobs
        for(Job i:jobs){
            System.out.println(i.toString());
        }
        for(Job i:jobs){
            System.out.printf("RR delay for p%d = %d ms%n", i.getId(), i.getDelay());
            this.totalWaitTime += i.getDelay();
        }
        System.out.printf("Preemptive RR schedule, quantum = %d, overhead = %d%n", quantum, overhead);

        // Need to work out time finished for each process id

        // Need initial length by process id

        // Need number of slices by id
        
        System.out.println("<><> end RR <><>");
    }
}
