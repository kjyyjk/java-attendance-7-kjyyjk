package attendance.view;

import attendance.Attendance;
import attendance.LateType;
import attendance.util.TimeUtils;
import java.time.LocalDateTime;

public class OutputView {
    private static final String ATTENDANCE_RESULT_MESSAGE = "\n%d월 %d일 %s %d:%d (%s)";
    private static final String ATTENDANCE_UPDATE_RESULT_MESSAGE = "\n%d월 %d일 %s %d:%d (%s) -> %d:%d (%s) 수정 완료!";
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

    public static void printAttendanceUpdateResult(final Attendance oldAttendance, final Attendance newAttendance) {
        LocalDateTime oldAttendanceDateTime = oldAttendance.getAttendanceDateTime();
        int month = oldAttendanceDateTime.getMonthValue();
        int date = oldAttendanceDateTime.getDayOfMonth();
        String day = TimeUtils.getDayName(oldAttendanceDateTime.getDayOfWeek());
        int oldHour = oldAttendanceDateTime.getHour();
        int oldMinute = oldAttendanceDateTime.getMinute();
        String oldType = oldAttendance.getLateType().getName();

        LocalDateTime newAttendanceDateTime = newAttendance.getAttendanceDateTime();
        int newHour = newAttendanceDateTime.getHour();
        int newMinute = newAttendanceDateTime.getMinute();
        String newType = newAttendance.getLateType().getName();

        String message = ATTENDANCE_UPDATE_RESULT_MESSAGE.formatted(month, date, day, oldHour, oldMinute, oldType,
                newHour, newMinute, newType);
        System.out.println(message);
    }
}
