package hw03;

import java.util.Arrays;

public class Audit {
    public String[] auditMessages = new String[1];

    public Audit(){
        auditMessages[0] = "* * * Done Mallocing a new page * * *";
    }

    public void append(int index, String address){
        auditMessages = Arrays.copyOf(auditMessages, auditMessages.length + 1);
        auditMessages[auditMessages.length-1] = String.format("%s %-10s = %s", auditMessages[auditMessages.length-2], "\npt["+ index + "] ", address);
    }

    public String[] getAudit(){
        return auditMessages;
    }

}
