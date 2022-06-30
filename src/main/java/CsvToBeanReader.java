import com.opencsv.CSVReader;

import com.opencsv.bean.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToBeanReader implements ReadData {

    private String[] columnMapping;
    private String fileName;
    private Class tClass;

    public CsvToBeanReader(String[] columnMapping, String filename, Class tClass) {
        this.columnMapping = columnMapping;
        this.fileName = filename;
        this.tClass = tClass;
    }

    @Override
    public <T> List<T> parse() throws IOException {
        List<T> productsList = null;

        try (CSVReader csvReader = new CSVReader(new FileReader(this.fileName))) {
            ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(this.tClass);
            strategy.setColumnMapping(this.columnMapping);
            CsvToBean<T> csv = new CsvToBeanBuilder<T>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            productsList = csv.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productsList;

    }


}
