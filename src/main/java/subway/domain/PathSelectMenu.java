package subway.domain;

import subway.utils.Validator;
import subway.view.InputView;
import java.util.Scanner;

public class PathSelectMenu {
    private static boolean isPathMenuRunFlag = true;

    private static void pathMenuStop() {
        isPathMenuRunFlag = false;
    }

    public static boolean isPathMenuRun() {
        return isPathMenuRunFlag;
    }

    public static void pathMenuRun(Scanner scanner) {
        isPathMenuRunFlag = true;
        while (isPathMenuRun()) {
            try {
                InputView.printPathMenuInput();
                pathInput(scanner);
            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERROR]" + e.getMessage());
            }
        }
    }

    private static void pathInput(Scanner scanner) throws IllegalArgumentException {
        String inputMsg = scanner.nextLine();
        if (!Validator.isValidPathInput(inputMsg)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
        pathMenuController(inputMsg, scanner);
    }
    private static void pathMenuController(String inputMsg, Scanner scanner) {
        if (inputMsg.equals("B")) {
            pathMenuStop();
            return;
        }
        // 1이면 최단 거리
        // 2이면 최소 거리
    }
}
