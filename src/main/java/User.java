import java.util.List;

public class User {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Integer> orders;

    public User(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Integer> getOrders() {
        return orders;
    }

    public void addOrder(int orderID) {
        orders.add(orderID);
    }
}
