package attendance;

import static attendance.util.TimeUtils.dateTimeToDate;
import static attendance.view.InputParser.parseAttendanceTime;
import static attendance.view.InputParser.parseDate;
import static attendance.view.InputView.inputAttendanceTime;
import static attendance.view.InputView.inputNickname;
import static attendance.view.InputView.inputUpdateDate;
import static attendance.view.InputView.inputUpdateNickname;
import static attendance.view.InputView.inputUpdateTime;

import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttendanceManager {
    public static void attend(final Attendances attendances) {
        Crew crew = attendances.getCrew(inputNickname());
        LocalTime attendanceTime = parseAttendanceTime(inputAttendanceTime());
        LocalDateTime attendanceDateTime = LocalDateTime.of(getTodayLocalDate(), attendanceTime);
        Attendance attendance = new Attendance(crew, attendanceDateTime);
        attendances.addAttendance(attendance);
        OutputView.printAttendanceResult(attendance);
    }

    public static void update(final Attendances attendances) {
        Crew crew = attendances.getCrew(inputUpdateNickname());
        LocalDate updateDate = parseDate(inputUpdateDate());
        LocalTime updateTime = parseAttendanceTime(inputUpdateTime());
        LocalDateTime localDateTime = LocalDateTime.of(updateDate, updateTime);
        Attendance oldAttendance = attendances.getAttendance(crew, dateTimeToDate(localDateTime));
        Attendance newAttendance = attendances.update(oldAttendance, crew, localDateTime);
        OutputView.printAttendanceUpdateResult(oldAttendance, newAttendance);
    }

    public static void checkAttendance(final Attendances attendances) {
        Crew crew = attendances.getCrew(inputNickname());
        attendances.getAttendanceHistory(crew);
    }

    public static LocalDate getTodayLocalDate() {
        LocalDateTime now = DateTimes.now();
        return now.toLocalDate();
    }
}
