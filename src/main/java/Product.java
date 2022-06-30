import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class Product {

    @CsvBindByName(column = "id")
    private int id;
    @CsvBindByName(column = "category")
    private String category;
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "manufacturer")
    private String manufacturer;
    @CsvBindByName(column = "price")
    private int price;

    public Product() {
        // Пустой конструктор
    }

    public Product(int id, String category, String name, String manufacturer, int price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                category.equals(product.category) &&
                name.equals(product.name) &&
                manufacturer.equals(product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, manufacturer, price);
    }

    @Override
    public String toString() {
        return
                "{ID}: " + id + ". {Description}: "
                        + name + " (" + manufacturer +
                        ") . {Price}: " + price;
    }
}
