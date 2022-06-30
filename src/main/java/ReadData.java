import java.io.IOException;
import java.util.List;

public interface ReadData {
    public <T> List<T> parse() throws IOException;
}
