package attendance.view;

import attendance.Attendance;
import attendance.AttendanceHistory;
import attendance.LateType;
import attendance.RunDate;
import attendance.util.TimeUtils;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String ATTENDANCE_RESULT_MESSAGE = "\n%s월 %s일 %s %s:%s (%s)";
    private static final String ATTENDANCE_HISTORY_RESULT_MESSAGE = "%s월 %s일 %s %s:%s (%s)";
    private static final String ABSENCE_RESULT_MESSAGE = "12월 %s일 %s --:-- (결석)";
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

        String message = ATTENDANCE_RESULT_MESSAGE.formatted(month, plusZero(String.valueOf(date)),
                plusZero(String.valueOf(day)), plusZero(String.valueOf(hour)), plusZero(String.valueOf(minute)),
                type);
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

    public static void printAttendanceHistory(final AttendanceHistory attendanceHistory) {
        System.out.println("\n이번 달 빙티의 출석 기록입니다.\n");
        List<Attendance> attendances = attendanceHistory.getAttendances();
        for (int i = 1; i < TimeUtils.getTodayDate(); i++) {
            if (!RunDate.isRunDate(i)) {
                continue;
            }
            int day = i;

            Attendance attendance = attendances.stream()
                    .filter(a -> a.getAttendanceDateTime().getDayOfMonth() == day)
                    .findAny()
                    .orElse(null);

            if (attendance != null) {
                LocalDateTime attendanceDateTime = attendance.getAttendanceDateTime();
                int date = attendanceDateTime.getDayOfMonth();
                String dayName = TimeUtils.getDayName(attendanceDateTime.getDayOfWeek());
                int hour = attendanceDateTime.getHour();
                int minute = attendanceDateTime.getMinute();
                LateType lateType = attendance.getLateType();
                String type = lateType.getName();

                String message = ATTENDANCE_HISTORY_RESULT_MESSAGE.formatted(12, plusZero(String.valueOf(date)),
                        dayName, plusZero(String.valueOf(hour)), plusZero(String.valueOf(minute)),
                        type);
                System.out.println(message);
            }

            if (attendance == null) {
                String dayName = TimeUtils.getDayName(LocalDateTime.of(2024, 12, day, 0, 0).getDayOfWeek());
                String message = ABSENCE_RESULT_MESSAGE.formatted(plusZero(String.valueOf(day)), dayName);
                System.out.println(message);
            }
        }

        System.out.println();
        Map<LateType, Integer> lates = attendanceHistory.getLates();
        for (LateType type : lates.keySet()) {
            System.out.println("%s: %d회".formatted(type.getName(), lates.get(type)));
        }
    }

    private static String plusZero(final String number) {
        if (number.length() == 1) {
            return "0" + number;
        }
        return number;
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
