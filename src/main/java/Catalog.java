//SOLID principle: Open closed principle

import java.io.IOException;
import java.util.List;

public interface Catalog {
    List<Product> loadProducts() throws IOException;
}
