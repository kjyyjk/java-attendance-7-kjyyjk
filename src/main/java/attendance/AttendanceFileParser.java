package attendance;

import java.io.BufferedReader;
import java.io.IOException;

public class AttendanceFileParser {
    public static void parseAttendances(final BufferedReader br) throws IOException {
        String string;
        br.readLine();
        while ((string = br.readLine()) != null) {
            String[] split = string.split(",");
            String nickname = split[0];
            Crew crew = new Crew(nickname);
        }
    }
}
