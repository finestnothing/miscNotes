package CSc139.hw03;

public class PageDirectory{
    private PageTable[] pageTables = new PageTable[4096];

    public PageDirectory(){
    }

    public PageTable getPageTable(String address){
        return pageTables[Integer.parseInt(address.substring(0,10), 2)];
    }

    public int newPageTable(String address){
        // If pageTable isn't made, make a new one
        if(this.pageTables[Integer.parseInt(address.substring(0,10), 2)] == null){
            this.pageTables[Integer.parseInt(address.substring(0,10),2 )] = new PageTable(address);
            return 1;
        }
        return 0;
    }

    public PageTable[] getPageTables() {
        return pageTables;
    }

}

