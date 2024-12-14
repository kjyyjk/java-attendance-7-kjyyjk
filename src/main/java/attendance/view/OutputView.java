package attendance.view;

import attendance.Attendance;
import attendance.LateType;
import attendance.util.TimeUtils;
import java.time.LocalDateTime;

public class OutputView {
    private static final String ATTENDANCE_RESULT_MESSAGE = "\n%d월 %d일 %s %d:%d (%s)";
    public static void printAttendanceResult(final Attendance attendance) {
        LocalDateTime attendanceDateTime = attendance.getAttendanceDateTime();
        int month = attendanceDateTime.getMonthValue();
        int date = attendanceDateTime.getDayOfMonth();
        String day = TimeUtils.getDayName(attendanceDateTime.getDayOfWeek());
        int hour = attendanceDateTime.getHour();
        int minute = attendanceDateTime.getMinute();
        LateType lateType = attendance.getLateType();
        String type = lateType.getName();

        String message = ATTENDANCE_RESULT_MESSAGE.formatted(month, date, day, hour, minute, type);
        System.out.println(message);
    }
}
