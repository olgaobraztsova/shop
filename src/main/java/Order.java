import java.time.LocalDate;
import java.util.Map;


public class Order {

    private static int counter;
    private int id;
    private LocalDate date;
    private User user;
    private Map<Product, Integer> products;
    private Boolean deliveryStatus;

    public Order(LocalDate date, Map<Product, Integer> products, User user){
        this.id = counter;
        this.date = date;
        this.user = user;
        this.products = products;
        counter++;
    }

    public void generateReceipt(){
        double totalAmount = 0;
        System.out.println("Dear " + user.getName());
        System.out.println("Please find the receipt for your order No. " + id + ":");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            double amount = entry.getKey().getPrice() * entry.getValue();
            System.out.println(entry.getKey().getName() + " : " + entry.getValue() + " pcs : " + amount + " RUB. ");
            totalAmount += amount;
        }
        System.out.println("Total order amount: " + totalAmount);
    }


}
