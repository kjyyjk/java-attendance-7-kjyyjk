package attendance;

import static attendance.util.TimeUtils.dateTimeToDate;
import static attendance.view.InputParser.parseAttendanceTime;
import static attendance.view.InputParser.parseDate;
import static attendance.view.InputView.inputAttendanceTime;
import static attendance.view.InputView.inputNickname;
import static attendance.view.InputView.inputUpdateDate;
import static attendance.view.InputView.inputUpdateNickname;

import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttendanceManager {
    public static void attend(final Attendances attendances) {
        Crew crew = getAttendCrew(attendances);
        LocalTime attendanceTime = getTime();
        LocalDateTime attendanceDateTime = LocalDateTime.of(getTodayLocalDate(), attendanceTime);
        Attendance attendance = new Attendance(crew, attendanceDateTime);
        attendances.addAttendance(attendance);
        OutputView.printAttendanceResult(attendance);
    }

    public static void update(final Attendances attendances) {
        Crew crew = getUpdateCrew(attendances);
        LocalDate updateDate = getDate();
        LocalTime updateTime = getTime();
        LocalDateTime localDateTime = LocalDateTime.of(updateDate, updateTime);
        Attendance oldAttendance = attendances.getAttendance(crew, dateTimeToDate(localDateTime));
        Attendance newAttendance = attendances.update(oldAttendance, crew, localDateTime);
        OutputView.printAttendanceUpdateResult(oldAttendance, newAttendance);
    }

    private static LocalDate getDate() {
        try {
            return parseDate(inputUpdateDate());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return getDate();
        }
    }

    private static LocalTime getTime() {
        try {
            return parseAttendanceTime(inputAttendanceTime());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return getTime();
        }
    }

    public static void checkAttendance(final Attendances attendances) {
        Crew crew = getAttendCrew(attendances);
        AttendanceHistory attendanceHistory = attendances.getAttendanceHistory(crew);
        OutputView.printAttendanceHistory(attendanceHistory);
    }

    private static Crew getAttendCrew(final Attendances attendances) {
        try {
            String nickname = inputNickname();
            return attendances.getCrew(nickname);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return getAttendCrew(attendances);
        }
    }

    private static Crew getUpdateCrew(final Attendances attendances) {
        try {
            String nickname = inputUpdateNickname();
            return attendances.getCrew(nickname);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return getUpdateCrew(attendances);
        }
    }

    public static LocalDate getTodayLocalDate() {
        LocalDateTime now = DateTimes.now();
        return now.toLocalDate();
    }
}
