package attendance.view;

public class InputParser {
    public static String parseOption(final String option) {
        return option;
    }

    public static int parseInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
