import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements BaseShoppingCart {

    protected Map<Product, Integer> items = new HashMap<>();
    User user;
    int totalItems;
    Double totalAmount;
    Store store = Store.getInstance();

    public ShoppingCart(User user){
        this.user = user;
    }

    @Override
    public void addItem(Product product, Integer addQuantity) {
        if(items.containsKey(product)){
            int qty = items.get(product);
            items.put(product, qty + addQuantity);
        } else {
            items.put(product, addQuantity);
        }
        totalItems = totalItems + addQuantity;
   }

    @Override
    public void removeItem(Product product) {
        if(items.containsKey(product)){
            int qtyInCart = items.get(product);
            if(qtyInCart > 1) {
                items.put(product, qtyInCart - 1);
            } else if(qtyInCart == 1) {
                items.remove(product);
            }
        } else {
            System.out.println("No such product in the cart");
        };
        totalItems--;
    }

    public int cartTotalQuantity(){
        return totalItems;
    }

    public Double cartTotalAmount(){
        //TODO
        return null;
    }

    public Order createOrder(){
        //create order by adding all items from the cart and generating receipt
        LocalDate date = LocalDate.now();
        Order order = new Order(date, items, user);
        order.generateReceipt();

        // the ordered items are deducted from the stock
        store.deductFromStock(items);

        //the cart gets cleared
        items.clear();
        totalItems = 0;
        return order;
    }

    //method for displaying the current contents of the cart
    public void displayItemsInCart(){
        System.out.println("Dear " + user.getName() + ", your cart contains the following items:");
        for(Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getKey().getManufacturer() +
                    " -> " + entry.getValue() + " pcs");
        }

    }
}
