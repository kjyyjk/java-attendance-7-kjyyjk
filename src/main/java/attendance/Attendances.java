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

    public void update(final Crew crew, final LocalDateTime localDateTime) {
        LocalDate updateDate = dateTimeToDate(localDateTime);
        System.out.println(crew.getNickname());
        System.out.println(updateDate);

        Attendance attendance = attendanceList.stream()
                .filter(a -> a.getCrew().equals(crew))
                .filter(a -> dateTimeToDate(a.getAttendanceDateTime()).equals(updateDate))
                .findAny()
                .orElseGet(null);

        if (attendance == null) {
            // TODO
            return;
        }

        attendanceList.remove(attendance);
        addAttendance(new Attendance(crew, localDateTime));
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
