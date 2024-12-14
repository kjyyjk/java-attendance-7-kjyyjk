package attendance.view;

import attendance.RunDate;
import attendance.util.TimeUtils;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class InputParser {
    public static String parseOption(final String option) {
        return option;
    }

    public static LocalDate parseDate(final String date) {
        try {
            validateRunDate(date);
            return LocalDate.of(2024, 12, parseInt(date));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
    }

    private static void validateRunDate(String date) {
        int temp = Integer.parseInt(date);
        String day = TimeUtils.getDayName(LocalDateTime.of(2024, 12, temp, 0, 0).getDayOfWeek());
        if (!RunDate.isRunDate(temp)) {
            throw new IllegalArgumentException("[ERROR] 12월 %d일 %s은 등교일이 아닙니다.".formatted(temp, day));
        }
    }

    public static LocalTime parseAttendanceTime(final String time) {
        try {
            return LocalTime.parse(time);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
    }

    public static int parseInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
    }
}
