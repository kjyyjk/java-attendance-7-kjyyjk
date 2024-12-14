package attendance;

import java.io.BufferedReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Attendances attendances = readAttendances();
    }

    private static Attendances readAttendances() {
        try {
            BufferedReader read = AttendanceFileReader.read();
            return AttendanceFileParser.parseAttendances(read);
        } catch (IOException e) {
            return readAttendances();
        }
    }
}
