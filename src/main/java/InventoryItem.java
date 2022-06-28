public class InventoryItem {

    private int id;
    private int quantity;

    public InventoryItem(){

    }

    public InventoryItem(int id, int quantity){
        this.id = id;
        this.quantity = quantity;
    }

    public int getID() {
        return id;
    }

    public int getItemQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "product=" + id +
                ", quantity=" + quantity +
                '}';
    }
}



