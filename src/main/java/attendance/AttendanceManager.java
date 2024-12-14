package attendance;

import static attendance.view.InputParser.parseAttendanceTime;
import static attendance.view.InputView.inputAttendanceTime;
import static attendance.view.InputView.inputNickname;

import java.time.LocalTime;

public class AttendanceManager {
    public static void attend(Attendances attendances) {
        String nickname = inputNickname();
        LocalTime attendanceTime = parseAttendanceTime(inputAttendanceTime());
        System.out.println(attendanceTime);
    }
}
