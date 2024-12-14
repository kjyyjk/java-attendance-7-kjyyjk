package attendance.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AttendanceFileReader {
    private static final String PATH = "src/main/resources/attendances.csv";

    public static BufferedReader read() throws IOException {
        return new BufferedReader(new FileReader(PATH));
    }
}
