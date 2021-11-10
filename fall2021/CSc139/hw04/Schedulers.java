package CSc139.hw04;

import java.util.Scanner;

public class Schedulers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Job[] jobs = new Job[0];

        // Get 3 jobs from user input
        for (int i = 0; i < 3; i++) {
            // Add each job to array
            Job[] newJobs = new Job[jobs.length + 1];
            for (int j = 0; j < jobs.length; j++) {
                newJobs[j] = jobs[j];
            }
            newJobs[jobs.length] = new Job(input.nextInt(), input.nextInt(), input.nextInt());
            jobs = newJobs;
        }

        // FCFS Scheduler
        FCFSScheduler fcfs = new FCFSScheduler();
        for(Job i : jobs) {
            fcfs.addJob(i);
        }
        fcfs.run();
        fcfs.print();

        // HPF Scheduler
        HPFScheduler hpf = new HPFScheduler();
        for(Job i : jobs) {
            hpf.addJob(i);
        }
        hpf.run();
        hpf.print();

        // RR Scheduler
        int quantumMax = 3;
        for(int quantum = 1; quantum <= quantumMax; quantum++) { 
            for(int j = 0; j < quantum; j++){

                RRScheduler rr = new RRScheduler(quantum,j);
                for(Job i : jobs) {
                    rr.addJob(i);
                }
                rr.run();
                rr.print();
            }

        input.close();
        }
    }
}
