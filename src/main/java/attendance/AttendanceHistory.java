package attendance;

import attendance.util.TimeUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceHistory {
    private List<Attendance> attendances;
    private Map<LateType, Integer> lates = new HashMap<>();

    public AttendanceHistory(List<Attendance> attendanceHistory) {
        this.attendances = sortByDate(attendanceHistory);
        makeLates(attendanceHistory);
    }

    private List<Attendance> sortByDate(List<Attendance> attendanceHistory) {
        Collections.sort(attendanceHistory);
        return attendanceHistory;
    }

    private void makeLates(List<Attendance> attendanceHistory) {
        for (LateType type : LateType.values()) {
            lates.put(type, 0);
        }

        for (LateType type : LateType.values()) {
            for (Attendance attendance : attendanceHistory) {
                if (attendance.getLateType().equals(type)) {
                    lates.put(type, lates.get(type) + 1);
                }
            }
        }

        long abCount = 0;
        for (int i = 1; i < TimeUtils.getTodayDate(); i++) {
            if (!RunDate.isRunDate(i)) {
                continue;
            }
            int day = i;
            long count = attendances.stream()
                    .map(attendance -> attendance.getAttendanceDateTime())
                    .map(localDateTime -> localDateTime.getDayOfMonth())
                    .filter(a -> a == day)
                    .count();

            if (count == 0) {
                abCount++;
            }
        }

        lates.put(LateType.ABSENCE, lates.get(LateType.ABSENCE) + (int) abCount);
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public Map<LateType, Integer> getLates() {
        return lates;
    }
}
