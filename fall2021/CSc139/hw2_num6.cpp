#include <iostream>
using namespace std;
  
int main(int argc, char** argv)
{
    cout << "Number of arguments: " << argc << endl;
  
    for (int i = 1; i < argc; ++i)
        system(argv[i]);
  
    return 0;
}
