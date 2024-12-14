package attendance;

import static attendance.view.InputParser.parseAttendanceTime;
import static attendance.view.InputView.inputAttendanceTime;
import static attendance.view.InputView.inputNickname;

import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttendanceManager {
    public static void attend(final Attendances attendances) {
        Crew crew = attendances.getCrew(inputNickname());
        LocalTime attendanceTime = parseAttendanceTime(inputAttendanceTime());
        LocalDateTime attendanceDateTime = LocalDateTime.of(getTodayDate(), attendanceTime);
        Attendance attendance = new Attendance(crew, attendanceDateTime);
        attendances.addAttendance(attendance);
        OutputView.printAttendanceResult(attendance);
    }

    public static LocalDate getTodayDate() {
        LocalDateTime now = DateTimes.now();
        return now.toLocalDate();
    }
}
