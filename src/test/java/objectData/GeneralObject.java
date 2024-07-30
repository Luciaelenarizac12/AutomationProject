package objectData;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GeneralObject {

    protected void fromJsonToObject(String filePath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON from the provided path and update the current object
            objectMapper.readerForUpdating(this).readValue(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
