# CSc 139 Hw 04

## Alec Resha

## Due: Wednesday, November 10, 2021

```text
1 2 3
2 4 1
3 7 2
FCFS Process Execution Order:
Id:   1 Process Time:   2 Priority:   3
Id:   2 Process Time:   4 Priority:   1
Id:   3 Process Time:   7 Priority:   2
fcfs delay for p1 = 0 ms
fcfs delay for p2 = 2 ms
fcfs delay for p3 = 6 ms
Average wait for 3 processes =     2.667 ms
average time for 3 processes =     4.333 ms
fcfs throughput for 3 processes = 0.230769 processes/ms
<><> end FCFS <><>
HPF Process Execution Order:
Id:   2 Process Time:   4 Priority:   1
Id:   3 Process Time:   7 Priority:   2
Id:   1 Process Time:   2 Priority:   3
hpf delay for p2 = 2 ms
hpf delay for p3 = 10 ms
hpf delay for p1 = 11 ms
Average wait for   3 processes =     7.667 ms
average time for   3 processes =     4.333 ms
hpf throughput for   3 processes = 0.230769 processes/ms
<><> end HPF <><>
Preemptive RR Process Execution, quantum = 1, overhead = 0
RR TA time for finished p1 = 16, and: 2 time slices
RR TA time for finished p2 = 25, and: 4 time slices
RR TA time for finished p3 = 73, and: 7 time slices
RR Throughput with quantum 1, overhead 0 is 0.23077 p/ms
Average RR TA with quantum 1, overhead 0 is 24.33333
<><> end RR <><>%n
Preemptive RR Process Execution, quantum = 2, overhead = 0
RR TA time for finished p1 = 16, and: 2 time slices
RR TA time for finished p2 = 26, and: 4 time slices
RR TA time for finished p3 = 75, and: 7 time slices
RR Throughput with quantum 2, overhead 0 is 1.00000 p/ms
Average RR TA with quantum 2, overhead 0 is 25.00000
<><> end RR <><>%n
Preemptive RR Process Execution, quantum = 2, overhead = 1
RR TA time for finished p1 = 16, and: 2 time slices
RR TA time for finished p2 = 28, and: 4 time slices
RR TA time for finished p3 = 79, and: 7 time slices
RR Throughput with quantum 2, overhead 1 is 0.50000 p/ms
Average RR TA with quantum 2, overhead 1 is 26.33333
<><> end RR <><>%n
Preemptive RR Process Execution, quantum = 3, overhead = 0
RR TA time for finished p1 = 16, and: 2 time slices
RR TA time for finished p2 = 29, and: 4 time slices
RR TA time for finished p3 = 81, and: 7 time slices
RR Throughput with quantum 3, overhead 0 is 1.00000 p/ms
Average RR TA with quantum 3, overhead 0 is 27.00000
<><> end RR <><>%n
Preemptive RR Process Execution, quantum = 3, overhead = 1
RR TA time for finished p1 = 16, and: 2 time slices
RR TA time for finished p2 = 31, and: 4 time slices
RR TA time for finished p3 = 85, and: 7 time slices
RR Throughput with quantum 3, overhead 1 is 0.50000 p/ms
Average RR TA with quantum 3, overhead 1 is 28.33333
<><> end RR <><>%n
Preemptive RR Process Execution, quantum = 3, overhead = 2
RR TA time for finished p1 = 16, and: 2 time slices
RR TA time for finished p2 = 34, and: 4 time slices
RR TA time for finished p3 = 91, and: 7 time slices
RR Throughput with quantum 3, overhead 2 is 0.33333 p/ms
Average RR TA with quantum 3, overhead 2 is 30.33333
<><> end RR <><>
```
