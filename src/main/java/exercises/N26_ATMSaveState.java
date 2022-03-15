package exercises;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class N26_ATMSaveState {
    public static class RealATMSerializable extends N07_ATM.RealATM{

        public RealATMSerializable() {
        }

        public RealATMSerializable(int maxCellSize) {
            super(maxCellSize);
        }

        public static RealATMSerializable fromSavedState(File file){
            ObjectMapper mapper = new ObjectMapper();

            try {
                return mapper.readValue(FileUtils.readFileToString(file, StandardCharsets.UTF_8), RealATMSerializable.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public String saveStateToFile(File file){
            ObjectMapper mapper = new ObjectMapper();
            String text = "";
            try {
                text = mapper.writeValueAsString(this);
                if(file!=null)
                    FileUtils.write(file, text, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return text;
        }
    }
}
