package hw03;

public class UserPage{
    private String address;
    private int[] values = new int[4096];

    public String getAddress() {
        return this.address;
    }

    public void writeTo(String address, int value){
        this.values[Integer.parseInt(address.substring(20), 2)] = value;
    }

    public int readFrom(String address){
        return this.values[Integer.parseInt(address.substring(20), 2)];
    }

    public UserPage(String address){
        this.address = address;
    }

}