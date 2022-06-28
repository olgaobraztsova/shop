import com.opencsv.CSVReader;
//import com.opencsv.bean.ColumnPositionMappingStrategy;
//import com.opencsv.bean.CsvToBeanBuilder;

import com.opencsv.bean.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToBeanReader implements ReadData{

        String[] columnMapping;
        String fileName;

    @Override
    public <T> List<T> parse(String[] mapping, String filename, Class<T> tClass) throws IOException {
        List<T> productsList = null;

        try (CSVReader csvReader = new CSVReader(new FileReader(filename))) {
            ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(tClass);
            strategy.setColumnMapping(mapping);
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
