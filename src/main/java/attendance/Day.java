package attendance;

import java.time.DayOfWeek;
import java.time.LocalTime;

public enum Day {
    MON(DayOfWeek.MONDAY, "월요일", LocalTime.of(13,0), LocalTime.of(18,0)),
    TUE(DayOfWeek.TUESDAY, "화요일", LocalTime.of(10, 0), LocalTime.of(18, 0)),
    WED(DayOfWeek.WEDNESDAY, "수요일", LocalTime.of(10, 0), LocalTime.of(18, 0)),
    THU(DayOfWeek.THURSDAY, "목요일", LocalTime.of(10, 0), LocalTime.of(18, 0)),
    FRI(DayOfWeek.FRIDAY, "금요일", LocalTime.of(10, 0), LocalTime.of(18, 0)),
    SAT(DayOfWeek.SATURDAY, "토요일", null, null),
    SUN(DayOfWeek.SUNDAY, "일요일", null, null);
//    SAT(DayOfWeek.SATURDAY, "토요일", LocalTime.of(10, 0), LocalTime.of(18, 0)),
//    SUN(DayOfWeek.SUNDAY, "일요일", LocalTime.of(10, 0), LocalTime.of(18, 0));


    private final DayOfWeek dayOfWeek;
    private final String name;
    private final LocalTime eduStartTime;
    private final LocalTime eduFinishTime;

    Day(final DayOfWeek dayOfWeek, final String name, final LocalTime eduStartTime, final LocalTime eduFinishTime) {
        this.dayOfWeek = dayOfWeek;
        this.name = name;
        this.eduStartTime = eduStartTime;
        this.eduFinishTime = eduFinishTime;
    }

    public static Day getDay(DayOfWeek dayOfWeek) {
        for (Day day : values()) {
            if (day.getDayOfWeek().equals(dayOfWeek)) {
                return day;
            }
        }
        return null;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getName() {
        return name;
    }

    public LocalTime getEduStartTime() {
        return eduStartTime;
    }

    public LocalTime getEduFinishTime() {
        return eduFinishTime;
    }
}
