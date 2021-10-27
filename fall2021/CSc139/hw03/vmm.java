import java.util.Random;
import java.util.Scanner;

public class vmm {
    public static void main(String[] args) {
        int numAccesses = 0;
        int numTriples = 1;
        int numSwapIns = 0;
        int numSwapOuts = 0;
        int numPagesMalloced = 0;
        int numPageFrames = 0;
        int numPageTables = 0;
        int totalMemCycles = 0;
        int cyclesWOVMM = 0;
        int cyclesPerSwapIn = 5000;
        int cyclesPerSwapOut = 5000;
        int lastWorkingSetSize = 0;
        int maxWorkingSetSize = 0;
        int maxPhysicalPages = 0;
        int pageSize = 4096;
        String replacementAlgorithm = "Random";


        // Create a Scanner object to read from the keyboard
        Scanner input = new Scanner(System.in);
        // Prompt the user to enter the number of pages
        System.out.print("Enter the number of pages: ");
        numPageFrames = input.nextInt();
        
        // to hold loaded pages
        String[] physicalPages = new String[numPageFrames];
        
        // Declare array of 1024 int for page directory
        String[][][] pageDirectory = new String[1024][][];

        //Used for random killing
        Random rand = new Random();

        // user input loop for read/write
        for(int i = 0; i < 10; i++){
            char readOrWrite = input.next().charAt(0);
            String address = addressGenerator(input.nextInt());
            int value = input.nextInt();

            Boolean loaded = false;
            //Check if already loaded into physical memory
            for(int j = 0; j < physicalPages.length; j++){
                if(physicalPages[i] == address){
                    numAccesses+=10;
                    loaded = true;
                }
            }
            if(!loaded){
                numSwapIns++;
                numAccesses+=10010; //Loading page into mem, and reading/writing
                
                // If empty space in physicalpages,add new page to end
                // If not, malloc random page and replace it
                if(physicalPages.length < numPageFrames){
                    physicalPages[physicalPages.length] = address;
                } else {
                    // Allocate new page table if needed
                    if(pageDirectory[Integer.parseInt(address.substring(0, 10))] == null){
                        // Make new page table
                        pageDirectory[Integer.parseInt(address.substring(0, 10))] = new String[1024][];

                        // Add new user page to new page table
                        pageDirectory[Integer.parseInt(address.substring(0, 10))][Integer.parseInt(address.substring(10,20))] = new String[1024];
                        numPageTables++;

                        // Add address to new user page
                        pageDirectory[Integer.parseInt(address.substring(0, 10))][Integer.parseInt(address.substring(10,20))][Integer.parseInt(address.substring(20))] = address;
                        numPagesMalloced++;
                        
                    }
                    }
                    physicalPages[rand.nextInt(numPageFrames)] = address;
                }
            }


        // Fill pageDirectory with pageTables
            // Fill pageTable with singleUserTable
        
        //PD is 4kb HW cache (Page Directory)
            // need space for 1024 pointers to some PT
            // Each entry is 4 bytes/32 bits
                // Holds frame-size aligned address of a PT
                // Remaining 10 bits are to track details
        //PT is the Page Table
            // entries are 4 bytes/32 bits long
                // Holds the address of a user page
                // Remaining 12 bits are to track details (present, modified, etc)
                    // P bit for present
                    // M bit for modified
                    // R bit for read-only pages
                    // D bit for dirty (written to)
                    // S bit for shared page
                    // Can be others for future use
        
        //User page
            // Start address is pointed at by a PT entry

        //Replacement
            // Use Random Replacement Policy
            // Use a fixed, arbitrary number of cycles for selection a victim page
            // around 10 cycles

        //Output summary results
        System.out.println("*** Paging Activity Statistics ***");
        System.out.printf("%-30s %f", "Number of memory accesses ", "= " + numAccesses);
        System.out.printf("%-30s %f", "Number of triples (1+access) ", "= " + numTriples);
        System.out.printf("%-30s %f", "Number of swap ins ", "= " + numSwapIns);
        System.out.printf("%-30s %f", "Number of swap outs ", "= " + numSwapOuts);
        System.out.printf("%-30s %f", "Number of pages malloced ", "= " + numPagesMalloced);
        System.out.printf("%-30s %f", "Number of pages for Page Tables ", "= " + numPageTables);
        System.out.printf("%-30s %f", "Number of frames for user", "= " + numPageFrames);
        System.out.printf("%-30s %f", "Total memory cycles ", "= " + totalMemCycles);
        System.out.printf("%-30s %f", "Cycles without VMM ", "= " + cyclesWOVMM);
        System.out.printf("%-30s %f", "Cycles per swap in ", "= " + cyclesPerSwapIn);
        System.out.printf("%-30s %f", "Cycles per swap out ", "= " + cyclesPerSwapOut);
        System.out.printf("%-30s %f", "Last working set size ", "= " + lastWorkingSetSize);
        System.out.printf("%-30s %f", "Max working set size ", "= " + maxWorkingSetSize);
        System.out.printf("%-30s %f", "Max physical pages ", "= " + maxPhysicalPages);
        System.out.printf("%-30s %f", "Page size ", "= " + pageSize);
        System.out.printf("%-30s %f", "Replacement algorithm ", "= " + replacementAlgorithm);
    } //End of main

    //Convert int into 32 bit binary address
    public static String addressGenerator(int address){
        // chars 0-9: Index into Page Directory (PD)
        // chars 10-19: Index into Page Table (PT)
        // chars 20-31: byte-offset into user page

        // convert address to binary
        String addressBinary = Integer.toBinaryString(address);

        // Return padded binary string
        return new String(new char[32 - addressBinary.length()]).replace('\0', '0') + addressBinary;
    }
} //End of class vmm