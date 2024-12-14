package attendance;

import java.time.Duration;
import java.time.LocalTime;

public enum LateType {
    ABSENCE,
    LATE,
    NOT;

    public static LateType getType(final LocalTime eduStart, final LocalTime attendanceTime) {
        Duration diff = Duration.between(eduStart, attendanceTime);
        long diffMin = diff.toMinutes();
        if (diffMin <= 5) {
            return NOT;
        }

        if (diffMin <= 30) {
            return LATE;
        }

        return ABSENCE;
    }
}
