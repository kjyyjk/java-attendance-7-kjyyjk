package attendance;

import java.util.List;

public enum RunDate {
    DEC(List.of(2, 3, 4, 5, 6, 9, 10, 11, 12, 13, 16, 17, 18, 19, 20, 23, 24, 26, 27, 30, 31));

    private List<Integer> dates;

    RunDate(List<Integer> dates) {
        this.dates = dates;
    }

    public static boolean isRunDate(final int date) {
        if (DEC.dates.contains(date)) {
            return true;
        }
        return false;
    }


}
