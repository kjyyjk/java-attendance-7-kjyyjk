package attendance;

import java.util.ArrayList;
import java.util.List;

public class Attendances {
    private List<Attendance> attendanceList = new ArrayList<>();

    public void addAttendance(final Attendance attendance) {
        attendanceList.add(attendance);
    }

    public Crew getCrew(final String nickname) {
        Crew crew = attendanceList.stream()
                .map(attendance -> attendance.getCrew())
                .filter(c -> c.isNicknameEquals(nickname))
                .findAny()
                .orElseGet(null);

        if (crew == null) {
            // TODO
        }

        return crew;
    }
}
