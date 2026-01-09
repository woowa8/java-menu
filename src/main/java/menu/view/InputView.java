package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    // 코치 이름 입력 받는 부분
    public List<String> inputUsers() {
        return retryOnError(() -> {
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            String input = Console.readLine();

            System.out.println();

            return inputParser.parseUser(input);
        });
    }

    // 코치별로 못 먹는 음식 입력 받는 부분
    public List<String> inputExceptionMenu(String userName) {
        return retryOnError(() -> {
            System.out.println(userName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String input = Console.readLine();
            if(input.isEmpty() || input == null){
                System.out.println();
                return new ArrayList<String>();  // 빈 리스트 출력
            }

            System.out.println();
            return inputParser.parseMenu(input);
        });
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
