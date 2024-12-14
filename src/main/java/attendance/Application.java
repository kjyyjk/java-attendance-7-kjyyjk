package attendance;

import java.io.BufferedReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        raedAttendanceFile();
    }

    private static void raedAttendanceFile() {
        try {
            BufferedReader read = AttendanceFileReader.read();
        } catch (IOException e) {

        }
    }
}
