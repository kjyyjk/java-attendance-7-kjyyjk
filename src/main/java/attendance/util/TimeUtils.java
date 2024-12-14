package attendance.util;

import attendance.Day;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeUtils {
    public static int getTodayDate() {
        LocalDateTime now = DateTimes.now();
        return now.getDayOfMonth();
    }

    public static Day getTodayDay() {
        LocalDateTime now = DateTimes.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        return Day.getDay(dayOfWeek);
    }

    public static String getTodayDayName() {
        return getTodayDay().getName();
    }

    public static LocalTime dateTimeToTime(final LocalDateTime dateTime) {
        return dateTime.toLocalTime();
    }
    public static LocalDate dateTimeToDate(final LocalDateTime dateTime) {
        return dateTime.toLocalDate();
    }

    public static String getDayName(DayOfWeek dayOfWeek) {
        return Day.getDay(dayOfWeek).getName();
    }
}
