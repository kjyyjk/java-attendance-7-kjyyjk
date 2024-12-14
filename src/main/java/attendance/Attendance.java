package attendance;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Attendance {
    private Crew crew;
    private LocalDateTime attendanceDateTime;
    public LateType type;

    public Attendance(final Crew crew, final LocalDateTime attendanceDateTime) {
        this.crew = crew;
        this.attendanceDateTime = attendanceDateTime;
        this.type = calculateLateType(this.attendanceDateTime);
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
}
