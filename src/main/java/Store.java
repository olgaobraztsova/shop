
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store implements Catalog, StockVerifier{

    //it's a singleton, since the program can have only one stock
    private static Store store;

    private List<Product> products;
    private Map<Product, Integer> availability = new HashMap<>();


    // private constructor of the singleton
    private Store() {
    }

    public static Store getInstance() {
        if (store == null) {
            store = new Store();
        }
        return store;
    }


    //method for loading products from CSV file
    public List<Product> loadProducts() throws IOException {

        //creating a mapping strategy
        String[] columnMapping = {"id", "category", "name", "manufacturer", "price"};
        //CSV filename to read the data
        String fileName = "products1.csv";
        //достаем данные из CSV файла и парсим в объект типа List

        ReadData productsList = new CsvToBeanReader(columnMapping, fileName, Product.class);
        products = productsList.parse();

        return products;
    }

    public void displayProducts(){
        System.out.println("The following products are available for purchase:");
        for(Product product : products) {
            System.out.println(product);
        }
    }

    public Product getProduct(int id){
        for (Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    //method for loading available quantities in the stock
    public void loadQuantities() throws IOException {
        if (products != null) {
            String[] columnMapping = {"id", "quantity"};
            String fileName = "stock.csv";
            ReadData quantitiesInStock = new CsvToBeanReader(columnMapping, fileName, InventoryItem.class);
            List<InventoryItem> list = quantitiesInStock.parse();

            if (products.size() == list.size()) {
                for (int i = 0; i < list.size(); i++) {
                    if (products.get(i).getId() == list.get(i).getID()) {
                        availability.put(products.get(i), list.get(i).getItemQuantity());
                    } else {
                        System.out.println("Error: Products list doesn't match inventory list");
                    }
                }
            }
        }
    }


    //checking a single product's availability in stock
    @Override
    public int checkAvailability(Product product) throws IOException {

        if(availability.containsKey(product)) {
            return availability.get(product);
        } else {
            System.out.println("Product " + product.getName() + " " + product.getManufacturer()
                    + " is not available in stock");
        }

        return 0;
    }

    //checking the entire stock's quantities
    public void checkStock() {

        for(Map.Entry<Product, Integer> entry : availability.entrySet()) {
            System.out.println(entry.getKey().getName() + " "
                    + entry.getKey().getManufacturer()
                    + " --> " + entry.getValue());
        }
    }

    // deducting items from stock when ordered
    public void deductFromStock(Map<Product, Integer> orderedItems){
        for (Map.Entry<Product, Integer> entry : orderedItems.entrySet()) {
            int currentStockValue = availability.get(entry.getKey());
            availability.replace(entry.getKey(), currentStockValue, currentStockValue - entry.getValue());
        }
    }
}
