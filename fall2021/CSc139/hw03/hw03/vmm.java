package hw03;

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
        char readOrWrite;
        String address;
        int value = 0;


        // Create a Scanner object to read from the keyboard
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the number of entries
        System.out.print("Enter the number of entries: ");
        int numEntries = input.nextInt();

        // Prompt the user to enter the number of pages
        System.out.print("Enter the number of pages: ");
        numPageFrames = input.nextInt();
        
        // to hold loaded pages
        UserPage[] physicalPages = new UserPage[numPageFrames];

        PageDirectory pageDir = new PageDirectory();

        //Used for random killing
        Random rand = new Random();

        Audit auditHistory = new Audit();

        // user input loop for read/write
        for(int i = 0; i < numEntries; i++){
            do{
                readOrWrite = input.next().charAt(0);
                address = addressGenerator(input.nextInt());
                if(readOrWrite =='w'){
                    value = input.nextInt();
                }
            } while(readOrWrite != 'r' && readOrWrite != 'w');

            int loadedIndex = -1; //Keeps track of new page frame loc in physical pages array

            //Check if already loaded into physical memory
            for(int j = 0; j < physicalPages.length; j++){
                if(physicalPages[j] != null && physicalPages[j].getAddress().equals(address)){
                    loadedIndex = j;
                    break;
                }
            }
            // Load in new page to memory
            if(loadedIndex == -1){
                numSwapIns++;
                numAccesses+=10000; //Loading page into mem
                
                //If no empty space, replace random frame

                //Make new page table if needed
                numPageTables += pageDir.newPageTable(address);
                
                //Temporarily store the page
                PageTable temp = pageDir.getPageTable(address);

                // Allocate new UserPage if needed
                numPagesMalloced +=  temp.newUserPage(address, auditHistory);

                // Find first null physical page (if any)
                // Array of UserPage cannot be iterated, so use a for loop
                int firstNull = -1;
                for(int k = 0; k < numPageFrames; k++){
                    if(physicalPages[k] == null){
                        firstNull = k;
                        break;
                    }
                }

                if(firstNull == -1){
                    // Add user page to random place in physical pages
                    loadedIndex = rand.nextInt(numPageFrames);
                    physicalPages[loadedIndex] = temp.getUserPage(address);

                    numSwapOuts++; //A page was unloaded from mem
                } else { // If empty space in physical pages, put at end
                    loadedIndex = firstNull;
                    physicalPages[loadedIndex] = temp.getUserPage(address);
                    maxPhysicalPages++;
                    lastWorkingSetSize++;
                    maxWorkingSetSize++;
                }
            }

            if(readOrWrite == 'r'){
                value = physicalPages[loadedIndex].readFrom(address);
                numAccesses += 8;
            } else if (readOrWrite == 'w'){
                physicalPages[loadedIndex].writeTo(address, value);
                numAccesses += 9;
            }
        }

        input.close();

        for(int i = 1; i < auditHistory.getAudit().length; i++){
            System.out.println("\n" + auditHistory.getAudit()[i]);
        }

        //Output summary results
        System.out.println("\n*** Paging Activity Statistics ***");
        System.out.printf("%-35s %s%n", "Number of memory accesses ", "= " + numAccesses);
        numTriples = numAccesses + 1;
        System.out.printf("%-35s %s%n", "Number of triples (1+access) ", "= " + numTriples);
        System.out.printf("%-35s %s%n", "Number of swap ins ", "= " + numSwapIns);
        System.out.printf("%-35s %s%n", "Number of swap outs ", "= " + numSwapOuts);
        System.out.printf("%-35s %s%n", "Number of pages malloced ", "= " + numPagesMalloced);
        System.out.printf("%-35s %s%n", "Number of pages for Page Tables ", "= " + numPageTables);
        System.out.printf("%-35s %s%n", "Number of frames for user", "= " + numPageFrames);
        totalMemCycles = numAccesses + numTriples;
        System.out.printf("%-35s %s%n", "Total memory cycles ", "= " + totalMemCycles);
        cyclesWOVMM = numAccesses;
        System.out.printf("%-35s %s%n", "Cycles without VMM ", "= " + cyclesWOVMM);
        System.out.printf("%-35s %s%n", "Cycles per swap in ", "= " + cyclesPerSwapIn);
        System.out.printf("%-35s %s%n", "Cycles per swap out ", "= " + cyclesPerSwapOut);
        System.out.printf("%-35s %s%n", "Last working set size ", "= " + lastWorkingSetSize);
        System.out.printf("%-35s %s%n", "Max working set size ", "= " + maxWorkingSetSize);
        System.out.printf("%-35s %s%n", "Max physical pages ", "= " + maxPhysicalPages);
        System.out.printf("%-35s %s%n", "Page size ", "= " + pageSize);
        System.out.printf("%-35s %s%n", "Replacement algorithm ", "= " + replacementAlgorithm);
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