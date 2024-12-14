package attendance;

import static attendance.view.InputParser.parseOption;
import static attendance.view.InputView.inputOption;

import attendance.file.AttendanceFileParser;
import attendance.file.AttendanceFileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Attendances attendances = readAttendances();
        while(true) {
            String option = parseOption(inputOption());
            if (!runByOption(option, attendances)) {
                break;
            }
        }
    }

    private static boolean runByOption(final String option, final Attendances attendances) {
        if (option.equals("1")) {
            AttendanceManager.attend(attendances);
            return true;
        }

        if (option.equals("2")) {
            AttendanceManager.update(attendances);
            return true;
        }

        if (option.equals("3")) {
            // TODO
            return true;
        }

        if (option.equals("4")) {
            // TODO
            return true;
        }

        if (option.equals("Q")) {
            return false;
        }

        // TODO
        return false;
    }

    private static Attendances readAttendances() {
        try {
            BufferedReader read = AttendanceFileReader.read();
            return AttendanceFileParser.parseAttendances(read);
        } catch (IOException e) {
            return readAttendances();
        }
    }
}
