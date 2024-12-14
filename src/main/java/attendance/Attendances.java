package attendance;

import static attendance.util.TimeUtils.dateTimeToDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Attendances {
    private List<Attendance> attendanceList = new ArrayList<>();

    public void addAttendance(final Attendance attendance) {
        attendanceList.add(attendance);
    }

    public Attendance getAttendance(final Crew crew, final LocalDate localDate) {
        Attendance attendance = attendanceList.stream()
                .filter(a -> a.getCrew().equals(crew))
                .filter(a -> dateTimeToDate(a.getAttendanceDateTime()).equals(localDate))
                .findAny()
                .orElseGet(null);

        if (attendance == null) {
            //TODO
            return null;
        }

        return attendance;
    }

    public Attendance update(final Attendance oldAttendance, final Crew crew, final LocalDateTime localDateTime) {
        attendanceList.remove(oldAttendance);
        Attendance newAttendance = new Attendance(crew, localDateTime);
        addAttendance(newAttendance);
        return newAttendance;
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
