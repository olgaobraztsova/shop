import java.io.IOException;
import java.util.List;

public interface ReadData {
    public <T> List<T> parse(String[] mapping, String filename, Class<T> tClass) throws IOException;
}
