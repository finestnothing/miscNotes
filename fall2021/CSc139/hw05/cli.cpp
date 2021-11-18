#include <iostream>
#include <string.h>

using namespace std;

int main( int argc, char *argv[] ){
    // List of legal commands from assignment
    string cmds[] = {
        "cd",
        "exec",
        "exit",
        "gcc",
        "ls",
        "man",
        "more",
        "mv",
        "rm",
        "pwd",
        "sh",
        "touch",
        "which",
        "$PATH"
    };
    
    // Identify author + program name + date
    cout << "AlecResha - cli - 11/18/2021" << endl;
    // List all legal commands
    cout << "Legal commands: ";
    for(int i = 0; i < sizeof(cmds)/sizeof(cmds[0]); i++){
        cout << cmds[i] << " ";
    }
    cout << endl;
    // Display count of arguments, includes ./cli call
    cout << argc << " strings passed to argv" << endl;


    string cmd = ""; // stores multi-word commands
    bool run = true; // Used to tell if it will be a legal argument to run
    for(int i = 1; i < argc; i++){
        // Check if first command in a sequence is in the list of legal commands
        if (cmd == ""){ 
            // if first command in sequence, check if valid
            // Doesn't check arguments, only the command
            string temp = argv[i];
            temp = temp.substr(0, temp.find(",")); // remove comma (if present)
            int j;
            for(j = 0; j < sizeof(cmds)/sizeof(cmds[0]); j++){
                // compare command to all legal arguments
                if(strcmp(temp.c_str(), cmds[j].c_str()) == 0){ 
                    break;
                }
            } if (j == sizeof(cmds)/sizeof(cmds[0])){ // if not in legal args
                cout << "Error: " << argv[i] << " is not a legal command" << endl;
                run = false; // Skip the argument
            } else {
                run = true; // if in legal args, include it
            }
        }
        // If it is a legal command, add it to the command string
        // If not, move to next argument
        if (run){
            if ((argv[i][strlen(argv[i])-1] == ',')){
                // If comma is present, remove comma and append to command string
                // Then run cmd and clear it
                string temp = argv[i];
                temp = temp.substr(0, temp.find(",")); // Remove comma
                cmd += " " + temp;
                cout << "cmd: " << cmd << endl; // Print command to be run
                system(cmd.c_str());
                cmd = "";
            } else if(i == argc - 1 || argv[i][strlen(argv[i])-1] == ';'){
                // If last argument, add to cmd and run
                cmd += " ";
                cmd += argv[i];
                cout << "cmd: " << cmd << endl; // Print command to be run
                system(cmd.c_str());
                return 0;
            } else {
                // If not last argument, add to cmd
                cmd += " ";
                cmd += argv[i];
            }
        }
    }
    return 0;
}