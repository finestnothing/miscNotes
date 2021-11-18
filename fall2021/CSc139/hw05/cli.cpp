#include <iostream>
#include <string.h>

using namespace std;

int main( int argc, char *argv[] ){
    cout << "AlecResha - cli - 11/17/2021" << endl;
    cout << "Legal commands: ";
    cout << "cd exec exit exit gcc ls man more mv rm pwd sh touch which $path" << endl;
    cout << argc << " strings passed to argv" << endl;

    string cmd = "";
    for(int i = 1; i < argc; i++){
        if (argv[i][strlen(argv[i])-1] != ','){
            // remove command and append to cmd, run it, then empty cmd
            cmd += argv[i];
        } else {
            cmd += argv[i];
        }
    }
    
    return 0;
}