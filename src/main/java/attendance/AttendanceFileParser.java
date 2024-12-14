package attendance;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AttendanceFileParser {
    public static Attendances parseAttendances(final BufferedReader br) throws IOException {
        String string;
        Attendances attendances = new Attendances();

        br.readLine();
        while ((string = br.readLine()) != null) {
            String[] split = string.split(",");
            String nickname = split[0];
            Crew crew = new Crew(nickname);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(split[1], formatter);

            Attendance attendance = new Attendance(crew, dateTime);
            attendances.addAttendance(attendance);
        }

        return attendances;
    }
}
