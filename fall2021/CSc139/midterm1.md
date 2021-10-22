# Midterm 1

## Alec Resha

1. Purpose, function, method, restrictions of DMA
    - Purpose/function: data transfer without taking up CPU resources(only to start and end transfer)
    - Method: Direct transfer between I/O and memory or memory to memory
    - Restrictions - Data inaccessible during the transfer
2. Hard real-time problem. What makes it real-time? What hard?
    - Air Traffic Control System
    - Real time because they need results by a specific and short amount of time
    - Real-time is hard because if anything is missed in real-time, it can have consequences very quickly.
3. Why does ENVP not have an "argv" like argc does?
    - ENVP is never null (since it inherits properties from the terminal), argc is mainly for checking if argv is empty
4. 4 Conditions that cause a deadlock for two concurrent processes
    - Mutual exclusion: At least one of the two must be held in a non-sharable mode
    - Hold and Wait: There must be a process holding one resource and waiting for another (P1 has x, needs y; P2 has y, needs x)
    - No preemption: cannot have either process interrupted by OS to make way for the other
    - Circular wait: P1 waiting for P2 which is waiting for P(3,4,...,n)
5. Which conditions does demand-paged VMM work well? Characterize 'evil' software written to constantly cause page faults. How poorly will it run?
    - Works best if data is grouped together on a single disc page.
    - Evil: Store data across many different data pages. Will run slowly since the OS has to constantly load new data pages into memory
6. Explain what is essential to genuine interrupts. Who initiates them? Why are they needed? How can a user infer from code where and when interrupts arise?
    - Fast, short pause of execution
    - OS or User initiates them
    - Needed to stop loops or free up more important tasks
    - User can't tell when they occur, can be anywhere
7. Belady's Anomaly. Context? What is abnormal? What is plausible to expect instead of this anomaly
    - Conext is loading more data frames into memory for a paged VMM
    - Abnormal that more page frames makes more page faults
    - Normally expect fewer page faults as the number of page frames increases since more information is loaded (fasted loading)
8. What is priviliged mode execution in an OS?
    - Software executed with unrestricted privileges. It allows access to all available resources, any files, etc.
9. Page fault. Causes, OS actions in case of it, run-time cost, thrashing
    - Exception when the data is not properly prepared in memory before access is attempted
    - OS needs to either point to the data without it being loaded and it will be loaded when needed, or find a free location in memory to write out the data.
    - Causes a very large delay (thousands of time slower than loading correctly)
    -Thrashing is when there are too many page faults so the OS/VMM is rapidly loading data pages and running into faults.
10. Working set- context, consequences of it being incorrect
    - Estimated amount of memory that a program/process will need at a given time
    - Consequence is that if the working set is larger than available memory, it has to fall back on using the next storage (HDD/SSD) to complete the operation which is much slower.
11. Preemptive scheduler - advantage, disadvantage
    - Advantage: very flexible
    - Con: takes slightly longer to switch between running/ready states
12. Dispatch latency
    - Time to switch a process from run to ready and adding a new process to run state
13. System() - explain, library needed, meaning of system("man system")
    - Allows a C++ program to execute command line/terminal commands
    - stdlib.h
    - system("man system") will give the manual/help page for the CLI command "system"
14. Program vs process
    - Program is primarily the files and code. Can have many processes
    - Processes are the code for a program actually being processed, multiple processes can be associated with one program
15. kill(), fork(), exec() in linux
    - kill() - sends a signal to a running process
    - fork() - duplicates a process into a child process, identical except with a new ID, doesn't inherit memory locks, resets resources to 0 since it's a new process
    - exec() - changes the data of a process to a newly loaded process, keeps the original ID
