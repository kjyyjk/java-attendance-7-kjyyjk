package attendance;

import java.util.ArrayList;
import java.util.List;

public class Attendances {
    private List<Attendance> attendanceList = new ArrayList<>();

    public void addAttendance(final Attendance attendance) {
        attendanceList.add(attendance);
    }
}
