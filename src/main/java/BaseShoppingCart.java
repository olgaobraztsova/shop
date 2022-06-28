public interface BaseShoppingCart {
    void addItem(Product product, Integer quantity);
    void removeItem(Product product);
}
