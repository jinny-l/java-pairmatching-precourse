package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewReader {

    public static List<String> read(String fileName) {
        List<String> crews = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String crewName;
            while ((crewName = bufferedReader.readLine()) != null) {
                crews.add(crewName);
            }
            return crews;
        } catch (IOException IOE) {
            throw new IllegalArgumentException();
        }
    }

}
