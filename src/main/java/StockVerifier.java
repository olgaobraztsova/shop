import java.io.IOException;

// SOLID principle: Interface Segregation
public interface StockVerifier {
    int checkAvailability(Product product) throws IOException;
}
