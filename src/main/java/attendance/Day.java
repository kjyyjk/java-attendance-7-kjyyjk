package attendance;

import java.time.DayOfWeek;

public enum Day {
    MON(DayOfWeek.MONDAY, "월요일"),
    TUE(DayOfWeek.TUESDAY, "화요일"),
    WED(DayOfWeek.WEDNESDAY, "수요일"),
    THU(DayOfWeek.THURSDAY, "목요일"),
    FRI(DayOfWeek.FRIDAY, "금요일"),
    SAT(DayOfWeek.SATURDAY, "토요일"),
    SUN(DayOfWeek.SUNDAY, "일요일");

    private final DayOfWeek dayOfWeek;
    private final String name;

    Day(final DayOfWeek dayOfWeek, final String name) {
        this.dayOfWeek = dayOfWeek;
        this.name = name;
    }

    public static String getDayName(final DayOfWeek dayOfWeek) {
        for (Day day : values()) {
            if (day.getDayOfWeek().equals(dayOfWeek)) {
                return day.getName();
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
}
