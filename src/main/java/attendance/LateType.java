package attendance;

import java.time.Duration;
import java.time.LocalTime;

public enum LateType {
    ABSENCE("결석"),
    LATE("지각"),
    NOT("출석");

    private final String name;

    LateType(final String name) {
        this.name = name;
    }

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

    public String getName() {
        return name;
    }
}
