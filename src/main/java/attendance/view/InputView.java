package attendance.view;

import attendance.Day;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class InputView {
    private static final String OPTION_MESSAGE = "오늘은 12월 %d일 %s입니다. 기능을 선택해 주세요.\n"
            + "1. 출석 확인\n"
            + "2. 출석 수정\n"
            + "3. 크루별 출석 기록 확인\n"
            + "4. 제적 위험자 확인\n"
            + "Q. 종료";

    private static final String INPUT_NICKNAME_MESSAGE = "닉네임을 입력해 주세요.";

    public static String inputOption() {
        printOption();
        return input();
    }

    public static String inputNickname() {
        System.out.println(INPUT_NICKNAME_MESSAGE);
        return input();
    }

    public static void printOption() {
        String message = OPTION_MESSAGE.formatted(getTodayDate(), getTodayDay());
        System.out.println(message);
    }

    private static int getTodayDate() {
        LocalDateTime now = DateTimes.now();
        return now.getDayOfMonth();
    }

    private static String getTodayDay() {
        LocalDateTime now = DateTimes.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        return Day.getDayName(dayOfWeek);
    }

    private static String input() {
        return Console.readLine();
    }
}
