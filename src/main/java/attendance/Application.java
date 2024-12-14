package attendance;

import java.io.BufferedReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        readAttendances();
    }

    private static void readAttendances() {
        try {
            BufferedReader read = AttendanceFileReader.read();
            AttendanceFileParser.parseAttendances(read);
        } catch (IOException e) {

        }
    }
}
