package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TODO: bufferedReader의 IOException을 어떻게 처리할지 고민 필요
public class CrewFileReader {

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
