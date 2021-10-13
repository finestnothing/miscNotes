# HW_02_Resha

1. Characterize high-level the original Unix Os design. State novel designs and SW design goals. List advantages. How relevant is it today? Who were original developers? Initial Development motivation?
2. Name and briefly outline some ideal high-level OS design goals.
3. Write a concise description of the C/C++ function `fflush()`.
   1. Flushes the data streams. Effectively, nothing currently stored in buffer is saved but the file remains open.
4. Make a concise description of the Unix/Linux OS command `whoami`. Also try `WHOAMI` on windows, describe result.
   1. Returns the username of the current user.
   2. *FINISH ME*
5. Write a C++ program `system1` that calls the library function `system()`. Issue 3 distinct calls to `system()` with a single argument from: `ls`, `pwd`, and `whoami`. Show source and generated outputs. Describe.
6. Write the C or C++ program `system2` that reads, when being executed, OS commands via the “command line parameter” C/C++ feature, and then executes them. The command line parameters must be legal Unix/Linux commands. Print the number of commands entered. To prepare, read about `argc`, `argv`, and `envp`. Focus is only argc and argv.
7. What does API stand for? What is an API? What does the API define?
   1. Application Programming Interface
   2. An API allows two programs to talk to eachother, for example the OS on your phone calling a weather API to get the weather.
   3. An API defines routines for sending and receiving information such as a getWeather() function to retrieve weather information.
8. What are 5 general key functions and responsibilites of an OS?
9. OS commands can be purely textual, or completely graphical. Explain pros and cons. Name a sample OS for both types.
10. What is the meaning of `Information Hiding`? How is this related to OS?
11. Briefly contrast ages, origins, and uses of MS-DOS, Unix BSD, and Linux.
12. Write a description of the C++ function `system()`.
    1. Allows a C/C++ program to run terminal commands while running
    2. Very resource inefficient and depends on the specific OS terminal
