package attendance;

import attendance.util.TimeUtils;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Attendance {
    private Crew crew;
    private LocalDateTime attendanceDateTime;
    public LateType lateType;

    public Attendance(final Crew crew, final LocalDateTime attendanceDateTime) {
        this.crew = crew;
        this.attendanceDateTime = attendanceDateTime;
        this.lateType = calculateLateType(this.attendanceDateTime);
    }

    public LateType calculateLateType(final LocalDateTime attendanceDateTime) {
        Day day = TimeUtils.getTodayDay();
        LocalTime eduStartTime = day.getEduStartTime();
        LocalTime attendanceTime = attendanceDateTime.toLocalTime();
        return LateType.getType(eduStartTime, attendanceTime);
    }

    public Crew getCrew() {
        return crew;
    }

    public LocalDateTime getAttendanceDateTime() {
        return attendanceDateTime;
    }

    public LateType getLateType() {
        return lateType;
    }
}
