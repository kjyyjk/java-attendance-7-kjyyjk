package attendance;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.DayOfWeek;
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
}
