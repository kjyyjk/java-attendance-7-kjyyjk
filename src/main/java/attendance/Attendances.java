package attendance;

import static attendance.util.TimeUtils.dateTimeToDate;
import attendance.util.TimeUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Attendances {
    private List<Attendance> attendances = new ArrayList<>();

    public void addAttendance(final Attendance attendance) {
        attendances.add(attendance);
    }

    public Attendance getAttendance(final Crew crew, final LocalDate localDate) {
        Attendance attendance = attendances.stream()
                .filter(a -> a.getCrew().equals(crew))
                .filter(a -> dateTimeToDate(a.getAttendanceDateTime()).equals(localDate))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 아직 수정할 수 없습니다."));

        return attendance;
    }

    public Attendance update(final Attendance oldAttendance, final Crew crew, final LocalDateTime localDateTime) {
        attendances.remove(oldAttendance);
        Attendance newAttendance = new Attendance(crew, localDateTime);
        addAttendance(newAttendance);
        return newAttendance;
    }

    public Crew getCrew(final String nickname) {
        Crew crew = attendances.stream()
                .map(attendance -> attendance.getCrew())
                .filter(c -> c.isNicknameEquals(nickname))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록되지 않은 닉네임입니다."));

        return crew;
    }

    public AttendanceHistory getAttendanceHistory(final Crew crew) {
        List<Attendance> attendanceHistory = this.attendances.stream()
                .filter(attendance -> attendance.getCrew().equals(crew))
                .filter(attendance -> attendance.getAttendanceDateTime().getDayOfMonth() < TimeUtils.getTodayDate())
                .collect(Collectors.toList());
        return new AttendanceHistory(attendanceHistory);
    }
}
