package attendance.view;

import static attendance.util.TimeUtils.getTodayDate;
import static attendance.util.TimeUtils.getTodayDayName;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String OPTION_MESSAGE = "오늘은 12월 %d일 %s입니다. 기능을 선택해 주세요.\n"
            + "1. 출석 확인\n"
            + "2. 출석 수정\n"
            + "3. 크루별 출석 기록 확인\n"
            + "4. 제적 위험자 확인\n"
            + "Q. 종료";

    private static final String INPUT_NICKNAME_MESSAGE = "닉네임을 입력해 주세요.";
    private static final String INPUT_ATTENDANCE_TIME_MESSAGE = "등교 시간을 입력해 주세요.";

    public static String inputOption() {
        printOption();
        return input();
    }

    public static String inputNickname() {
        System.out.println(INPUT_NICKNAME_MESSAGE);
        return input();
    }

    public static String inputAttendanceTime() {
        System.out.println(INPUT_ATTENDANCE_TIME_MESSAGE);
        return input();
    }

    public static void printOption() {
        String message = OPTION_MESSAGE.formatted(getTodayDate(), getTodayDayName());
        System.out.println(message);
    }

    private static String input() {
        return Console.readLine();
    }
}
