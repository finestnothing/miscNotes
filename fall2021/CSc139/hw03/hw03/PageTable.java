package hw03;

public class PageTable{
    private String ptAddress;
    private UserPage[] userPages = new UserPage[4096];

    public PageTable(String address){
        this.ptAddress = address;
    }

    public String getPtAddress(){
        return this.ptAddress;
    }

    public UserPage getUserPage(String address){
        return this.userPages[Integer.parseInt(address.substring(9, 20), 2)];
    }
    public int newUserPage(String address, Audit auditHistory){
        // If userPage isn't made, make a new one
        if(this.userPages[Integer.parseInt(address.substring(9, 20), 2)] == null){
            this.userPages[Integer.parseInt(address.substring(9, 20), 2)] = new UserPage(address);

            // If userPage is made, add to auditHistory
            for(int i = 0; i < userPages.length; i++){
                if(userPages[i] != null && userPages[i].getAddress().equals(address)){
                    auditHistory.append(i, address);
                    break;
                }
            }
            return 1;
        }
        return 0;

    }
}
