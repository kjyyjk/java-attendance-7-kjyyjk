package attendance.view;

import attendance.util.TimeUtils;
import java.time.LocalDate;
import java.time.LocalTime;

public class InputParser {
    public static String parseOption(final String option) {
        return option;
    }

    public static LocalDate parseDate(final String date) {
        return LocalDate.of(2024, 12, parseInt(date));
    }

    public static LocalTime parseAttendanceTime(final String time) {
        return LocalTime.parse(time);
    }

    public static int parseInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
