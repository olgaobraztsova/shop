import java.io.IOException;

public interface StockVerifier {
    int checkAvailability(Product product) throws IOException;
}
